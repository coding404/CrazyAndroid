package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.liushu.crazyandroid.R;

public class Demo020102Activity extends AppCompatActivity {

    int[] images = new int[]{R.drawable.back1,
            R.mipmap.ic_launcher,
            R.drawable.back1};
    int currentImg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020102);
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_demo020102);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(images[0]);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(images[++currentImg % images.length]);
            }
        });
        layout.addView(imageView);
    }
}
