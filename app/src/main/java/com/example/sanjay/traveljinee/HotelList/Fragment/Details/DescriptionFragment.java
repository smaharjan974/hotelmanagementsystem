package com.example.sanjay.traveljinee.HotelList.Fragment.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.sanjay.traveljinee.Model.HotelDetails.HotelDetailsMain;
import com.example.sanjay.traveljinee.Model.HotelFeatures.HotelFeatures;
import com.example.sanjay.traveljinee.Model.HotelFeatures.HotelFeaturesMain;
import com.example.sanjay.traveljinee.NonScrollListView;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SANJAY on 1/2/2018.
 */

public class DescriptionFragment extends Fragment {

    ReadMoreTextView description;

    NonScrollListView amenities,amenities2;
    MyListViewDetailsAdapter adapter,adapter2;
    List<String> list,list2;

    int hotelid;
    List<HotelFeatures> features;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.description_fragment, container, false);

        description = view.findViewById(R.id.description);
        amenities = (NonScrollListView)view.findViewById(R.id.amenities);
        amenities2 = (NonScrollListView)view.findViewById(R.id.amenities2);

        if (getArguments() != null) {
            String  mParam1 = getArguments().getString("params");
            Log.d("asdf", "onCreateView: "+mParam1);

            hotelid = getArguments().getInt("hotelid");
            Log.d("asdf", "onCreateView: " + hotelid);

            getHotelDetails();

        }

        Log.d("asdf", "onCreateView: asdf");

        List<DetailsModel> newlist = new ArrayList<>();
        newlist.add(new DetailsModel(R.drawable.icon_tick,"WIFI"));
        newlist.add(new DetailsModel(R.drawable.icon_hotel_service,"Food"));
        newlist.add(new DetailsModel(R.drawable.icon_share,"Shared Room"));
        newlist.add(new DetailsModel(R.drawable.icon_tick,"sadf"));
        newlist.add(new DetailsModel(R.drawable.icon_tick,"asdfdsaf"));

//        list = new ArrayList<>();
//        list2 = new ArrayList<>();
//        for(int i=0;i<newlist.size();i++){
//            if(i%2==0){
//                list.add(newlist.get(i));
//            }else{
//                list2.add(newlist.get(i));
//            }
//        }

//        list = new ArrayList<>();
//        list.add(new DetailsModel(R.drawable.icon_tick,"WIFI"));
//        list.add(new DetailsModel(R.drawable.icon_hotel_service,"Food"));
//
//        list2 = new ArrayList<>();
//        list2.add(new DetailsModel(R.drawable.icon_share,"Shared Room asdf adf asdf sad sdf sdf"));
//        list2.add(new DetailsModel(R.drawable.icon_tick,"sadf"));
//        list2.add(new DetailsModel(R.drawable.icon_tick,"asdfdsaf"));

//        amenities.setAdapter(new MyListViewDetailsAdapter(getActivity(),list));
//        amenities2.setAdapter(new MyListViewDetailsAdapter(getActivity(),list2));

        return view;
    }

    private void getHotelDetails() {
            APIInterface api = APiClient.getApiService();
            Call<HotelDetailsMain> call = api.getHoteldetailsbyId(hotelid);
            call.enqueue(new Callback<HotelDetailsMain>() {
                @Override
                public void onResponse(Call<HotelDetailsMain> call, Response<HotelDetailsMain> response) {
                    if(response.isSuccessful()){
                        String desc = Html.fromHtml(response.body().getData().getDescription()).toString();
                        description.setText(desc);
                    }

                    getHotelFeaturesbyid();
                }

                @Override
                public void onFailure(Call<HotelDetailsMain> call, Throwable t) {

                }
            });
    }

    private void getHotelFeaturesbyid() {
        APIInterface api = APiClient.getApiService();
        Call<HotelFeaturesMain> call = api.gethotelfeaturesbyid(hotelid);
        call.enqueue(new Callback<HotelFeaturesMain>() {
            @Override
            public void onResponse(Call<HotelFeaturesMain> call, Response<HotelFeaturesMain> response) {
                if(response.isSuccessful()){
                    features = new ArrayList<>();
                    for(int i=0;i<response.body().getData().size();i++) {
                        features.add(response.body().getData().get(i));
                    }

                    list = new ArrayList<>();
                    list2 = new ArrayList<>();
                    for(int i=0;i<features.size();i++){
                        if(i%2==0){
                            list.add(features.get(i).getFeatureName().toString());
                        }else{
                            list2.add(features.get(i).getFeatureName().toString());
                        }
                    }

                    amenities.setAdapter(new MyListViewDetailsAdapter(getActivity(),list));
                    amenities2.setAdapter(new MyListViewDetailsAdapter(getActivity(),list2));
                }
            }

            @Override
            public void onFailure(Call<HotelFeaturesMain> call, Throwable t) {

            }
        });
    }
}
