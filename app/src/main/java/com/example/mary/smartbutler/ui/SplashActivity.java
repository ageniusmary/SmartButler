package com.example.mary.smartbutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mary.smartbutler.MainActivity;
import com.example.mary.smartbutler.R;
import com.example.mary.smartbutler.utils.ShareUtils;
import com.example.mary.smartbutler.utils.StaticClass;
import com.example.mary.smartbutler.utils.UtilTools;

/**
 * 项目名：  SmartButler.
 * 包名 ：   com.example.mary.smartbutler.ui.
 * 文件名：  SplashActivity.
 * 创建者：  mary.
 * 创建时间：2017/10/11 9:35.
 * 描述：    闪屏页
 */

public class SplashActivity extends AppCompatActivity{

    /**
     * 1.延时2000ms
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.activity全屏主题
     * @param savedInstanceState
     */

    private TextView tv_splash;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否第一次运行
                    if(isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }

        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    //初始化view
    private void initView() {

        //延时2000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,2000);
        tv_splash = (TextView) findViewById(R.id.tv_splash);

        //设置字体
        UtilTools.setFont(this,tv_splash);

    }

    //判断程序是否第一次运行
    private boolean isFirst() {
        boolean isFirst = ShareUtils.getBoolean(this,StaticClass.SHARE_IS_First,true);
        if(isFirst){
            //标记我们已经启动的app  第一次运行后设置为false  以后再打开就不用打开闪屏页
            ShareUtils.putBoolean(this,StaticClass.SHARE_IS_First,false);
            return true;
        }else{
            return false;
        }
    }

    //禁止返回键
    @Override
    public void onBackPressed() {

    }
}
