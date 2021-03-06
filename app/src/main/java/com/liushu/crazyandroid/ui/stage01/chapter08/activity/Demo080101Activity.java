package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;

public class Demo080101Activity extends BaseActivity {
    // 记录当前的父文件夹
    File currentParent;
    // 记录当前路径下的所有文件的文件数组
    File[] currentFiles;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.path)
    TextView mPath;
    @BindView(R.id.list)
    ListView mList;
    @BindView(R.id.parent)
    Button mParent;

    public void inflateListView(File[] files)  // ①
    {
        // 创建一个List集合，List集合的元素是Map
        List<Map<String, Object>> listItems =
                new ArrayList<Map<String, Object>>();
        for (int i = 0; i < files.length; i++) {
            Map<String, Object> listItem =
                    new HashMap<String, Object>();
            // 如果当前File是文件夹，使用folder图标；否则使用file图标
            if (files[i].isDirectory()) {
                listItem.put("icon", R.drawable.folder);
            } else {
                listItem.put("icon", R.drawable.file);
            }
            listItem.put("fileName", files[i].getName());
            // 添加List项
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , listItems, R.layout.line
                , new String[]{"icon", "fileName"}
                , new int[]{R.id.icon, R.id.file_name});
        // 为ListView设置Adapter
        mList.setAdapter(simpleAdapter);
        try {
            mPath.setText("当前路径为："
                    + currentParent.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080101;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("SD卡文件浏览器");
        // 获取系统的SD卡的目录
        File root = new File("/mnt/sdcard/");
        // 如果 SD卡存在
        if (root.exists()) {
            currentParent = root;
            currentFiles = root.listFiles();
            // 使用当前目录下的全部文件、文件夹来填充ListView
            inflateListView(currentFiles);
        }
        // 为ListView的列表项的单击事件绑定监听器
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 用户单击了文件，直接返回，不做任何处理
                if (currentFiles[position].isFile()) return;
                // 获取用户点击的文件夹下的所有文件
                File[] tmp = currentFiles[position].listFiles();
                if (tmp == null || tmp.length == 0) {
                    Toast.makeText(Demo080101Activity.this
                            , "当前路径不可访问或该路径下没有文件",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // 获取用户单击的列表项对应的文件夹，设为当前的父文件夹
                    currentParent = currentFiles[position]; // ②
                    // 保存当前的父文件夹内的全部文件和文件夹
                    currentFiles = tmp;
                    // 再次更新ListView
                    inflateListView(currentFiles);
                }
            }
        });

    }

    @OnClick({R.id.iv_back, R.id.parent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.parent:
                try {
                    if (!currentParent.getCanonicalPath()
                            .equals("/mnt/sdcard")) {
                        // 获取上一级目录
                        currentParent = currentParent.getParentFile();
                        // 列出当前目录下所有文件
                        currentFiles = currentParent.listFiles();
                        // 再次更新ListView
                        inflateListView(currentFiles);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
