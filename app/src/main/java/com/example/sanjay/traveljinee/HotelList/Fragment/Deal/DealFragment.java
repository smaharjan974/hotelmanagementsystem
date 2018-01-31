package com.example.sanjay.traveljinee.HotelList.Fragment.Deal;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Model.RoomDeal.RoomDeal;
import com.example.sanjay.traveljinee.Model.RoomDeal.RoomDealMain;
import com.example.sanjay.traveljinee.NonScrollListView;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SANJAY on 1/2/2018.
 */

public class DealFragment extends Fragment {

    List<Model> modellist;
    List<String> features, featuers1;
    List<String> services, services1;

    senddealfragmentdetails mcall;

    int hotelid;
    List<RoomDeal> list;

    ProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.deal_fragment, container, false);

        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setTitle("Loading");
        dialog.setMessage("Loading Hotel List. Please Wait...");
        dialog.show();

        NonScrollListView listView = (NonScrollListView) view.findViewById(R.id.lstview);
        listView.setFocusable(false);
        LinearLayout temp = view.findViewById(R.id.temp);
        temp.requestFocus();

        ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollview);

        scrollView.post(new Runnable() {
            @Override
            public void run() {
                ((ScrollView) view.findViewById(R.id.scrollview)).fullScroll(View.FOCUS_UP);
            }
        });

        if (getArguments() != null) {
            String mParam1 = getArguments().getString("params");
//            Log.d("asdf", "onCreateView: " + mParam1);

            hotelid = getArguments().getInt("hotelid");
            Log.d("asdf", "onCreateView: " + hotelid);

            APIInterface api = APiClient.getApiService();
            Call<RoomDealMain> call = api.getRoomdealbyHotelid(hotelid);
            call.enqueue(new Callback<RoomDealMain>() {
                @Override
                public void onResponse(Call<RoomDealMain> call, Response<RoomDealMain> response) {
                    if (response.isSuccessful()) {
                        Log.d("adsf", "onResponse: ");
                        list = new ArrayList<>();
                        dialog.dismiss();
                        List<Integer> roomidlist = new ArrayList<>();
                        List<String> facilityList = new ArrayList<>();
                        List<String> serviceList = new ArrayList<>();


                        //Log.d("fsgsd", "onResponse: " + String.valueOf(uniquify(response.body().getData().).size()));

                        for(int i = 0;i<response.body().getData().size();i++){
                            roomidlist.add(response.body().getData().get(i).getRoomId());
//                            facilityList.add(response.body().getData().get(i).getFacilityName());
//                            serviceList.add(response.body().getData().get(i).getFacilityName());
                        }
//                        Log.d("fsgsds", "onResponse: " + new Gson().toJson(facilityList));
                        for (int i = 0; i<uniquify(roomidlist).size();i++){
                            int roomid= uniquify(roomidlist).get(i);


                            if(response.body().getData().get(i).getRoomId()== roomid){
                                ////facilityList.add()
                            }

                        }



                        Log.d("fsgsd", "onResponse: " + String.valueOf(uniquify(roomidlist).size()));

                    } else {
                        Log.d("asdf", "onResponse:  failed");
                    }

                }

                @Override
                public void onFailure(Call<RoomDealMain> call, Throwable t) {
                    dialog.dismiss();
                    Log.d("asdf", "onFailure: " + t);
                }
            });

        }


        features = new ArrayList<>();
        features.add("Room with a view");
        features.add("Mountain View");
        features.add("Landmark view");
        features.add("City view");

        featuers1 = new ArrayList<>();
        featuers1.add("Room with a view");
        featuers1.add("Mountain view");

        services = new ArrayList<>();
        services.add("Has a balcony");
        services.add("Very good breakfast included in the price.");
        services.add("FREE cancellation before 21 dec");
        services.add("NO PAYMENT NEEDED - pay at the property");

        services1 = new ArrayList<>();
        services1.add("Has a balcony");
        services1.add("Very good breakfast included in the price.");
        services1.add("FREE cancellation before 21 dec");

        modellist = new ArrayList<>();
        modellist.add(new Model("Double Room", String.valueOf(2), String.valueOf(1), features, services, "good newssasdfa asf", "US$50"));
        modellist.add(new Model("Deluxe Room", String.valueOf(2), String.valueOf(2), featuers1, services1, "", "US$40"));


//        List<String> list = new ArrayList<>();
//        list.add("Price for 1 Night");
//        list.add("Price for 2 Night");
//        list.add("Price for 3 Night");
//        list.add("Price for 3 Night");
//        list.add("Price for 3 Night");
//        list.add("Price for 3 Night");

        listView.setAdapter(new MyListViewAdapter(getActivity(), modellist));

        mcall.send_deal_fragment_dteials("9849805388");

        return view;
    }

    public interface senddealfragmentdetails {
        void send_deal_fragment_dteials(String ph);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mcall = (senddealfragmentdetails) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    @Override
    public void onDetach() {
        mcall = null; // => avoid leaking, thanks @Deepscorn
        super.onDetach();
    }

    public List<Integer> uniquify(List<Integer> list) {
        List<Integer> original = list;
        List<Integer> uniques = new ArrayList<Integer>();
        for (Integer element : original) {
            if (!uniques.contains(element)) {
                uniques.add(element);
            }
        }
        return uniques;
    }
}
