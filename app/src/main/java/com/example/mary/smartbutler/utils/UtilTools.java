package com.example.mary.smartbutler.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import static com.example.mary.smartbutler.R.id.tv_splash;

/**
 * Created by mary on 2017/10/9.
 * 工具统一类
 */

public class UtilTools {

    //设置字体
    public static void setFont(Context mContext, TextView textview){
        Typeface fontType = Typeface.createFromAsset(mContext.getAssets(),"fonts/FONT.ttf");
        textview.setTypeface(fontType);
    }
}
