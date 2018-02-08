package com.example.sanjay.traveljinee.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.sanjay.traveljinee.R;

public class TermAndConditionsActivity extends AppCompatActivity {

    TextView terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_and_conditions);

        getSupportActionBar().setTitle("Terms And Conditions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        terms = findViewById(R.id.termsandconditions);

        String termsandconditons = "<P> Terms and conditions are : <br> 1. Once Payment Are done, Payback system is not Available. <br> 2. asdklfjasldf asfasd fas";
        terms.setText(Html.fromHtml(termsandconditons));
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
