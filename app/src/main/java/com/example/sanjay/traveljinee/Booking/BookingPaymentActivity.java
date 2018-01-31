package com.example.sanjay.traveljinee.Booking;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Booking.Paypal.PayPalPayment.MainPayPalPayment;
import com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails.DetailsMain;
import com.example.sanjay.traveljinee.Booking.Paypal.TokenModel;
import com.example.sanjay.traveljinee.Booking.Verification.VerificationActivity;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APIPayPal;
import com.example.sanjay.traveljinee.StringClass;
import com.google.gson.Gson;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingPaymentActivity extends AppCompatActivity {

    String paymentmodel;
    MainPayPalPayment model = null;
    String payid;
    String auth;
    String token;

    private static final String TAG = "asdf";
    ImageView esewa, paypal;

    ProgressDialog dialog;

    PayPalConfiguration m_configuration;
    // the id is the link to the paypal account, we have to create an app and get its id
    String m_paypalClientId = new StringClass().getPaypal_Client_Id();
    Intent m_service;
    int m_paypalRequestCode = 999; // or any number you want

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_payment);


        paypal = findViewById(R.id.imgpaypal);

        m_configuration = new PayPalConfiguration()
                .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX) // sandbox for test, production for real
                .clientId(m_paypalClientId);

        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration); // configuration above
        startService(m_service); // paypal service, listening to calls to paypal app

        paypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paypalpayment();
            }
        });
    }

    private void paypalpayment() {
        Toast.makeText(BookingPaymentActivity.this, "Paypal Clicked!", Toast.LENGTH_SHORT).show();

        BigDecimal decimal = new BigDecimal(Double.parseDouble(String.valueOf(1)));

        PayPalPayment payment = new PayPalPayment(decimal, "USD", "Total Booking Payment", PayPalPayment.PAYMENT_INTENT_SALE);

//                PayPalPayment cart = new PayPalPayment(new BigDecimal(m_cart.getValue()), "USD", "Cart",
//                        PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(BookingPaymentActivity.this, PaymentActivity.class); // it's not paypalpayment, it's paymentactivity !
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == m_paypalRequestCode) {
            if (resultCode == Activity.RESULT_OK) {
                // we have to confirm that the payment worked to avoid fraud
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if (confirmation != null) {

                    String userName = new StringClass().getPaypal_Client_Id();
                    String passWord = new StringClass().getPaypal_Secrent_Key();
                    String base = userName + ":" + passWord;
                    auth = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

                    getAccessTokensss(auth);

                    String state = confirmation.getProofOfPayment().getState();
                    if (state.equals("approved")) // if the payment worked, the state equals approved
                    {
                        dialog = new ProgressDialog(BookingPaymentActivity.this);
                        dialog.setMessage("Loading For Payment....");
                        dialog.setTitle("Paypal Payment");
                        dialog.show();
                        dialog.setCancelable(false);

                        Toast.makeText(this, "Approved" + confirmation.getProofOfPayment(), Toast.LENGTH_SHORT).show();
//                        Log.d("asdf", "onActivityResult: " + confirmation.getProofOfPayment() + "   " + confirmation.getEnvironment());
//                        Log.d("asdf", "onActivityResult: " + confirmation.describeContents() + "   " + confirmation.toJSONObject());
//                        Log.d("asdf", "onActivityResult: " + confirmation.getEnvironment() + "  " + confirmation.getPayment());
                        try {
                            paymentmodel = confirmation.toJSONObject().toString(4);
                            model = new Gson().fromJson(paymentmodel, MainPayPalPayment.class);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (model != null) {
                            payid = model.getResponse().getId();
                            Log.d("asdf", "onActivityResult: " + payid);
                        }


                    } else
                        Toast.makeText(this, "Not Approved", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(this, "Null ", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void getSalesDetails(String pay_id, String access_token) {
        Log.d(TAG, pay_id + "getSalesDetails: " + access_token);
        APIInterface api = APIPayPal.getApiService();
//        String tok = "Bearer Token " + Base64.encodeToString(access_token.getBytes(), Base64.NO_WRAP);
        String tok = "Bearer " + access_token;
        Call<DetailsMain> call = api.getDetailsPayment(pay_id, tok);

        call.enqueue(new Callback<DetailsMain>() {
            @Override
            public void onResponse(Call<DetailsMain> call, Response<DetailsMain> response) {
                dialog.dismiss();
                Log.d(TAG, "onResponse: aayooooooooooooooooooooooo  ");
                if (response.isSuccessful()) {
                    Intent intent = new Intent(BookingPaymentActivity.this, VerificationActivity.class);
                    intent.putExtra("verificationmodel",new Gson().toJson(response.body()));
                    startActivity(intent);
                    Log.d(TAG, "onResponse: " + new Gson().toJson(response.body()));
                    Toast.makeText(BookingPaymentActivity.this, "Response Ayo" + response.body(), Toast.LENGTH_SHORT).show();
                } else {
                    Log.d(TAG, "onResponse asdf s:  " + new Gson().toJson(response.body()));
                }
            }

            @Override
            public void onFailure(Call<DetailsMain> call, Throwable t) {
                getSalesDetails(payid,token);
                Log.d("abcccd", "onFailure: " + t);
                Toast.makeText(BookingPaymentActivity.this, "Faile vayoooo", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAccessTokensss(final String auth) {
        APIInterface api = APIPayPal.getApiService();
        Call<TokenModel> call = api.getToken(auth, "client_credentials");
        call.enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                Toast.makeText(BookingPaymentActivity.this, "Response", Toast.LENGTH_SHORT).show();
                Log.d("abcccd", new Gson().toJson(response.body().getAccessToken()));
                token = response.body().getAccessToken();

                getSalesDetails(payid, token);
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
                getAccessTokensss(auth);
                Log.d("abccc", "onFailure: " + t);
                Toast.makeText(BookingPaymentActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
