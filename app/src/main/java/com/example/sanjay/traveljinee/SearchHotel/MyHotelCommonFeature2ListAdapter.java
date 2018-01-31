package com.example.sanjay.traveljinee.SearchHotel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.sanjay.traveljinee.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SANJAY on 1/12/2018.
 */

public class MyHotelCommonFeature2ListAdapter extends BaseAdapter {

    Context context;
    List<String> stringlist;
    CheckBox service;
    List<String> selectionList = new ArrayList<>();

    public MyHotelCommonFeature2ListAdapter(Context context, List<String> stringlist) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_features_check_box_item, null);
        }


        service = (CheckBox) convertView.findViewById(R.id.checkbox);
        service.setText(stringlist.get(position));

        service.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    selectionList.add(stringlist.get(position));
                } else {
                    for (int i = 0; i < selectionList.size(); i++) {
                        if (stringlist.get(position).equals(selectionList.get(i))) {
                            selectionList.remove(selectionList.get(i));
                        } else {
                            //do nothing
                        }
                    }
                }
                Log.d("slecelt", "onCheckedChanged: " + String.valueOf(selectionList.size()));

                if (context instanceof SearchHotelActivity) {
                    ((SearchHotelActivity) context).selectedFeatures2(selectionList);
                }
            }
        });


        return convertView;
    }
}
