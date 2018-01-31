package com.example.sanjay.traveljinee.HotelList.Fragment.Deal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sanjay.traveljinee.Booking.BookingActivity;
import com.example.sanjay.traveljinee.NonScrollListView;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.SearchHotel.SearchHotelActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SANJAY on 12/31/2017.
 */

public class MyListViewAdapter extends BaseAdapter {

    LinearLayout features;
    TextView[] txt;

    Context context;
    List<Model> string;

    public MyListViewAdapter(Context context, List<Model> string) {
        this.string = string;
        this.context = context;
    }

    @Override
    public int getCount() {
        return string.size();
    }

    @Override
    public Object getItem(int position) {
        return string.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_view_adapter,null);
        }
        TextView room = (TextView)convertView.findViewById(R.id.room);
        TextView sleep = (TextView)convertView.findViewById(R.id.sleep);
        TextView bed = (TextView)convertView.findViewById(R.id.bed);
        TextView price = (TextView)convertView.findViewById(R.id.price);

        LinearLayout messages = (LinearLayout)convertView.findViewById(R.id.messages);
        LinearLayout reserve = (LinearLayout)convertView.findViewById(R.id.reserve);

        if(string.get(position).getMessage()==null || string.get(position).getMessage()==null ) {

        }else {
            messages.removeAllViews();
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            TextView message = new TextView(context);
            message.setLayoutParams(params);
            message.setText(string.get(position).getMessage());
            message.setTextColor(Color.RED);
            messages.addView(message);
        }



        List<String> feat = new ArrayList<>();
        for(int i=0;i<string.get(position).getFeatures().size();i++){
            feat.add(string.get(position).getFeatures().get(i));
        }

        MyHotelFeatureListAdapter adapter1 = new MyHotelFeatureListAdapter(context,feat);
        NonScrollListView featureslist = (NonScrollListView)convertView.findViewById(R.id.featureslist);
        featureslist.setAdapter(adapter1);

        List<String> service = new ArrayList<>();
        for(int i=0;i<string.get(position).getServices().size();i++){
            service.add(string.get(position).getServices().get(i));
        }
        MyHotelServiceListAdapter adapter = new MyHotelServiceListAdapter(context,service);
        NonScrollListView serviceslist = (NonScrollListView)convertView.findViewById(R.id.serviceslist);
        serviceslist.setAdapter(adapter);


        room.setText(string.get(position).getRoom());
        room.setPaintFlags(room.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        sleep.setText(string.get(position).getSleeps());
        bed.setText(string.get(position).getBed());
        price.setText(String.valueOf(string.get(position).getPrice()));

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, BookingActivity.class);
                context.startActivity(i);
            }
        });

        return convertView;
    }


}
