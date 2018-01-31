package com.example.sanjay.traveljinee.HotelList.Fragment.MapFragment;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sanjay.traveljinee.Model.HotelDetails.HotelDetailsMain;
import com.example.sanjay.traveljinee.R;
import com.example.sanjay.traveljinee.Retrofit.APIInterface;
import com.example.sanjay.traveljinee.Retrofit.APiClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SANJAY on 1/8/2018.
 */

public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap map;
    View view;

    int hotelid;
    double longittude,lattitude;
    String hotelname;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(googleServiceAvailable()){
            Toast.makeText(getActivity(), "Perfect", Toast.LENGTH_SHORT).show();
            view = inflater.inflate(R.layout.map_fragment, null);

            if (getArguments() != null) {
                String  mParam1 = getArguments().getString("params");
                Log.d("asdf", "onCreateView: "+mParam1);

                hotelid = getArguments().getInt("hotelid");
                Log.d("asdf", "onCreateView: " + hotelid);

                getHotelDetails();

            }

            init();
        }else{
            //No google maps
            Toast.makeText(getContext(), "no data", Toast.LENGTH_SHORT).show();
        }
        return view;
    }

    private void init() {
       SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.fragment2);
        mapFragment.getMapAsync(this);
    }

    public boolean googleServiceAvailable(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(getActivity());
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        }else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(getActivity(),isAvailable,0);
            dialog.show();
        }
        else {
            Toast.makeText(getActivity(), "Cant connect", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

    }

    private void gotolocation(double lattitude, double longitude,float zoom) {
        LatLng latLng = new LatLng(lattitude,longitude);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng,zoom);
        map.moveCamera(update);

    }

    private void getHotelDetails() {
        APIInterface api = APiClient.getApiService();
        Call<HotelDetailsMain> call = api.getHoteldetailsbyId(hotelid);
        call.enqueue(new Callback<HotelDetailsMain>() {
            @Override
            public void onResponse(Call<HotelDetailsMain> call, Response<HotelDetailsMain> response) {
                if(response.isSuccessful()){
                    longittude = response.body().getData().getLongitude();
                    lattitude = response.body().getData().getLatitude();
                    hotelname = response.body().getData().getHotelName();

                    map.addMarker(new MarkerOptions().position(new LatLng(lattitude,longittude)).title(hotelname));
                    gotolocation(lattitude,longittude,15);
                }
            }

            @Override
            public void onFailure(Call<HotelDetailsMain> call, Throwable t) {

            }
        });
    }
}
