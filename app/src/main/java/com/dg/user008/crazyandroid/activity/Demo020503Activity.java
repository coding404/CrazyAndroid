package com.dg.user008.crazyandroid.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Demo020503Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_demo020503);
        String[] strings={"hello","world","22222","sssss"};
        ArrayAdapter<String > adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,strings);
        setListAdapter(adapter);
    }
}
