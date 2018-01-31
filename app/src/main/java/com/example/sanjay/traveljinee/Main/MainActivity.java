package com.example.sanjay.traveljinee.Main;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.multidex.MultiDex;
import android.system.Os;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.CustomModel.MainModel;
import com.example.sanjay.traveljinee.Model.Address.AddressMain;
import com.example.sanjay.traveljinee.Model.Offers.OffersMain;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.example.sanjay.traveljinee.SearchHotel.SearchHotelActivity;
import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    LinearLayout linear;
    AutoScrollViewPager viewPager;
    LinearLayout search, select;
    AutoCompleteTextView location;

    Dialog dialog;

    LinearLayout checkin, checkout;
    TextView datein, dateout;


    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date indates, outdate, Todaydate;

    TextView noofroom, noofadult, noofchild;
    List<String> stringList;

    ProgressDialog progressDialog;
    List<String> addresslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        } else {

        }

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Checking For internet Connection");
        progressDialog.show();

        noofroom = findViewById(R.id.noofroom);
        noofadult = findViewById(R.id.noofadult);
        noofchild = findViewById(R.id.noofchild);

        linear = (LinearLayout) findViewById(R.id.linear);
        viewPager = (AutoScrollViewPager) findViewById(R.id.viewpager);
        search = (LinearLayout) findViewById(R.id.search);
        location = (AutoCompleteTextView) findViewById(R.id.location);

        checkin = (LinearLayout) findViewById(R.id.checkin);
        checkout = (LinearLayout) findViewById(R.id.checkout);

        datein = (TextView) findViewById(R.id.datein);
        dateout = (TextView) findViewById(R.id.dateout);

        getinit();
        getSelect();

        APIInterface api = APiClient.getApiService();
        Call<OffersMain> call = api.getoffers();
        call.enqueue(new Callback<OffersMain>() {
            @Override
            public void onResponse(Call<OffersMain> call, Response<OffersMain> response) {
                if (response.isSuccessful()) {
                    stringList = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        stringList.add(response.body().getData().get(i).getTitle() + " " + response.body().getData().get(i).getTheme());
                    }


                    viewPager.setAdapter(new MyPagerAdapter(getBaseContext(), stringList));
                    viewPager.startAutoScroll();
                    viewPager.setCycle(true);
                    viewPager.setInterval(3000);

                    getAddress();
                }
            }

            @Override
            public void onFailure(Call<OffersMain> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Checking For internet Connection");
                progressDialog.show();


                String hotellocation = location.getText().toString();
                String checkin = datein.getText().toString();
                String checkout = dateout.getText().toString();
                String roomno = noofroom.getText().toString();
                String adultno = noofadult.getText().toString();
                String childno = noofchild.getText().toString();

                if (hotellocation.equals(null) || hotellocation.equals("")) {
                    progressDialog.dismiss();
                    location.setError("Set Valid location");
                } else {
                    progressDialog.dismiss();
                    if (addresslist == null || addresslist.size() == 0) {
                        Toast.makeText(MainActivity.this, "No Data Found or Internet Connection", Toast.LENGTH_SHORT).show();
                    } else {
                        for (int i = 0; i < addresslist.size(); i++) {
                            if (hotellocation.contains(addresslist.get(i))) {
                                MainModel model = new MainModel(hotellocation, checkin, checkout, roomno, adultno, childno, null, null,
                                        null, null, null, null);
                                String modelname = new Gson().toJson(model);
                                Intent j = new Intent(MainActivity.this, SearchHotelActivity.class);
                                j.putExtra("modelname", modelname);
                                startActivity(j);
                            } else {
                                if (i == addresslist.size()) {
                                    location.setError("Set Valid location");
                                } else {
                                    //do nothing
                                }
                            }
                        }

                    }
                }


            }
        });


    }

    private void getAddress() {
        APIInterface api = APiClient.getApiService();
        Call<AddressMain> call = api.getadress();
        call.enqueue(new Callback<AddressMain>() {
            @Override
            public void onResponse(Call<AddressMain> call, Response<AddressMain> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    addresslist = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        addresslist.add(response.body().getData().get(i).getCityName());
                    }
                    location.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, addresslist));

                }
            }

            @Override
            public void onFailure(Call<AddressMain> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getSelect() {
        select = findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.popup_selection);
                dialog.show();

                getdialoginit();

                Window window = dialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            }
        });
    }

    private void getdialoginit() {

        //room
        final int minroom = 1, maxroom = 4;
        final int[] roomcount = {1};
        LinearLayout roomminus = dialog.findViewById(R.id.roomminus);
        LinearLayout roomadd = dialog.findViewById(R.id.roomadd);
        final TextView roomtext = dialog.findViewById(R.id.roomtext);

        //adult
        final int minadult = 1, maxadult = 15;
        final int[] adultcount = {1};
        LinearLayout adultminus = dialog.findViewById(R.id.adultminus);
        LinearLayout adultadd = dialog.findViewById(R.id.adultadd);
        final TextView adulttext = dialog.findViewById(R.id.adulttext);

        //child
        final int minchild = 0, maxchild = 15;
        final int[] childcount = {0};
        LinearLayout childminus = dialog.findViewById(R.id.childminus);
        LinearLayout childadd = dialog.findViewById(R.id.childadd);
        final TextView childtext = dialog.findViewById(R.id.childtext);

        TextView cancel = dialog.findViewById(R.id.cancel);
        TextView apply = dialog.findViewById(R.id.apply);

        String roomno = noofroom.getText().toString();
        roomtext.setText(roomno);
        roomcount[0] = Integer.parseInt(noofroom.getText().toString());

        String adultno = noofadult.getText().toString();
        adulttext.setText(adultno);
        adultcount[0] = Integer.parseInt(noofadult.getText().toString());

        String childno = noofchild.getText().toString();
        childtext.setText(childno);
        childcount[0] = Integer.parseInt(noofchild.getText().toString());

        roomadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomcount[0] == maxroom) {
                    Toast.makeText(MainActivity.this, "Maximum room 4", Toast.LENGTH_SHORT).show();
                } else {
                    roomcount[0]++;
                }
                if (roomcount[0] > maxroom) {
                    Toast.makeText(MainActivity.this, "Maximum room 4", Toast.LENGTH_SHORT).show();
                } else {
                    roomtext.setText(String.valueOf(roomcount[0]));
                }

            }
        });

        roomminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (roomcount[0] == minroom) {
                    Toast.makeText(MainActivity.this, "Minimum room 1", Toast.LENGTH_SHORT).show();
                } else {
                    roomcount[0]--;
                    roomtext.setText(String.valueOf(roomcount[0]));
                }
            }
        });


        adultadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adultcount[0] == maxadult) {
                    Toast.makeText(MainActivity.this, "Maximum Adult " + maxadult, Toast.LENGTH_SHORT).show();
                } else {
                    adultcount[0]++;
                }
                if (adultcount[0] > maxadult) {
                    Toast.makeText(MainActivity.this, "Maximum adult " + maxadult, Toast.LENGTH_SHORT).show();
                } else {
                    adulttext.setText(String.valueOf(adultcount[0]));
                }

            }
        });

        adultminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (adultcount[0] == minadult) {
                    Toast.makeText(MainActivity.this, "Minimum adult 1", Toast.LENGTH_SHORT).show();
                } else {
                    adultcount[0]--;
                    adulttext.setText(String.valueOf(adultcount[0]));
                }
            }
        });


        childadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (childcount[0] == maxchild) {
                    Toast.makeText(MainActivity.this, "Maximum Child " + maxchild, Toast.LENGTH_SHORT).show();
                } else {
                    childcount[0]++;
                }
                if (childcount[0] > maxchild) {
                    Toast.makeText(MainActivity.this, "Maximum child " + maxchild, Toast.LENGTH_SHORT).show();
                } else {
                    childtext.setText(String.valueOf(childcount[0]));
                }

            }
        });

        childminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (childcount[0] == minchild) {
                    Toast.makeText(MainActivity.this, "Minimum child 1", Toast.LENGTH_SHORT).show();
                } else {
                    childcount[0]--;
                    childtext.setText(String.valueOf(childcount[0]));
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noofroom.setText(String.valueOf(roomcount[0]));
                noofadult.setText(String.valueOf(adultcount[0]));
                noofchild.setText(String.valueOf(childcount[0]));
                dialog.dismiss();
            }
        });

    }

    private void getinit() {
        checkin = (LinearLayout) findViewById(R.id.checkin);
        checkout = (LinearLayout) findViewById(R.id.checkout);


        datein = (TextView) findViewById(R.id.datein);
        dateout = (TextView) findViewById(R.id.dateout);

        Todaydate = new Date();
        datein.setText(myFormat.format(Todaydate));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        dateout.setText(myFormat.format(calendar.getTime()));

        final DatePickerDialog.OnDateSetListener indate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                datein.setText(myFormat.format(calendar.getTime()));
                try {
                    indates = myFormat.parse(datein.getText().toString());
                    outdate = myFormat.parse(dateout.getText().toString());
                    if (indates.compareTo(Todaydate) < 0) {
                        datein.setText(myFormat.format(Todaydate));
                        Toast.makeText(MainActivity.this, "Date has been passed", Toast.LENGTH_SHORT).show();
                    } else {
                        if (indates.compareTo(outdate) > 0) {
                            calendar.add(Calendar.DAY_OF_MONTH, 1);
                            dateout.setText(myFormat.format(calendar.getTime()));
                        }
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, indate, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final DatePickerDialog.OnDateSetListener outdates = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);

                try {
                    indates = myFormat.parse(datein.getText().toString());
                    if (indates.compareTo(calendar.getTime()) < 0) {
                        dateout.setText(myFormat.format(calendar.getTime()));
                    } else {
                        Toast.makeText(MainActivity.this, "Set The date greater than " + myFormat.format(indates), Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, outdates, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

//    @Override
//    protected void attachBaseContext(Context base)
//    {
//        super.attachBaseContext(base);
//        MultiDex.install(MainActivity.this);
//    }
}
