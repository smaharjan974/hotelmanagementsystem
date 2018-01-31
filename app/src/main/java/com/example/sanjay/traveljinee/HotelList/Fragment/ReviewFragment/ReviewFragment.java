package com.example.sanjay.traveljinee.HotelList.Fragment.ReviewFragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Model.HotelRating.RatingMain;
import com.example.sanjay.traveljinee.Model.HotelRating.UserRating.UserRating;
import com.example.sanjay.traveljinee.Model.HotelRating.UserRating.UserRatingMain;
import com.example.sanjay.traveljinee.NonScrollListView;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SANJAY on 1/9/2018.
 */

public class ReviewFragment extends Fragment {

    int hotelid;
    LinearLayout linearlayout;
    NonScrollListView guestreview;
    TextView totalviews;
    TextView averagerate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.review_fragment, null);

        ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollview);
        LinearLayout temp = view.findViewById(R.id.temp);
        temp.requestFocus();

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                ((ScrollView) view.findViewById(R.id.scrollview)).fullScroll(View.FOCUS_UP);
            }
        });

        averagerate = (TextView) view.findViewById(R.id.average);
        linearlayout = view.findViewById(R.id.linearlayout);
        guestreview = (NonScrollListView) view.findViewById(R.id.guestreview);
        guestreview.setFocusable(false);

        totalviews = (TextView) view.findViewById(R.id.totalviews);
        totalviews.setPaintFlags(totalviews.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        if (getArguments() != null) {
            String mParam1 = getArguments().getString("params");
            Log.d("asdf", "onCreateView: " + mParam1);

            hotelid = getArguments().getInt("hotelid");
            Log.d("asdf", "onCreateView: " + hotelid);

            getRatingOverview();
        }



//
//        List<ReviewModel> list = new ArrayList<>();
//        list.add(new ReviewModel(8.5f, "Erica", "Sep 2017", "Very Good Hotel", "THehwraer asdf asdf sdfsdfds "));
//        list.add(new ReviewModel(8.5f, "Erica", "Sep 2017", "Very Good Hotel", "THehwraer asdf asdf sdfsdfds "));
//        list.add(new ReviewModel(8.5f, "Erica", "Sep 2017", "Very Good Hotel", "THehwraer asdf asdf sdfsdfds "));
//        list.add(new ReviewModel(8.5f, "Erica", "Sep 2017", "Very Good Hotel", "THehwraer asdf asdf sdfsdfds "));
//


//        float rate = (float) 2.5;
//
//        locationtexts.setText(String.valueOf(rate));
//
//        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, rate);
//        TextView locationtext = new TextView(getContext());
//        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.left_to_right);
//        locationtext.startAnimation(anim);
//        locationtext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        locationtext.setLayoutParams(param);
//        locationreview.addView(locationtext);
//
//        //rooms
//        LinearLayout roomreview = (LinearLayout) view.findViewById(R.id.roomreview);
//        TextView roomtexts = (TextView) view.findViewById(R.id.roomtext);
//
//        float roomrate = (float) 10;
//
//        roomtexts.setText(String.valueOf(roomrate));
//
//        LinearLayout.LayoutParams paramroom = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, roomrate);
//        TextView roomtext = new TextView(getContext());
//        roomtext.startAnimation(anim);
//        roomtext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        roomtext.setLayoutParams(paramroom);
//        roomreview.addView(roomtext);
//
//        //service
//        LinearLayout servicereview = (LinearLayout) view.findViewById(R.id.serrvicereview);
//        TextView servicetexts = (TextView) view.findViewById(R.id.servicetext);
//
//        float servicerate = (float) 8.0;
//
//        servicetexts.setText(String.valueOf(servicerate));
//
//        LinearLayout.LayoutParams serviceparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, servicerate);
//        TextView servicetext = new TextView(getContext());
//        servicetext.startAnimation(anim);
//        servicetext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        servicetext.setLayoutParams(serviceparam);
//        servicereview.addView(servicetext);
//
//        //clean
//        LinearLayout cleanreview = (LinearLayout) view.findViewById(R.id.cleanreview);
//        TextView cleantexts = (TextView) view.findViewById(R.id.cleantext);
//
//        float cleanrate = (float) 8.5;
//
//        cleantexts.setText(String.valueOf(cleanrate));
//
//        LinearLayout.LayoutParams cleanparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, cleanrate);
//        TextView cleantext = new TextView(getContext());
//        cleantext.startAnimation(anim);
//        cleantext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        cleantext.setLayoutParams(cleanparam);
//        cleanreview.addView(cleantext);
//
//        //comfort
//        LinearLayout comfortreview = (LinearLayout) view.findViewById(R.id.comfortreview);
//        TextView comforttexts = (TextView) view.findViewById(R.id.comforttext);
//
//        float comfortrate = (float) 3.5;
//
//        comforttexts.setText(String.valueOf(comfortrate));
//
//        LinearLayout.LayoutParams comfortparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, comfortrate);
//        TextView comforttext = new TextView(getContext());
//        comforttext.startAnimation(anim);
//        comforttext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        comforttext.setLayoutParams(comfortparam);
//        comfortreview.addView(comforttext);
//
//        //facility
//        LinearLayout facilityreview = (LinearLayout) view.findViewById(R.id.facilityreview);
//        TextView facilitytexts = (TextView) view.findViewById(R.id.facilitytext);
//
//        float facilityrate = (float) 3.5;
//
//        facilitytexts.setText(String.valueOf(facilityrate));
//
//        LinearLayout.LayoutParams facilityparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, facilityrate);
//        TextView facilitytext = new TextView(getContext());
//        facilitytext.startAnimation(anim);
//        facilitytext.setBackground(new ColorDrawable(getResources().getColor(R.color.lightblue)));
//        facilitytext.setLayoutParams(facilityparam);
//        facilityreview.addView(facilitytext);
//
//        TextView averagerate = (TextView) view.findViewById(R.id.average);
//
//        float average = (float) (rate + roomrate + cleanrate + comfortrate + servicerate + facilityrate) / 6;
//        averagerate.setText(String.valueOf(average));


        return view;
    }

    private void getRatingOverview() {
        APIInterface api = APiClient.getApiService();
        Call<RatingMain> call = api.gethotelratingbyid(hotelid);
        call.enqueue(new Callback<RatingMain>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onResponse(Call<RatingMain> call, Response<RatingMain> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        LinearLayout layout = new LinearLayout(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        layout.setOrientation(LinearLayout.HORIZONTAL);
                        layout.setWeightSum(3);
                        linearlayout.addView(layout);
                        layoutParams.setMargins(0, 15, 0, 0);
                        layout.setLayoutParams(layoutParams);

                        TextView ratingheading = new TextView(getContext());
                        ratingheading.setText(response.body().getData().get(i).getHotelRatingHeadName().toString());
                        LinearLayout.LayoutParams headingparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 0.8f);
                        ratingheading.setLayoutParams(headingparam);
                        layout.addView(ratingheading);

                        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.left_to_right);

                        ProgressBar progressBar = new ProgressBar(getContext(), null, android.R.attr.progressBarStyleHorizontal);
                        progressBar.setMax(10);
//                        progressBar.startAnimation(anim);
                        float rating = response.body().getData().get(i).getRating();
                        progressBar.setProgress((int)rating);
                        LinearLayout.LayoutParams progress = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1.7f);
                        progressBar.setLayoutParams(progress);
                        layout.addView(progressBar);

                        TextView ratingtext = new TextView(getContext());
                        ratingtext.setText(String.valueOf(rating));
                        LinearLayout.LayoutParams textparam = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,0.5f);
                        ratingtext.setGravity(Gravity.CENTER);
                        ratingtext.setLayoutParams(textparam);
                        layout.addView(ratingtext);


                        totalviews.setText(String.valueOf(response.body().getData().get(i).getCountUsers())+" Views");
                        String average = String.valueOf(response.body().getData().get(i).getTotalRating());
                        float avg = Float.parseFloat(average);
                        averagerate.setText(String.format("%.01f",avg));
                    }

                    getUserOffer();

                }
            }

            @Override
            public void onFailure(Call<RatingMain> call, Throwable t) {

            }
        });
    }

    private void getUserOffer() {
        APIInterface api = APiClient.getApiService();
        Call<UserRatingMain> call = api.getuserratingtohotel(hotelid);
        call.enqueue(new Callback<UserRatingMain>() {
            @Override
            public void onResponse(Call<UserRatingMain> call, Response<UserRatingMain> response) {
                if(response.isSuccessful()){
                    List<UserRating> list = new ArrayList<>();
                    for(int i=0;i<response.body().getData().size();i++){
                        list.add(response.body().getData().get(i));
                    }

                    guestreview.setAdapter(new MyGuestReviewAdapter(getContext(), list));
                }
            }

            @Override
            public void onFailure(Call<UserRatingMain> call, Throwable t) {

            }
        });
    }
}
