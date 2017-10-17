package com.example.mary.smartbutler;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mary.smartbutler.fragment.ButlerFragment;
import com.example.mary.smartbutler.fragment.GirlFragment;
import com.example.mary.smartbutler.fragment.UserFragment;
import com.example.mary.smartbutler.fragment.WechatFragment;
import com.example.mary.smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TabLayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String>mTitle;
    //Fragment
    private List<Fragment>mFragment;
    //悬浮窗
    private FloatingActionButton fab_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    //初始化数据
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("服务管家");
        mTitle.add("微信精选");
        mTitle.add("美女社区");
        mTitle.add("个人中心");

        mFragment = new ArrayList<>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());

    }

    //初始化View
    private void initView() {
        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);
        //默认隐藏
        fab_setting.setVisibility(View.GONE);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //当页面滑动时，这个方法将被调用
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当新页面将被选中时调用，动画不是必需完成的,也就是说可能动画还在继续的时候，这个方法就被调用了。
            @Override
            public void onPageSelected(int position) {
                Log.i("TAG","position"+position);
                if(position == 0){
                    fab_setting.setVisibility(View.GONE);
                }else{
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            //当滑动状态改变时被调用，有助于发现当用户开始拖拽，当页面自动的安放在当前页面，或当页面完全停止。
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }
            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
            break;
        }
    }
}
