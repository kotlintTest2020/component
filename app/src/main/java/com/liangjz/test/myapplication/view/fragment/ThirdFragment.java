package com.liangjz.test.myapplication.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liangjz.test.myapplication.R;

public class ThirdFragment extends Fragment {
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_view,null);
    }
}
