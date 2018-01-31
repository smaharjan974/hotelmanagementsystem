package com.example.sanjay.traveljinee.HotelList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sanjay.traveljinee.Main.ImageAdapter;
import com.example.sanjay.traveljinee.R;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Gallery");

        AutoScrollViewPager viewPager = (AutoScrollViewPager)findViewById(R.id.viewpage);
        List<Integer> imagelist = new ArrayList<>();
        imagelist.add(R.drawable.travejinee);
        imagelist.add(R.drawable.hotel);

        viewPager.setAdapter(new ImageAdapter(this,imagelist));
        viewPager.startAutoScroll();
        viewPager.setInterval(3000);
        viewPager.setCycle(true);
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
