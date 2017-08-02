package com.liushu.crazyandroid.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseFragment;
import com.liushu.crazyandroid.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/1/26.
 */

public class SecondFragment extends BaseFragment {

    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.lv_test)
    ListView mLvTest;
    @Bind(R.id.ll_title)
    LinearLayout mLlTitle;
    private float mDownX;
    private float mDownY;

    private float mMoveX;
    private float mMoveY;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_second;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

        SecondAdapter adapter = new SecondAdapter();
        mLvTest.setAdapter(adapter);
        mLvTest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mDownX = event.getX();
                        mDownY = event.getY();
                        Log.e("22222", "x:" + mDownX + "y:" + mDownY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mMoveX = mDownX - event.getX();
                        mMoveY = mDownY - event.getY();
                        Log.e("222221", "x1:" + mMoveX / 1.8f + "y1:" + mMoveY / 1.8f);
                        updateHeaderHeight(-(float) (mMoveY/1.8));
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        mTvTitle.measure(w, h);
        int height = mTvTitle.getMeasuredHeight();
        int width = mTvTitle.getMeasuredWidth();
        mTvTitle.setText(height + "," + width);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public static class SecondAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return 60;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_test, null);
            return view;
        }
    }

    private void updateHeaderHeight(float delta) {
        int height = (int) (delta + mLlTitle.getHeight());
        if (height < 0) { height = 0; }
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mLlTitle.getLayoutParams();
        lp.height = height;
        mLlTitle.setLayoutParams( lp );
    }
}
