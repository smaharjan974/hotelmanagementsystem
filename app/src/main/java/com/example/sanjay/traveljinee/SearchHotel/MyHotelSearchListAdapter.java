package com.example.sanjay.traveljinee.SearchHotel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModel;
import com.example.sanjay.traveljinee.HotelList.GalleryActivity;
import com.example.sanjay.traveljinee.HotelList.HotelListActivity;
import com.example.sanjay.traveljinee.Model.HotelList.HotelDetail;
import com.example.sanjay.traveljinee.R;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by SANJAY on 1/7/2018.
 */

public class MyHotelSearchListAdapter extends BaseAdapter {

    Context context;
    List<HotelDetailsWithModel> list;

    public MyHotelSearchListAdapter(Context context, List<HotelDetailsWithModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_search_list_item,null);
        }
        TextView hotelname = (TextView)convertView.findViewById(R.id.hotelname);
        TextView hoteladdress = (TextView)convertView.findViewById(R.id.address);
        TextView hotelrate = (TextView)convertView.findViewById(R.id.rate);
        TextView reviews = (TextView)convertView.findViewById(R.id.reviews);

        LinearLayout deal = (LinearLayout)convertView.findViewById(R.id.deal);

        ImageView image = (ImageView)convertView.findViewById(R.id.image);

        LinearLayout map = (LinearLayout)convertView.findViewById(R.id.map);
        LinearLayout rating = (LinearLayout)convertView.findViewById(R.id.rating);

        hotelname.setText(String.valueOf(list.get(position).getDetails().getHotelname()));
        hoteladdress.setText(list.get(position).getDetails().getHotelAddress());
        hotelrate.setText(String.valueOf(list.get(position).getDetails().getRating()));
        reviews.setText(String.valueOf(list.get(position).getDetails().getUserView())+" reviews");

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,HotelListActivity.class);
                i.putExtra("hoteldetailswithmodel",new Gson().toJson(list.get(position)));
                i.putExtra("hotelid",list.get(position).getDetails().getHotelId());
                i.putExtra("FRAGMENT_ID",3);
                context.startActivity(i);
            }
        });

        hotelname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,HotelListActivity.class);
                i.putExtra("hoteldetailswithmodel",new Gson().toJson(list.get(position)));
                i.putExtra("hotelid",list.get(position).getDetails().getHotelId());
                i.putExtra("FRAGMENT_ID",1);
                context.startActivity(i);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,HotelListActivity.class);
                i.putExtra("hoteldetailswithmodel",new Gson().toJson(list.get(position)));
                i.putExtra("hotelid",list.get(position).getDetails().getHotelId());
                i.putExtra("FRAGMENT_ID",2);
                context.startActivity(i);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, GalleryActivity.class);
                i.putExtra("hoteldetailswithmodel",new Gson().toJson(list.get(position)));
                i.putExtra("hotelid",list.get(position).getDetails().getHotelId());
                context.startActivity(i);
            }
        });

        deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,HotelListActivity.class);
                i.putExtra("hoteldetailswithmodel",new Gson().toJson(list.get(position)));
                i.putExtra("hotelid",list.get(position).getDetails().getHotelId());
                context.startActivity(i);
            }
        });

        return convertView;
    }
}
