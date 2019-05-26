package com.liushu.crazyandroid.ui.stage01.chapter08.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class Demo080200Activity extends BaseActivity {
    MyDatabaseHelper dbHelper;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title_name)
    TextView mTvTitleName;
    @BindView(R.id.word)
    EditText mWord;
    @BindView(R.id.detail)
    EditText mDetail;
    @BindView(R.id.insert)
    Button mInsert;
    @BindView(R.id.key)
    EditText mKey;
    @BindView(R.id.search)
    Button mSearch;
    @BindView(R.id.show)
    ListView mShow;

    protected ArrayList<Map<String, String>>
    converCursorToList(Cursor cursor) {
        ArrayList<Map<String, String>> result =
                new ArrayList<Map<String, String>>();
        // 遍历Cursor结果集
        while (cursor.moveToNext()) {
            // 将结果集中的数据存入ArrayList中
            Map<String, String> map = new HashMap<>();
            // 取出查询记录中第2列、第3列的值
            map.put("word", cursor.getString(1));
            map.put("detail", cursor.getString(2));
            result.add(map);
        }
        return result;
    }

    private void insertData(SQLiteDatabase db, String word
            , String detail) {
        // 执行插入语句
        db.execSQL("insert into dict values(null , ? , ?)"
                , new String[]{word, detail});
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo080200;
    }

    @Override
    public void initView() {
        mTvTitleName.setText("英文生词本");
        // 创建MyDatabaseHelper对象，指定数据库版本为1，此处使用相对路径即可
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下
        dbHelper = new MyDatabaseHelper(this, "myDict.db3", 1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    @OnClick({R.id.iv_back, R.id.insert, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.insert:
                // 获取用户输入
                String word = mWord.getText().toString();
                String detail = mDetail.getText().toString();
                // 插入生词记录
                insertData(dbHelper.getReadableDatabase(), word, detail);
                // 显示提示信息
                Toast.makeText(Demo080200Activity.this, "添加生词成功！"
                        , Toast.LENGTH_LONG).show();
                break;
            case R.id.search:
                // 获取用户输入
                String key = mKey.getText().toString();
                // 执行查询
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                        "select * from dict where word like ? or detail like ?",
                        new String[]{"%" + key + "%", "%" + key + "%"});
                // 创建一个Bundle对象
                Bundle data = new Bundle();
                data.putSerializable("data", converCursorToList(cursor));
                // 创建一个Intent
                Intent intent = new Intent(Demo080200Activity.this, DbResultActivity.class);
                intent.putExtras(data);
                // 启动Activity
                startActivity(intent);
                break;
        }
    }
}
