package com.example.sanjay.traveljinee.HotelList.Fragment.ReviewFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sanjay.traveljinee.Model.HotelRating.UserRating.UserRating;
import com.example.sanjay.traveljinee.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by SANJAY on 1/11/2018.
 */

public class MyGuestReviewAdapter extends BaseAdapter {

    Context context;
    List<UserRating> list;

    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

    public MyGuestReviewAdapter(Context context, List<UserRating> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_guest_review_item,null);
        }
        TextView rate = (TextView)convertView.findViewById(R.id.rate);
        TextView name = (TextView)convertView.findViewById(R.id.guest);
        TextView date = (TextView)convertView.findViewById(R.id.date);
        TextView title = (TextView)convertView.findViewById(R.id.title);
//        TextView detail = (TextView)convertView.findViewById(R.id.detail);

        LinearLayout background = (LinearLayout)convertView.findViewById(R.id.background);

        if(position%2==0){
            background.setBackgroundResource(R.color.darkgrey);
        }else{
            background.setBackgroundResource(R.color.grey);
        }

        rate.setText(String.valueOf(list.get(position).getRating()));
        name.setText(list.get(position).getUserName());
        String reviewdate = list.get(position).getReviewedDate();
        try {
            Date redate = myFormat.parse(reviewdate);
            date.setText(myFormat.format(redate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        title.setText(list.get(position).getReviewMessage());
//        detail.setText(list.get(position).getDescription());
        return convertView;
    }
}
