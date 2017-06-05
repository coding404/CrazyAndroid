package com.liushu.crazyandroid.ui.stage01.chapter01.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.andexert.calendarlistview.library.DatePickerController;
import com.andexert.calendarlistview.library.DayPickerView;
import com.andexert.calendarlistview.library.SimpleMonthAdapter;
import com.google.gson.Gson;
import com.jaydenxiao.common.base.BaseFragment;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.bean.CatalogBean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by liushu on 2017/2/3.
 */

public class Chapter01Fragment extends BaseFragment implements DatePickerController {

    @Bind(R.id.day_picker)
    DayPickerView mDayPicker;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_chape01;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // readFromAssets();
        mDayPicker.setController(this);
    }

    /**
     * 从assets中读取txt
     */
    private void readFromAssets() {
        try {
            InputStream is = getActivity().getAssets().open("chapter02.txt");
            String text = readTextFromSDcard(is);

            Gson gson = new Gson();
            CatalogBean catalogBean02 = gson.fromJson(text, CatalogBean.class);
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

    @Override
    public int getMaxYear() {
        return 2020;
    }

    @Override
    public void onDayOfMonthSelected(int year, int month, int day) {

    }

    @Override
    public void onHourSelected(String ourString) {

    }

    @Override
    public void onDateRangeSelected(SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays) {
        Toast.makeText(getContext(), selectedDays.getFirst().toString() + " --> " + selectedDays.getLast().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
