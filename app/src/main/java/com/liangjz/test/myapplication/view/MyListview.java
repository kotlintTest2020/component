package com.liangjz.test.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListview extends ListView {
    private final static String TAG = "MyListview";
    public MyListview(Context context) {
        super(context);
    }

    public MyListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.i(TAG,ev.toString());
        return super.onTouchEvent(ev);
    }
}
