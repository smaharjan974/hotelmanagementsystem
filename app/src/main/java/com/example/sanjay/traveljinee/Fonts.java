package com.example.sanjay.traveljinee;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by SANJAY on 1/3/2018.
 */

public class Fonts {
    Typeface bodoni;
    Context context;

    public Fonts(Context con) {
        this.context= con;
    }



    public Typeface getBodoniTypeface(){
        bodoni=Typeface.createFromAsset(context.getAssets(),"bodoni.ttf");
        return bodoni;
    }
}
