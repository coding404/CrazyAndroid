package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.io.File;
import java.util.Locale;
import butterknife.BindView;
import butterknife.OnClick;

public class Demo080400Activity extends BaseActivity {
    TextToSpeech tts;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.txt)
    EditText mTxt;
    @BindView(R.id.speech)
    Button mSpeech;
    @BindView(R.id.record)
    Button mRecord;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080400;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("自动朗读");
// 初始化TextToSpeech对象
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // 如果装载TTS引擎成功
                if (status == TextToSpeech.SUCCESS) {
                    // 设置使用美式英语朗读
                    int result = tts.setLanguage(Locale.US);
                    // 如果不支持所设置的语言
                    if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                            && result != TextToSpeech.LANG_AVAILABLE) {
                        Toast.makeText(Demo080400Activity.this, "TTS暂时不支持这种语言的朗读。", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关闭TextToSpeech对象
        if (tts != null) {
            tts.shutdown();
        }
    }


    @OnClick({R.id.iv_back, R.id.speech, R.id.record})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.speech:
                // 执行朗读
                tts.speak(mTxt.getText().toString(), TextToSpeech.QUEUE_ADD, null, "speech");
                break;
            case R.id.record:
                // 将朗读文本的音频记录到指定文件
                tts.synthesizeToFile(mTxt.getText().toString(), null,
                        new File("/mnt/sdcard/sound.wav"), "record");
                Toast.makeText(Demo080400Activity.this, "声音记录成功！"
                        , Toast.LENGTH_SHORT).show();
                break;
        }
    }
}