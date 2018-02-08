package com.example.sanjay.traveljinee.SignUPandLogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Booking.BookingActivity;
import com.example.sanjay.traveljinee.Main.MainActivity;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.LoginMain;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.example.sanjay.traveljinee.SearchHotel.SearchHotelActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button login;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        preferences = getSharedPreferences("login", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(LoginActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Loading");
                dialog.setMessage("Loading Hotel List. Please Wait...");
                dialog.show();

                String user = username.getText().toString();
                String pass = password.getText().toString();

                APIInterface api = APiClient.getApiService();
                Call<Object> call = api.getlogin(user, pass);
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        Log.d("iisss", "onResponse: " + new Gson().toJson(response.body()));

                        if (response.isSuccessful()) {
                            String yes = new Gson().toJson(response.body());

                            if (yes.contains("Successfully Logged in")) {
                                dialog.dismiss();

                                String main = getIntent().getStringExtra("check");
                                if(main.equals("booking")){
                                    String hoteldetailswithmain = getIntent().getStringExtra("roomdeal");
                                    startActivity(new Intent(LoginActivity.this, BookingActivity.class).putExtra("roomdeal",hoteldetailswithmain));
                                }else {
                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                }
//                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                editor = preferences.edit();
                                editor.putString("username", new Gson().toJson(response.body()));
                                editor.commit();
                            } else {
                                dialog.dismiss();
                                username.setError("UserName and password doesnot Exists.");
                            }

                        } else {
                            dialog.dismiss();
                            username.setError("UserName and password doesnot Exists.");
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        dialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Internet May Not be Available.", Toast.LENGTH_SHORT).show();
                        Log.d("iisss", "onResponse: " + t);
                    }
                });


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
