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

import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModel;
import com.example.sanjay.traveljinee.CustomModel.HotelDetailsWithModelRoomDeal;
import com.example.sanjay.traveljinee.CustomModel.RoomDealModel;
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
    List<String> feat,serv;
    NonScrollListView listView;

    HotelDetailsWithModel hotelDetailsWithModel;
    List<HotelDetailsWithModelRoomDeal> hotelDetailsWithModelRoomDeal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.deal_fragment, container, false);

        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setTitle("Loading");
        dialog.setMessage("Loading Hotel List. Please Wait...");
        dialog.show();

        listView = (NonScrollListView) view.findViewById(R.id.lstview);
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
            hotelDetailsWithModel = new Gson().fromJson(mParam1,HotelDetailsWithModel.class);

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

                        for(int i = 0;i<response.body().getData().size();i++){
                            roomidlist.add(response.body().getData().get(i).getRoomId());
                            if(response.body().getData().get(i).getCost()==0) {
                                facilityList.add(response.body().getData().get(i).getFacilityName());
                            }else {
                                serviceList.add(response.body().getData().get(i).getFacilityName());
                            }
                        }
                        feat = uniquifyfeatures(facilityList);
                        serv = uniquifyfeatures(serviceList);

                        List<RoomDealModel> model = new ArrayList<>();
                        hotelDetailsWithModelRoomDeal = new ArrayList<>();
                        for(int i=0;i<uniquify(roomidlist).size();i++){
                            int roomid= uniquify(roomidlist).get(i);
                            String roomtype = null,sleep=null,bed=null,price=null;
                            for(int j=0;j<response.body().getData().size();j++){
                                if(roomid==response.body().getData().get(j).getRoomId()){
                                     roomtype = response.body().getData().get(j).getRoomTypeName();
                                     sleep = response.body().getData().get(j).getMaxOccupancy().toString();
                                     bed = response.body().getData().get(j).getNoOfBed().toString();
                                     price = response.body().getData().get(j).getPricePerday().toString();
                                }else {
                                    //do nothing
                                }
                            }

                            Log.d("roomid", "onResponse: "+response.body().getData().get(i).getRoomTypeId());

                            model.add(new RoomDealModel(hotelid, response.body().getData().get(i).getRoomTypeId(),roomtype,sleep,bed,feat,serv,price));
                            hotelDetailsWithModelRoomDeal.add(new HotelDetailsWithModelRoomDeal(hotelDetailsWithModel,new RoomDealModel(hotelid,response.body().getData().get(i).getRoomTypeId(),roomtype,sleep,bed,feat,serv,price)));
                        }
                        listView.setAdapter(new MyListViewAdapter(getActivity(), hotelDetailsWithModelRoomDeal));

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

    public List<String> uniquifyfeatures(List<String> list) {
        List<String> original = list;
        List<String> uniques = new ArrayList<String>();
        for (String element : original) {
            if (!uniques.contains(element)) {
                uniques.add(element);
            }
        }
        return uniques;
    }
}
