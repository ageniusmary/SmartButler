package com.example.mary.smartbutler.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.example.mary.smartbutler.R;

/**
 * 项目名：  SmartButler.
 * 包名 ：   com.example.mary.smartbutler.view.
 * 文件名：  CustomDialog.
 * 创建者：  mary.
 * 创建时间：2017/10/19 21:50.
 * 描述：    自定义Dialog
 */

public class CustomDialog extends Dialog{

    //定义模板
    public CustomDialog(Context context,int layout,int style) {
        this(context, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,layout,style,Gravity.CENTER);
    }

    //定义属性
    public CustomDialog(Context context,int width,int height,int layout,int style,int gravity,int anim){
        super(context,style);
        //设置属性
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParms = window.getAttributes();
        layoutParms.width = width;
        layoutParms.height = height;
        layoutParms.gravity = gravity;
        window.setAttributes(layoutParms);
        window.setWindowAnimations(anim);
    }

    //实例
    public CustomDialog(Context context,int width,int height,int layout,int style,int gravity){
        this(context,width,height,layout,style,gravity,R.style.pop_anim_style);
    }
}
