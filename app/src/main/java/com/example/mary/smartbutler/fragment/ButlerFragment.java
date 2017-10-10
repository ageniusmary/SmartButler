package com.example.mary.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mary.smartbutler.R;

/**
 * 项目名：  SmartButler.
 * 报名 ：   com.example.mary.smartbutler.fragment.
 * 文件名：  ButlerFragment.
 * 创建者：  mary.
 * 创建时间：2017/10/9 23:01.
 * 描述：    TODO
 */

public class ButlerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butler,null);
        return view;
    }
}
