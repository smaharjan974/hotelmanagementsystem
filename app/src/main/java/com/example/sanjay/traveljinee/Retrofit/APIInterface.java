package com.example.sanjay.traveljinee.Retrofit;



import com.example.sanjay.traveljinee.Booking.Paypal.PayPalPaymentDetails.DetailsMain;
import com.example.sanjay.traveljinee.Booking.Paypal.TokenModel;
import com.example.sanjay.traveljinee.CustomModel.BookingCustomModel;
import com.example.sanjay.traveljinee.CustomModel.MainModel;
import com.example.sanjay.traveljinee.Model.Address.AddressMain;
import com.example.sanjay.traveljinee.Model.Booking.BookingMain;
import com.example.sanjay.traveljinee.Model.Booking.BookingModel;
import com.example.sanjay.traveljinee.Model.BookingPayment.BookingPaymentMain;
import com.example.sanjay.traveljinee.Model.CommonFeatures.CommonFeaturesMain;
import com.example.sanjay.traveljinee.Model.CountryListModel;
import com.example.sanjay.traveljinee.Model.HotelDetails.HotelDetailsMain;
import com.example.sanjay.traveljinee.Model.HotelFeatures.HotelFeaturesMain;
import com.example.sanjay.traveljinee.Model.HotelList.HotelListMain;
import com.example.sanjay.traveljinee.Model.HotelRating.RatingMain;
import com.example.sanjay.traveljinee.Model.HotelRating.UserRating.UserRatingMain;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.LoginMain;
import com.example.sanjay.traveljinee.Model.LoginSignUP.Login.SignUpMain;
import com.example.sanjay.traveljinee.Model.Offers.OffersMain;
import com.example.sanjay.traveljinee.Model.RoomDeal.RoomDealMain;
import com.example.sanjay.traveljinee.SearchHotel.FailedToken;
import com.example.sanjay.traveljinee.SearchHotel.HotelModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by SANJAY on 11/12/2017.
 */

public interface APIInterface {

    //get country list
    @GET("5a5d91b6330000060419180c")
    Call<List<CountryListModel>> getcountrylist();

    //getpaypal token
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
             })
    @POST("v1/oauth2/token")
    Call<TokenModel> getToken(@Header("Authorization") String auth,
                               @Query("grant_type") String code);

    //get paypal details about payment
    @Headers("Content-Type: application/json")
    @GET("v1/payments/payment/{pay-Id}")
    Call<DetailsMain> getDetailsPayment(@Path("pay-Id") String payid,
                                        @Header("Authorization") String token);

    @POST("api/v1/hotelSearchList/getHotels")
    Call<HotelListMain> getHotelList();

    @Headers("Content-Type: application/json")
    @POST("api/v1/hotelSearch/getHotels")
    Call<HotelListMain> getHotelListByParameter(@Body MainModel model);

    @POST("api/v1/roomDeals/getRoomDeals/{hotelId}")
    Call<RoomDealMain> getRoomdealbyHotelid(@Path("hotelId") int hotelid);

    @POST("api/v1/hotelDetailDescription/getHotelDetailDescription/{hotelId}")
    Call<HotelDetailsMain> getHoteldetailsbyId(@Path("hotelId") int hotelid);

    @POST("api/v1/hotelDetailFeatures/getHotelDetailFeatures/{hotelId}")
    Call<HotelFeaturesMain> gethotelfeaturesbyid(@Path("hotelId") int hotelid);

    @POST("api/v1/ratingOverview/getRatingOverview/{hotelId}")
    Call<RatingMain> gethotelratingbyid(@Path("hotelId") int hotelid);

    @POST("api/v1/hotelReview/getHotelReview/{hotelId}")
    Call<UserRatingMain> getuserratingtohotel(@Path("hotelId") int hotelid);

    @POST("api/v1/city/getCityList")
    Call<AddressMain> getadress();

    @POST("api/v1/offers/getOffers")
    Call<OffersMain> getoffers();

    @Headers("Content-Type: application/json")
    @POST("api/v1/hotelBooking/saveHotelBooking")
    Call<BookingMain> getbooking(@Body BookingCustomModel bookingModel);

    @POST("api/v1/bookingPayment/saveBookingPayment")
    Call<BookingPaymentMain> getsavebookingpayment(@Query("BookingId") int bookingId, @Query("Amount") String amount, @Query("PaymentGatewayId") int paymentgatewayid,
                                                   @Query("PayId") String payid, @Query("TransactionId") String TransactionId, @Query("Remarks") String remarks);

    @POST("api/v1/Account/Login")
    Call<Object> getlogin(@Query("Email") String email, @Query("Password") String password);

    @POST("api/v1/Account/Register")
    Call<Object> getRegister(@Query("Email") String email, @Query("Password") String password, @Query("ConfirmPassword") String confirmpassword);

    @POST("api/v1/features/getFeatures")
    Call<CommonFeaturesMain> getCommonFeatures();
}
