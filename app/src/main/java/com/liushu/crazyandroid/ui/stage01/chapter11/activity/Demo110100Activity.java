package com.liushu.crazyandroid.ui.stage01.chapter11.activity;

import android.media.MediaRecorder;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.io.File;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo110100Activity extends BaseActivity {
    // 定义界面上的两个按钮
    ImageButton record, stop;
    // 系统的音频文件
    File soundFile;
    MediaRecorder mRecorder;
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title_name)
    TextView mTvTitleName;
    @Bind(R.id.record)
    ImageButton mRecord;
    @Bind(R.id.stop)
    ImageButton mStop;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo110100;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitleName.setText("录制音乐");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (soundFile != null && soundFile.exists()) {
            // 停止录音
            mRecorder.stop();
            // 释放资源
            mRecorder.release();
            mRecorder = null;
        }
    }


    @OnClick({R.id.iv_back, R.id.record, R.id.stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            // 单击录音按钮
            case R.id.record:
                if (!Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(Demo110100Activity.this, "SD卡不存在，请插入SD卡！",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    // 创建保存录音的音频文件
                    soundFile = new File(Environment
                            .getExternalStorageDirectory().getCanonicalFile()
                            + "/sound.amr");
                    mRecorder = new MediaRecorder();
                    // 设置录音的声音来源
                    mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    // 设置录制的声音的输出格式（必须在设置声音编码格式之前设置）
                    mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                    // 设置声音编码的格式
                    mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                    mRecorder.setOutputFile(soundFile.getAbsolutePath());
                    mRecorder.prepare();
                    // 开始录音
                    mRecorder.start();  // ①
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            // 单击停止按钮
            case R.id.stop:
                if (soundFile != null && soundFile.exists()) {
                    // 停止录音
                    mRecorder.stop();  // ②
                    // 释放资源
                    mRecorder.release();  // ③
                    mRecorder = null;
                }
                break;
        }
    }
}
