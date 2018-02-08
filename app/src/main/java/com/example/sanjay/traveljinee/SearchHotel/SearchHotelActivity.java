package com.example.sanjay.traveljinee.SearchHotel;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModel;
import com.example.sanjay.traveljinee.CustomModel.MainModel;
import com.example.sanjay.traveljinee.Main.MainActivity;
import com.example.sanjay.traveljinee.Model.Address.AddressMain;
import com.example.sanjay.traveljinee.Model.CommonFeatures.CommonFeaturesMain;
import com.example.sanjay.traveljinee.Model.CommonFeatures.CommonFeaturesModel;
import com.example.sanjay.traveljinee.Model.HotelList.HotelDetail;
import com.example.sanjay.traveljinee.Model.HotelList.HotelListMain;
import com.example.sanjay.traveljinee.NonScrollListView;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchHotelActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    DrawerLayout drawer;
    NonScrollListView listview;
    List<HotelModel> list;
//    List<String> features, features1;
    String name, onestar, twostar, threestar, fourstar, fivestar;
    List<Integer> ratinglist;
    boolean ch, ch2, ch3, ch4, ch5 = false;
    List<Integer> selectedfreaturelist, selectedfreaturelist2;
    LinearLayout checkin, checkout, roomtype;
    TextView datein, dateout, roomtypetext;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date indates, outdate, Todaydate;
    String checkindate, checkoutdate;
    MainModel model;
    ProgressDialog dialog;
    List<HotelDetail> hotellist;

    List<String> addresslist;
    ListView location;
    SharedPreferences preferences;
    NonScrollListView fealist,fealist1;
    List<CommonFeaturesModel> features,features1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_hotel);

        preferences = getSharedPreferences("login",MODE_PRIVATE);

        dialog = new ProgressDialog(SearchHotelActivity.this);
        dialog.setCancelable(false);
        dialog.setTitle("Loading");
        dialog.setMessage("Loading Hotel List. Please Wait...");
        dialog.show();
        //string to object
        String modelname = getIntent().getStringExtra("modelname");
        Type type = new TypeToken<MainModel>() {
        }.getType();
        model = new Gson().fromJson(modelname, type);

        if (getIntent().getStringExtra("datein") == null) {

        } else {
            checkindate = model.getCheckindate();
            checkoutdate = model.getCheckoutdate();
        }
        getinit();
        getNavItem();

        if (model != null) {
            Log.d("abbbcccddd", "onQueryTextSubmit: "+new Gson().toJson(model));
            getSupportActionBar().setTitle(model.getAddress());
        } else {
            getSupportActionBar().setTitle("");
        }

        gethotellist(model);
    }

    private void gethotellist(final MainModel modell) {
        APIInterface api = APiClient.getApiService();
        Call<HotelListMain> call = api.getHotelListByParameter(modell);
        call.enqueue(new Callback<HotelListMain>() {
            @Override
            public void onResponse(Call<HotelListMain> call, Response<HotelListMain> response) {
                if (response.isSuccessful()) {
                    hotellist = new ArrayList<>();
                    List<HotelDetailsWithModel> hotel= new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        hotellist.add(response.body().getData().get(i));
                        hotel.add(new HotelDetailsWithModel(modell,response.body().getData().get(i)));
                    }
                    dialog.dismiss();
                    listview.setAdapter(new MyHotelSearchListAdapter(SearchHotelActivity.this, hotel));
                }else {
                    dialog.dismiss();
                    Toast.makeText(SearchHotelActivity.this, "Bad Request.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HotelListMain> call, Throwable t) {
                dialog.dismiss();
            }
        });
    }

    public List<Integer> selectedFeatures(List<Integer> string) {
        Log.d("asdf", "selectedFeatures: " + string.size());
        selectedfreaturelist = new ArrayList<>();
        for (int i = 0; i < string.size(); i++) {
            selectedfreaturelist.add(string.get(i));
        }


        return selectedfreaturelist;
    }

    public List<Integer> selectedFeatures2(List<Integer> string) {
        Log.d("asdf", "selectedFeatures: " + string.size());
        selectedfreaturelist2 = new ArrayList<>();
        for (int i = 0; i < string.size(); i++) {
            selectedfreaturelist2.add(string.get(i));
        }

        return selectedfreaturelist2;
    }

    private void getinit() {

        LinearLayout datepicker = (LinearLayout) findViewById(R.id.datepickerlayout);
        datepicker.requestFocus();
        listview = (NonScrollListView) findViewById(R.id.listview);
        listview.setFocusable(false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(name);
        toolbar.setBackground(new ColorDrawable(getResources().getColor(R.color.blues)));
        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        checkin = (LinearLayout) findViewById(R.id.checkin);
        checkout = (LinearLayout) findViewById(R.id.checkout);
        roomtype = (LinearLayout) findViewById(R.id.roomtype);

        datein = (TextView) findViewById(R.id.datein);
        dateout = (TextView) findViewById(R.id.dateout);
        roomtypetext = (TextView) findViewById(R.id.roomtypetext);


        Todaydate = new Date();
//        datein.setText(myFormat.format(Todaydate));
        if (checkindate == null) {
            datein.setText(myFormat.format(Todaydate));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dateout.setText(myFormat.format(calendar.getTime()));
        } else {
            try {
                indates = myFormat.parse(checkindate);
                outdate = myFormat.parse(checkoutdate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            datein.setText(myFormat.format(indates));
            dateout.setText(myFormat.format(outdate));
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        dateout.setText(myFormat.format(calendar.getTime()));
        }

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
                        Toast.makeText(SearchHotelActivity.this, "Date has been passed", Toast.LENGTH_SHORT).show();
                    } else {
                        if (indates.compareTo(outdate) > 0) {
                            calendar.add(Calendar.DAY_OF_MONTH, 1);
                            dateout.setText(myFormat.format(calendar.getTime()));
                        }
                    }
                    dialog = new ProgressDialog(SearchHotelActivity.this);
                    dialog.setCancelable(false);
                    dialog.setTitle("Loading");
                    dialog.setMessage("Loading Hotel List. Please Wait...");
                    dialog.show();
                    model.setCheckindate(datein.getText().toString());
                    model.setCheckoutdate(dateout.getText().toString());
                    Log.d("abbbcccddd", "onQueryTextSubmit: "+new Gson().toJson(model));
                    gethotellist(model);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        checkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchHotelActivity.this, indate, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
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
                        Toast.makeText(SearchHotelActivity.this, "Set The date greater than " + myFormat.format(indates), Toast.LENGTH_SHORT).show();
                    }
                    dialog = new ProgressDialog(SearchHotelActivity.this);
                    dialog.setCancelable(false);
                    dialog.setTitle("Loading");
                    dialog.setMessage("Loading Hotel List. Please Wait...");
                    dialog.show();
                    model.setCheckoutdate(dateout.getText().toString());
                    Log.d("abbbcccddd", "onQueryTextSubmit: "+new Gson().toJson(model));
                    gethotellist(model);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchHotelActivity.this, outdates, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();


            }
        });

        roomtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SearchHotelActivity.this, v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_room_type, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        roomtypetext.setText(item.getTitle());
                        model.setRoomtype(roomtypetext.getText().toString());
                        Log.d("abbbcccddd", "onQueryTextSubmit: "+new Gson().toJson(model));
                        gethotellist(model);
                        return true;
                    }
                });
                popup.show();

            }
        });


    }


    private void getNavItem() {
        final View header = navigationView.getHeaderView(0);

        final LinearLayout star1 = (LinearLayout) header.findViewById(R.id.onestar);

        ratinglist = new ArrayList<>();

        final EditText hotelname = header.findViewById(R.id.hotelname);

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch == true) {
                    star1.setBackgroundResource(R.drawable.rectangle_blue);
                    ch = false;
//                    onestar = "";
                } else {
                    ch = true;
                    star1.setBackgroundResource(R.color.black);
//                    onestar = "onestar";

                    //2018-1-31
                    ratinglist.add(1);
                }
            }
        });

        final LinearLayout star2 = (LinearLayout) header.findViewById(R.id.twostar);

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch2 == true) {
                    star2.setBackgroundResource(R.drawable.rectangle_blue);
                    ch2 = false;
                    twostar = "";
                } else {
                    ch2 = true;
                    star2.setBackgroundResource(R.color.black);
                    twostar = "twostar";
                    ratinglist.add(2);
                }
            }
        });

        final LinearLayout star3 = (LinearLayout) header.findViewById(R.id.threestar);

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch3 == true) {
                    star3.setBackgroundResource(R.drawable.rectangle_blue);
                    ch3 = false;
                    threestar = "";
                } else {
                    ch3 = true;
                    star3.setBackgroundResource(R.color.black);
                    threestar = "threestar";
                    ratinglist.add(3);
                }
            }
        });

        final LinearLayout star4 = (LinearLayout) header.findViewById(R.id.fourstar);

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch4 == true) {
                    star4.setBackgroundResource(R.drawable.rectangle_blue);
                    ch4 = false;
                    fourstar = "";
                } else {
                    ch4 = true;
                    star4.setBackgroundResource(R.color.black);
                    fourstar = "fourstar";
                    ratinglist.add(4);
                }
            }
        });

        final LinearLayout star5 = (LinearLayout) header.findViewById(R.id.fivestar);

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch5 == true) {
                    star5.setBackgroundResource(R.drawable.rectangle_blue);
                    ch5 = false;
                    fivestar = "";
                } else {
                    ch5 = true;
                    star5.setBackgroundResource(R.color.black);
                    fivestar = "fivestar";
                    ratinglist.add(5);
                }
            }
        });


        LinearLayout submit = (LinearLayout) header.findViewById(R.id.submit);
        SeekBar priceseekbar = (SeekBar) header.findViewById(R.id.priceseekbar);
        final TextView price = (TextView) header.findViewById(R.id.price);
        priceseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 40;
                if (progress < min) {
                    price.setText(String.valueOf(min));
                } else {
                    price.setText(String.valueOf(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        final SeekBar distanceseekbar = (SeekBar) header.findViewById(R.id.distanceseekbar);
        final TextView distance = (TextView) header.findViewById(R.id.distance);
        distanceseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fealist = (NonScrollListView) header.findViewById(R.id.features1);
        fealist1 = (NonScrollListView) header.findViewById(R.id.features2);
        getFeatures();







        final EditText address = header.findViewById(R.id.address);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> featurelist = new ArrayList<>();
                if(selectedfreaturelist==null){

                }else {
                    for (int i = 0; i < selectedfreaturelist.size(); i++) {
                        featurelist.add(selectedfreaturelist.get(i));
                    }
                }
                if(selectedfreaturelist2==null){

                }else {
                    for (int i = 0; i < selectedfreaturelist2.size(); i++) {
                        featurelist.add(selectedfreaturelist2.get(i));
                    }
                }

                String addresss = address.getText().toString();
                getSupportActionBar().setTitle(addresss);

                if(addresss.equals("")||addresss.equals(null)){
                    getSupportActionBar().setTitle(model.getAddress());
                    model.setAddress(model.getAddress());
                }else {
                    model.setAddress(addresss);
                }
                model.setFeatureslist(featurelist);
                model.setRatinglist(ratinglist);
                model.setMaxdistance(distance.getText().toString());
                model.setMaxprice(price.getText().toString());
                if (hotelname.getText().toString().equals("")||hotelname.getText().equals(null)){
                    model.setHotelname(null);
                }else {
                    model.setHotelname(hotelname.getText().toString());
                }
                Log.d("abbbcccddd", "onQueryTextSubmit: "+new Gson().toJson(model));
                gethotellist(model);

                drawer.closeDrawers();

            }
        });


    }

    private void getFeatures() {
        APIInterface api = APiClient.getApiService();
        Call<CommonFeaturesMain> call = api.getCommonFeatures();
        call.enqueue(new Callback<CommonFeaturesMain>() {
            @Override
            public void onResponse(Call<CommonFeaturesMain> call, Response<CommonFeaturesMain> response) {

                if(response.isSuccessful()){
                    features = new ArrayList<>();
                    features1 = new ArrayList<>();
                    for (int i=0;i<response.body().getData().size();i++){
                        if(i%2==0){
                            features.add(response.body().getData().get(i));
                        }else {
                            features1.add(response.body().getData().get(i));
                        }
                    }

                    fealist.setAdapter((new MyHotelCommonFeatureListAdapter(SearchHotelActivity.this, features)));
                    fealist1.setAdapter(new MyHotelCommonFeature2ListAdapter(SearchHotelActivity.this, features1));



                }
            }

            @Override
            public void onFailure(Call<CommonFeaturesMain> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem item;
        String login = preferences.getString("username","");
        if(login.equals("")){
           item = menu.findItem(R.id.signout);
           item.setVisible(false);
        }

        APIInterface api = APiClient.getApiService();
        Call<AddressMain> call = api.getadress();
        call.enqueue(new Callback<AddressMain>() {
            @Override
            public void onResponse(Call<AddressMain> call, Response<AddressMain> response) {
                if (response.isSuccessful()) {
                    location = new ListView(getApplicationContext());
                    addresslist = new ArrayList<>();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        addresslist.add(response.body().getData().get(i).getCityName());
                    }
                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchHotelActivity.this, android.R.layout.simple_list_item_1, addresslist);
                    location.setAdapter(adapter);

                    SearchManager searchManager = (SearchManager)
                            getSystemService(Context.SEARCH_SERVICE);
                    MenuItem searchMenuItem = menu.findItem(R.id.search_icon);
                    final SearchView searchView = (SearchView) searchMenuItem.getActionView();

                    searchView.setSearchableInfo(searchManager.
                            getSearchableInfo(getComponentName()));
                    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                        @Override
                        public boolean onQueryTextSubmit(String s) {
                            getSupportActionBar().setTitle(s);

                            model.setAddress(s);
                            gethotellist(model);
                            searchView.onActionViewCollapsed();
                            return false;
                        }

                        @Override
                        public boolean onQueryTextChange(String s) {
                            return false;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AddressMain> call, Throwable t) {
                Toast.makeText(SearchHotelActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.signout:
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(SearchHotelActivity.this, MainActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }



}
