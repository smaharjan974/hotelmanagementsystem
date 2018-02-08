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

import com.example.sanjay.traveljinee.Main.MainActivity;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.SignUpMain;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.example.sanjay.traveljinee.SearchHotel.SearchHotelActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText email, password, confirmpassword;
    Button signup;
    ProgressDialog dialog;
    SharedPreferences preferences; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        preferences = getSharedPreferences("login", MODE_PRIVATE);
        
        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(SignUpActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Loading");
                dialog.setMessage("Loading Hotel List. Please Wait...");
                dialog.show();
                String pass = password.getText().toString();
                String retypepass = confirmpassword.getText().toString();
                
                if (email.getText().toString().equals("") || email.getText().toString().equals(null)) {
                    dialog.dismiss();
                    email.setError("Insert Email");
                } else {
                    if (pass.equals(null) || pass .equals("")) {
                        dialog.dismiss();
                        password.setError("Insert Password");
                    } else {
                        if (pass.equals(retypepass)) {
                            APIInterface api = APiClient.getApiService();
                            Call<Object> call = api.getRegister(email.getText().toString(),pass,retypepass);
                            call.enqueue(new Callback<Object>() {
                                @Override
                                public void onResponse(Call<Object> call, Response<Object> response) {
                                    if(response.isSuccessful()){

                                        String yes = new Gson().toJson(response.body());

                                        if(yes.contains("Successfully Registerred")) {

                                            SharedPreferences.Editor editor = preferences.edit();
                                            editor.putString("username", email.getText().toString());
                                            editor.commit();

                                            dialog.dismiss();
                                            Log.d("iiisss", "onResponse: " + new Gson().toJson(response.body()));
                                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                                        }else {
                                            email.setError("Email Already Verified or Password is to short");
                                            password.setError("Email Already Verified or Password is to short");
                                            dialog.dismiss();
                                        }

                                    }else {
                                        email.setError("Email Already Verified or Password is to short");
                                        password.setError("Email Already Verified or Password is to short");
                                        dialog.dismiss();;
                                        Log.d("iiisss", "onResponse: "+new Gson().toJson(response.body()));
                                        
                                    }
                                }

                                @Override
                                public void onFailure(Call<Object> call, Throwable t) {
                                    dialog.dismiss();
                                    Toast.makeText(SignUpActivity.this, "Internet May Not be available.", Toast.LENGTH_SHORT).show();
                                    Log.d("iiisss", "onResponse: "+t);
                                }
                            });


                        } else {
                            dialog.dismiss();
                            password.setError("Password Didnot Match");
                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

