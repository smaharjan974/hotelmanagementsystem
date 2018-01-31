package com.example.sanjay.traveljinee.Main;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sanjay.traveljinee.R;

import java.util.List;

/**
 * Created by SANJAY on 1/4/2018.
 */

public class MyPagerAdapter extends PagerAdapter {

    Context context;
    List<String> stringList;

    public MyPagerAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = mLayoutInflater.inflate(R.layout.custom_textview, container, false);
        TextView text = (TextView)itemView.findViewById(R.id.text2);
        text.setText(Html.fromHtml(stringList.get(position)));
        text.setTextColor(Color.BLACK);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
