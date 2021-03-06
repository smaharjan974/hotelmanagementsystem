package com.example.sanjay.traveljinee.HotelList;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.multidex.MultiDex;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModel;
import com.example.sanjay.traveljinee.CustomModel.MainModel;
import com.example.sanjay.traveljinee.HotelList.Fragment.Deal.DealFragment;
import com.example.sanjay.traveljinee.HotelList.Fragment.Deal.Model;
import com.example.sanjay.traveljinee.HotelList.Fragment.Details.DescriptionFragment;
import com.example.sanjay.traveljinee.HotelList.Fragment.Details.DetailsModel;
import com.example.sanjay.traveljinee.HotelList.Fragment.MapFragment.MapFragment;
import com.example.sanjay.traveljinee.HotelList.Fragment.ReviewFragment.ReviewFragment;
import com.example.sanjay.traveljinee.Main.ImageAdapter;
import com.example.sanjay.traveljinee.Main.MainActivity;
import com.example.sanjay.traveljinee.Model.HotelDetails.HotelDetailsMain;
import com.example.sanjay.traveljinee.Model.HotelDetailsModel;
import com.example.sanjay.traveljinee.Model.HotelList.HotelDetail;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelListActivity extends AppCompatActivity implements View.OnClickListener,DealFragment.senddealfragmentdetails {

    TabLayout htab_tabs;
    ViewPager htab_viewpager;
    TextView hotelname,hoteladdress;
    AutoScrollViewPager viewPager;
    ImageView back,share;
    FragmentManager fm;

    List<String> features,featuers1;
    List<String> services,services1 ;

//    HotelDetailsModel hotel;
    int hotelid ;
    HotelDetailsWithModel hotelDetailsWithModel;
    MainModel mainModel;
    HotelDetail hoteldetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_list);

        int fragmentId = getIntent().getIntExtra("FRAGMENT_ID", 0);
        hotelid = getIntent().getIntExtra("hotelid",0);

        String model = getIntent().getStringExtra("hoteldetailswithmodel");
        hotelDetailsWithModel = new Gson().fromJson(model, HotelDetailsWithModel.class);
        mainModel = hotelDetailsWithModel.getModel();
        hoteldetail = hotelDetailsWithModel.getDetails();
        share = findViewById(R.id.share);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationInfo app = getApplicationContext().getApplicationInfo();
                String filePath = app.sourceDir;

                Intent intent = new Intent(Intent.ACTION_SEND);

                // MIME of .apk is "application/vnd.android.package-archive".
                // but Bluetooth does not accept this. Let's use "*/*" instead.
                intent.setType("*/*");


                // Append file and send Intent
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filePath)));
                startActivity(Intent.createChooser(intent, "Share app via"));
            }
        });


        getInitialize();
        getHoteldetails();

        List<Integer> imglist = new ArrayList<>();
        imglist.add(R.drawable.travejinee);
        imglist.add(R.drawable.travejinee);

        viewPager.setAdapter(new ImageAdapter(this, imglist));
        viewPager.setInterval(3000);
        viewPager.setCycle(true);
        viewPager.startAutoScroll();


        back.setOnClickListener(this);


        htab_tabs.addTab(htab_tabs.newTab().setText("DEAL"));
        htab_tabs.addTab(htab_tabs.newTab().setText("DETAILS"));
        htab_tabs.addTab(htab_tabs.newTab().setText("MAP"));
        htab_tabs.addTab(htab_tabs.newTab().setText("REVIEWS"));

        fm = getSupportFragmentManager();
        htab_viewpager.setAdapter(new PagerAdapter(fm, htab_tabs.getTabCount()));

        htab_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                htab_viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        htab_viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(htab_tabs));

        htab_viewpager.setCurrentItem(fragmentId);
        htab_tabs.setupWithViewPager(htab_viewpager);
        htab_tabs.getTabAt(0).setText("DEALS");
        htab_tabs.getTabAt(1).setText("DETAILS");
        htab_tabs.getTabAt(2).setText("MAP");
        htab_tabs.getTabAt(3).setText("REVIEWS");

    }

    private void getHoteldetails() {
        APIInterface api = APiClient.getApiService();
        Call<HotelDetailsMain> call = api.getHoteldetailsbyId(hotelid);
        call.enqueue(new Callback<HotelDetailsMain>() {
            @Override
            public void onResponse(Call<HotelDetailsMain> call, Response<HotelDetailsMain> response) {
                if(response.isSuccessful()){
                    if(response.body().getData()==null){

                    }else {
                        Toast.makeText(HotelListActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        Log.d("fasd", "onResponse: ");
                        hotelname.setText(response.body().getData().getHotelName().toString());
                        hoteladdress.setText(response.body().getData().getHotelAddress().toString());
                    }
                }else {
                    Log.d("fasd", "onResponse: failed ");

                }
            }

            @Override
            public void onFailure(Call<HotelDetailsMain> call, Throwable t) {
                Log.d("fasd", "onResponse: "+t);

            }
        });
    }

    private void getInitialize() {
        htab_tabs = (TabLayout) findViewById(R.id.htab_tabs);
        htab_viewpager= (ViewPager) findViewById(R.id.htab_viewpager);

        back = (ImageView)findViewById(R.id.back);
        share = (ImageView)findViewById(R.id.share);

        hoteladdress = (TextView)findViewById(R.id.hoteladdress);
        hotelname = (TextView)findViewById(R.id.hotelname);
        viewPager = (AutoScrollViewPager) findViewById(R.id.htab_header);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }

    @Override
    public void send_deal_fragment_dteials(String ph) {
//        Log.d("asdf", "send_deal_fragment_dteials: "+ph);
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        int tabcount;



        public PagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabcount = tabCount;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    Bundle bundle = new Bundle();
                    bundle.putInt("hotelid",hotelid);
                    bundle.putString("params", new Gson().toJson(hotelDetailsWithModel));
// set MyFragment Arguments
                    DealFragment dealFragment = new DealFragment();
                    dealFragment.setArguments(bundle);
                    return dealFragment;
                case 1:
                    Bundle bundle1 = new Bundle();
                    bundle1.putString("params", new Gson().toJson(hotelDetailsWithModel));
                    bundle1.putInt("hotelid",hotelid);
// set MyFragment Arguments
                    DescriptionFragment detailsfragment = new DescriptionFragment();
                    detailsfragment.setArguments(bundle1);
                    return detailsfragment;
                case 2:
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("hotelid",hotelid);
                    bundle2.putString("params", new Gson().toJson(hotelDetailsWithModel));
// set MyFragment Arguments
                    MapFragment mapFragment = new MapFragment();
                    mapFragment.setArguments(bundle2);
                    return mapFragment;
                case 3:
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("hotelid",hotelid);
                    bundle3.putString("params", new Gson().toJson(hotelDetailsWithModel));
// set MyFragment Arguments
                    ReviewFragment reviewsFragment = new ReviewFragment();
                    reviewsFragment.setArguments(bundle3);
                    return reviewsFragment;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return tabcount;
        }
    }


}
