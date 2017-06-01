package com.liushu.crazyandroid.ui.stage01.chapter11.activity;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.liushu.crazyandroid.R;

import java.util.HashMap;

public class Demo110001Activity extends Activity implements View.OnClickListener {
    private Button mBtnBomb;
    private Button mBtnShot;
    private Button mBtnArrow;
    // 定义一个SoundPool
    SoundPool mSoundPool;
    HashMap<Integer, Integer> mSoundMap = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo110001);
        mBtnBomb = (Button) findViewById(R.id.btn_bomb);
        mBtnShot = (Button) findViewById(R.id.btn_shot);
        mBtnArrow = (Button) findViewById(R.id.btn_arrow);
        AudioAttributes attr = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME) // 设置音效使用场景
                // 设置音效的类型
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attr) // 设置音效池的属性
                .setMaxStreams(10) // 设置最多可容纳10个音频流，
                .build();  // ①
        // load方法加载指定音频文件，并返回所加载的音频ID
        // 此处使用HashMap来管理这些音频流
        mSoundMap.put(1, mSoundPool.load(this, R.raw.bomb, 1));  // ②
        mSoundMap.put(2, mSoundPool.load(this, R.raw.shot, 1));
        mSoundMap.put(3, mSoundPool.load(this, R.raw.arrow, 1));
        mBtnBomb.setOnClickListener(this);
        mBtnShot.setOnClickListener(this);
        mBtnArrow.setOnClickListener(this);
    }

    // 重写OnClickListener监听器接口的方法
    @Override
    public void onClick(View source) {
        // 判断哪个按钮被单击
        switch (source.getId()) {
            case R.id.btn_bomb:
                mSoundPool.play(mSoundMap.get(1), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_shot:
                mSoundPool.play(mSoundMap.get(2), 1, 1, 0, 0, 1);
                break;
            case R.id.btn_arrow:
                mSoundPool.play(mSoundMap.get(3), 1, 1, 0, 0, 1);
                break;
        }
    }
}