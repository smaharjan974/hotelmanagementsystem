package com.example.sanjay.traveljinee.Booking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sanjay.traveljinee.CustomModel.BookingCustomModel;
import com.example.sanjay.traveljinee.CustomModel.BookingWithHotelDetails;
import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModelRoomDeal;
import com.example.sanjay.traveljinee.Model.Booking.BookingMain;
import com.example.sanjay.traveljinee.Model.CountryListModel;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.LoginMain;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.LoginModel;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APICountry;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.example.sanjay.traveljinee.SignUPandLogin.LoginActivity;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity {

    AutoCompleteTextView country;
    List<String> countrylist;
    ArrayAdapter<String> adapter;

    LinearLayout booking;
    HotelDetailsWithModelRoomDeal hotelDetailsWithModelRoomDeal;
    TextInputEditText firstname, middlename, lastname, emailaddress, phonenumber;
    EditText specialrequest;

    Date indate, outdate;
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    Double totalprice;
    long diffDays;
    CheckBox checkbox;
    SharedPreferences preferences;

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        preferences = getSharedPreferences("login", MODE_PRIVATE);

        country = findViewById(R.id.country);
        booking = findViewById(R.id.booking);
        checkbox = findViewById(R.id.checkbox);
        firstname = findViewById(R.id.firstname);
        middlename = findViewById(R.id.middlename);
        lastname = findViewById(R.id.lastname);
        emailaddress = findViewById(R.id.emailaddress);
        phonenumber = findViewById(R.id.phonenumber);
        specialrequest = findViewById(R.id.specialrequest);

        String model = getIntent().getStringExtra("roomdeal");
        hotelDetailsWithModelRoomDeal = new Gson().fromJson(model, HotelDetailsWithModelRoomDeal.class);

        String checkindate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckindate();
        String checkoutdate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckoutdate();
        try {
            indate = myFormat.parse(checkindate);
            outdate = myFormat.parse(checkoutdate);

            long diff = outdate.getTime() - indate.getTime();

            diffDays = diff / (24 * 60 * 60 * 1000);
            double price = diffDays * Integer.parseInt(hotelDetailsWithModelRoomDeal.getRoomDealModel().getPrice());

            totalprice = price;

        } catch (ParseException e) {
            e.printStackTrace();
        }

        APIInterface api = APICountry.getApiService();
        Call<List<CountryListModel>> call = api.getcountrylist();

        call.enqueue(new Callback<List<CountryListModel>>() {
            @Override
            public void onResponse(Call<List<CountryListModel>> call, Response<List<CountryListModel>> response) {
                if (response.isSuccessful()) {
                    countrylist = new ArrayList<>();
                    for (int i = 0; i < response.body().size(); i++) {
                        countrylist.add(response.body().get(i).getName());
                    }
                    adapter = new ArrayAdapter<String>(BookingActivity.this, android.R.layout.simple_list_item_1, countrylist);
                    country.setAdapter(adapter);
                }
            }
            @Override

            public void onFailure(Call<List<CountryListModel>> call, Throwable t) {

            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new ProgressDialog(BookingActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Loading");
                dialog.setMessage("Booking Process is Going. Please Wait...");
                dialog.show();

                if (checkbox.isChecked()) {
                    String model = preferences.getString("username","");

                   if(model.equals("")){
                       dialog.dismiss();
                       startActivity(new Intent(BookingActivity.this, LoginActivity.class).putExtra("check","booking").putExtra("roomdeal",new Gson().toJson(hotelDetailsWithModelRoomDeal)));
                   }else {
                       LoginMain mainmodel = new Gson().fromJson(model,LoginMain.class);
                       Integer hotelid = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getDetails().getHotelId().toString());
                       Integer roomid = Integer.parseInt(hotelDetailsWithModelRoomDeal.getRoomDealModel().getRoomId().toString());
                       String fn = firstname.getText().toString();
                       String mn = middlename.getText().toString();
                       String lm = lastname.getText().toString();
                       String email = emailaddress.getText().toString();
                       String phone = phonenumber.getText().toString();
                       String countryname = country.getText().toString();
                       Integer noofguest = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getAdultno().toString());
                       Integer noofchild = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getChildno().toString());
                       String checkindate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckindate().toString();
                       String checkoutdate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckoutdate().toString();
                       String specialoffer = specialrequest.getText().toString();
                       Integer roomno = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getRoomno().toString());

                       BookingCustomModel bookingmodel = new BookingCustomModel(hotelid, roomid, fn, mn, lm, email, phone, noofguest, noofchild, checkindate, checkoutdate, specialoffer, roomno, totalprice,mainmodel.getData().get(0).getId());

                       getAPIBooking(bookingmodel);
                   }

                } else {

                    if (firstname.getText().toString().equals("") || firstname.getText().toString().equals(null)) {
                        dialog.dismiss();
                        firstname.setError("Invalid Name");
                    } else {
                        if (lastname.getText().toString().equals("") || lastname.getText().toString().equals(null)) {
                            dialog.dismiss();
                            lastname.setError("Invalid Name");
                        } else {
                            if (emailaddress.getText().toString().equals("") || emailaddress.getText().toString().equals(null)) {
                                dialog.dismiss();
                                emailaddress.setError("Invalid Email");
                            } else {
                                if (phonenumber.getText().toString().equals("") || phonenumber.getText().toString().equals(null)) {
                                    dialog.dismiss();
                                    phonenumber.setError("Invalid Phone");
                                } else {
                                    if (country.getText().toString().equals("") || country.getText().toString().equals(null)) {
                                        dialog.dismiss();
                                        country.setError("Invalid country");
                                    } else {
                                        Integer hotelid = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getDetails().getHotelId().toString());
                                        Integer roomid = Integer.parseInt(hotelDetailsWithModelRoomDeal.getRoomDealModel().getRoomId().toString());
                                        String fn = firstname.getText().toString();
                                        String mn = middlename.getText().toString();
                                        String lm = lastname.getText().toString();
                                        String email = emailaddress.getText().toString();
                                        String phone = phonenumber.getText().toString();
                                        String countryname = country.getText().toString();
                                        Integer noofguest = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getAdultno().toString());
                                        Integer noofchild = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getChildno().toString());
                                        String checkindate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckindate().toString();
                                        String checkoutdate = hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getCheckoutdate().toString();
                                        String specialoffer = specialrequest.getText().toString();
                                        Integer roomno = Integer.parseInt(hotelDetailsWithModelRoomDeal.getHotelDetailsWithModel().getModel().getRoomno().toString());

                                        Log.d("roomid", "onClick: " + roomid);

                                        BookingCustomModel model = new BookingCustomModel(hotelid, roomid, fn, mn, lm, email, phone, noofguest, noofchild, checkindate, checkoutdate, specialoffer, roomno, totalprice,null);

                                       getAPIBooking(model);

                                    }

                                }
                            }
                        }
                    }

                }

            }
        });


    }

    private void getAPIBooking(BookingCustomModel modelll) {
        APIInterface api = APiClient.getApiService();
        Call<BookingMain> call = api.getbooking(modelll);
        call.enqueue(new Callback<BookingMain>() {
            @Override
            public void onResponse(Call<BookingMain> call, Response<BookingMain> response) {
                if (response.isSuccessful()) {
                    dialog.dismiss();
                    Log.d("response", "onResponse: " + new Gson().toJson(response.body().getData()));
                    BookingWithHotelDetails bookingWithHotelDetails = new BookingWithHotelDetails(response.body().getData(), hotelDetailsWithModelRoomDeal);
                    startActivity(new Intent(BookingActivity.this, BookingPaymentActivity.class).putExtra("bookingwithdetails", new Gson().toJson(bookingWithHotelDetails)));
                } else {
                    dialog.dismiss();
                    Log.d("response", "onResponse: " + new Gson().toJson(response.body().getData()));
                }
            }

            @Override
            public void onFailure(Call<BookingMain> call, Throwable t) {
                dialog.dismiss();
                Log.d("response", "onResponse: " + t);
            }
        });
    }

}
