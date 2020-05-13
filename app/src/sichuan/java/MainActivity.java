package com.liangjz.test.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.liangjz.test.myapplication.view.HeaderView;
import com.liangjz.test.myapplication.view.adapter.MyFragmentPageradapter;
import com.liangjz.test.myapplication.view.adapter.MyviewPageradapter;
import com.liangjz.test.myapplication.view.fragment.FirstFragment;
import com.liangjz.test.myapplication.view.fragment.SecondFragment;
import com.liangjz.test.myapplication.view.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private final static String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.header_view)
    HeaderView mHeaderView;
    @BindView(R.id.viewpage)
    ViewPager viewpage;

    //viewpager里面是view
    private MyviewPageradapter mViewAdapter;
    private List<View> mViewList;

    //viewpager里面是fragment
    private MyFragmentPageradapter myFragmentPageradapter;
    private List<Fragment> mFragmentList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initListener();
    }

    private void initListener() {
        mHeaderView.setOnClickListener(new HeaderView.CallbackListener() {
            @Override
            public void leftClickListener() {
                Log.i(TAG,"leftClick");
            }

            @Override
            public void rightClickListener() {
                Log.i(TAG,"rightClick");
            }
        });
        viewpage.addOnPageChangeListener(this);
    }

    private void init() {
        mViewList = new ArrayList<>();
        mViewAdapter = new MyviewPageradapter(mViewList);

        mFragmentList = new ArrayList<>();
        myFragmentPageradapter = new MyFragmentPageradapter(getSupportFragmentManager(),mFragmentList);

//        viewpage.setAdapter(mViewAdapter);
        viewpage.setAdapter(myFragmentPageradapter);
//        for(int i : new int[4]){
//            View view = getLayoutInflater().from(this).inflate(R.layout.fragment_view,null);
//            mViewList.add(view);
//        }
        mFragmentList.add(new FirstFragment());
        mFragmentList.add(new SecondFragment());
        mFragmentList.add(new ThirdFragment());
        myFragmentPageradapter.notifyDataSetChanged();
//        mViewAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPageSelected(int position) {
        Log.i(TAG,"onPageSelected position:" + position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.i(TAG,"onPageScrolled position:" + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i(TAG,"onPageScrollStateChanged state:" + state);
    }

}
