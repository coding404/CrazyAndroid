package com.liushu.crazyandroid.ui.stage01.chapter01.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.bean.CatalogBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter01Fragment extends Fragment{

    private TextView mTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_chape01,null);
        mTextView= (TextView) view.findViewById(R.id.tv_chape01);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        readFromAssets();
    }

    /**
     * 从assets中读取txt
     */
    private void readFromAssets() {
        try {
            InputStream is = getActivity().getAssets().open("chapter02.txt");
            String text = readTextFromSDcard(is);

            Gson gson=new Gson();
            CatalogBean catalogBean02 = gson.fromJson(text, CatalogBean.class);
            mTextView.setText(catalogBean02.getChapters().get(0).getChapterName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 按行读取txt
     *
     * @param is
     * @return
     * @throws Exception
     */
    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
