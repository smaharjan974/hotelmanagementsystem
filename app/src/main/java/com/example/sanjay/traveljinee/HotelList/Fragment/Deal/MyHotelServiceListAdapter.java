package com.example.sanjay.traveljinee.HotelList.Fragment.Deal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanjay.traveljinee.R;

import java.util.List;

/**
 * Created by SANJAY on 1/1/2018.
 */

public class MyHotelServiceListAdapter extends BaseAdapter {
    Context context;
    List<String> stringlist;

    public MyHotelServiceListAdapter(Context context, List<String> stringlist) {
        this.context = context;
        this.stringlist = stringlist;
    }

    @Override
    public int getCount() {
        return stringlist.size();
    }

    @Override
    public Object getItem(int position) {
        return stringlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_services_item,null);
        }
        TextView service = (TextView)convertView.findViewById(R.id.service);
//        ImageView imgview = (ImageView)convertView.findViewById(R.id.imgview);
//        imgview.setImageResource(R.drawable.icon_hotel_service);
        service.setText(stringlist.get(position));
        service.setTextColor(Color.BLACK);
        return convertView;
    }
}
