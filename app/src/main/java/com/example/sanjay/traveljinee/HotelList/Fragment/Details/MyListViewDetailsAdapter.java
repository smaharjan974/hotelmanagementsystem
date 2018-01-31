package com.example.sanjay.traveljinee.HotelList.Fragment.Details;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanjay.traveljinee.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SANJAY on 1/5/2018.
 */

public class MyListViewDetailsAdapter extends BaseAdapter {

    Context context;
    List<String> list;



    public MyListViewDetailsAdapter(Context context, List<String> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_amenities_list_view,null);
        }
//        ImageView imgview1 = (ImageView)convertView.findViewById(R.id.imgview1);
        TextView textView = (TextView) convertView.findViewById(R.id.textview1);

//       imgview1.setImageResource(list.get(position).getImage());
        textView.setText(list.get(position));

        return convertView;
    }
}
