package com.example.sanjay.traveljinee;

/**
 * Created by SANJAY on 1/16/2018.
 */

public class StringClass {
    public static String base_url = "http://www.mocky.io/v2/";

    public static String hotel_base_url="http://124.41.193.135:90/";

    String paypal_Client_Id = "AeRg1jn4vhaRp93Ga5TfrEEfGaZJXys9B7cH23crnUmb6j3c7fJSDgs_bNCbHguQqtoPc8pbOb4kP_Ir";
    String paypal_Secrent_Key = "EOb4QALw2VszofKybgexL1w7JKD5Vsr3dibjWWj-Ng7Otj9mqVtVnwLkwQlFgY4SHAH_J1wRWDitFKrJ";

    String pay_pay_Base_URL = "https://api.sandbox.paypal.com/";

    public String getPay_pay_Base_URL() {
        return pay_pay_Base_URL;
    }

    public String getPaypal_Client_Id() {
        return paypal_Client_Id;
    }

    public String getPaypal_Secrent_Key() {
        return paypal_Secrent_Key;
    }

    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }
}
