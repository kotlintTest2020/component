package com.liangjz.test.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liangjz.test.myapplication.R;

public class HeaderView extends RelativeLayout {
    private final static String TAG = HeaderView.class.getSimpleName();
    private CallbackListener mListener;
    private int showView;
    private TextView mMiddleTv;
    private Button mLeftBtn,mRightBtn;
    public HeaderView(Context context) {
        super(context);
        initView(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        getArray(context, attrs);
        initListener();
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        getArray(context,attrs);
        initListener();
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
        getArray(context,attrs);
        initListener();
    }
    private void getArray(Context context, AttributeSet attrs){
        mLeftBtn.setVisibility(View.GONE);
        mRightBtn.setVisibility(View.GONE);
        mMiddleTv.setVisibility(View.GONE);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.HeaderView);
        showView = array.getInt(R.styleable.HeaderView_show_view,0);
        Long data = Long.valueOf(Integer.toBinaryString(showView));
        char[] c = String.format("%03d",data).toCharArray();
        for(int i = 0; i < c.length; i++){
            switch (i) {
                case 0:
                    if (c[i] == '1') {
                        mRightBtn.setVisibility(View.VISIBLE);
                    } else {
                        mRightBtn.setVisibility(GONE);
                    }
                    break;
                case 1:
                    if (c[i] == '1') {
                        mMiddleTv.setVisibility(View.VISIBLE);
                    } else {
                        mMiddleTv.setVisibility(GONE);
                    }
                    break;
                case 2:
                    if (c[i] == '1') {
                        mLeftBtn.setVisibility(View.VISIBLE);
                    } else {
                        mLeftBtn.setVisibility(GONE);
                    }
                    break;
            }
        }
    }
    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.head_layout,this);
        mLeftBtn = view.findViewById(R.id.left_btn);
        mRightBtn = view.findViewById(R.id.right_btn);
        mMiddleTv = view.findViewById(R.id.middle_tv);
    }
    private void initListener(){
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null && mLeftBtn.getVisibility() == View.VISIBLE){
                    mListener.leftClickListener();
                }
            }
        });
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null && mRightBtn.getVisibility() == View.VISIBLE)
                    mListener.rightClickListener();
            }
        });
    }

    public void setOnClickListener(CallbackListener listener){
        mListener = listener;
    }

    public interface CallbackListener{
        void leftClickListener();
        void rightClickListener();
    }
}
