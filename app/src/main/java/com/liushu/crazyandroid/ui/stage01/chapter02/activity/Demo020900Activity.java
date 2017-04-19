package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.liushu.crazyandroid.R;
import com.jaydenxiao.common.commonutils.ToastUitl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Demo020900Activity extends AppCompatActivity {
    @Bind(R.id.ll020900_test0)
    LinearLayout mLl020900Test0;
    @Bind(R.id.ll020900_test1)
    LinearLayout mLl020900Test1;
    @Bind(R.id.ll020900_test2)
    LinearLayout mLl020900Test2;
    @Bind(R.id.ll020900_test3)
    LinearLayout mLl020900Test3;
    @Bind(R.id.ll020900_test4)
    LinearLayout mLl020900Test4;
    @Bind(R.id.ll020900_test5)
    LinearLayout mLl020900Test5;
    @Bind(R.id.btn_show_message)
    Button mBtnShowMessage;
    @Bind(R.id.btn_simple_list)
    Button mBtnSimpleList;
    @Bind(R.id.btn_onechioce_list)
    Button mBtnOnechioceList;
    @Bind(R.id.btn_morechioce_list)
    Button mBtnMorechioceList;
    @Bind(R.id.btn_custom_list)
    Button mBtnCustomList;
    @Bind(R.id.btn_custom_view)
    Button mBtnCustomView;
    private int mGroupPosition;
    private int mChildPosition;
    private String[] mStrings = {"111", "222", "334", "442134", "666"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo020900);
        ButterKnife.bind(this);
        mGroupPosition = getIntent().getIntExtra("groupPosition", -1);
        mChildPosition = getIntent().getIntExtra("childPosition", -1);
        initView(mChildPosition);
    }

    private void initView(int childPosition) {
        switch (childPosition) {
            case 0:
                mLl020900Test0.setVisibility(View.VISIBLE);
                initData0();
                break;
            case 1:
                mLl020900Test1.setVisibility(View.VISIBLE);
                initData1();
                break;
            case 2:
                mLl020900Test2.setVisibility(View.VISIBLE);
                initData2();
                break;
            case 3:
                mLl020900Test3.setVisibility(View.VISIBLE);
                initData3();
                break;
            case 4:
                mLl020900Test4.setVisibility(View.VISIBLE);
                initData4();
                break;
            case 5:
                mLl020900Test5.setVisibility(View.VISIBLE);
                initData5();
                break;
        }


    }

    private void initData0() {
    }

    private void initData1() {
    }

    private void initData2() {
    }

    private void initData3() {
    }

    private void initData4() {
    }

    private void initData5() {
    }

    @OnClick({R.id.btn_show_message, R.id.btn_simple_list, R.id.btn_onechioce_list, R.id.btn_morechioce_list, R.id.btn_custom_list, R.id.btn_custom_view})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_message:
                showDialog0();
                break;
            case R.id.btn_simple_list:
                showDialog1();
                break;
            case R.id.btn_onechioce_list:
                showDialog2();
                break;
            case R.id.btn_morechioce_list:
                showDialog3();
                break;
            case R.id.btn_custom_list:
                showDialog4();
                break;
            case R.id.btn_custom_view:
                showDialog5();
                break;
        }
    }

    private void showDialog0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("显示提示消息的对话框");
        builder.setMessage("显示消息的内容\n这是第二行");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();

    }

    private void showDialog1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("简单列表项对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(mStrings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("你选择了：" + mStrings[which]);
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();


    }

    private void showDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("单选列表项对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(mStrings, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("你选择了：" + mStrings[which]);
            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();
    }

    private void showDialog3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("多选列表项对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(mStrings, new boolean[]{true, true, true, true, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        });

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();
    }

    private void showDialog4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义列表项对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setAdapter(new ArrayAdapter<String>(this, R.layout.array_item, mStrings), null);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了确定按钮");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();
    }

    private void showDialog5() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义列表项对话框");
        builder.setIcon(R.mipmap.ic_launcher);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_demo020205, null);
        builder.setView(view);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUitl.showShort("点击了取消按钮");
            }
        });
        builder.create().show();
    }
}
