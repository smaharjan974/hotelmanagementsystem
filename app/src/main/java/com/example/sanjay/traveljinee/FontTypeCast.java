package com.example.sanjay.traveljinee;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by SANJAY on 1/3/2018.
 */

public class FontTypeCast extends TextView {
    public FontTypeCast(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public FontTypeCast(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public FontTypeCast(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        // Just Change your font name
        Fonts fonts = new Fonts(getContext());
        Typeface oregon = fonts.getBodoniTypeface();
        setTypeface(oregon);
    }
}
    

