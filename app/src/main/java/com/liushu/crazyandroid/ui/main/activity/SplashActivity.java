package com.liushu.crazyandroid.ui.main.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.adapter.TextTagsAdapter;
import com.liushu.crazyandroid.adapter.VectorTagsAdapter;
import com.liushu.crazyandroid.adapter.ViewTagsAdapter;
import com.moxun.tagcloudlib.view.TagCloudView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tag_cloud)
    TagCloudView mTagCloud;
    @BindView(R.id.tag_text)
    Button mTagText;
    @BindView(R.id.tag_view)
    Button mTagView;
    @BindView(R.id.tag_vector)
    Button mTagVector;

    private TextTagsAdapter textTagsAdapter;
    private ViewTagsAdapter viewTagsAdapter;
    private VectorTagsAdapter vectorTagsAdapter;

    private List<String> mStrings;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mStrings = new ArrayList<>();
        for (int i = 1; i < 17; i++) {
            mStrings.add("第" + i + "章");
        }
        textTagsAdapter = new TextTagsAdapter(mStrings);
        textTagsAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTag() instanceof Integer) {
                    int position = (int) v.getTag();
                    Intent intent = new Intent(mContext, MainActivity.class);
                    intent.putExtra("position", position);
                    startActivity(intent);
                    finish();
                }
            }
        });
        viewTagsAdapter = new ViewTagsAdapter();
        vectorTagsAdapter = new VectorTagsAdapter();

        mTagCloud.setAdapter(textTagsAdapter);
    }

    @OnClick({R.id.tag_text, R.id.tag_view, R.id.tag_vector})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tag_text:
                mTagCloud.setAdapter(textTagsAdapter);
                break;
            case R.id.tag_view:
                mTagCloud.setAdapter(viewTagsAdapter);
                break;
            case R.id.tag_vector:
                mTagCloud.setAdapter(vectorTagsAdapter);
                break;
        }
    }
}
