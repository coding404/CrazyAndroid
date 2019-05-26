package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.widget.OneChioceDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class Demo020901Activity extends BaseActivity {
    @BindView(R.id.ll020900_test0)
    LinearLayout mLl020900Test0;
    @BindView(R.id.ll020900_test1)
    LinearLayout mLl020900Test1;
    @BindView(R.id.ll020900_test2)
    LinearLayout mLl020900Test2;
    @BindView(R.id.ll020900_test3)
    LinearLayout mLl020900Test3;
    @BindView(R.id.ll020900_test4)
    LinearLayout mLl020900Test4;
    @BindView(R.id.ll020900_test5)
    LinearLayout mLl020900Test5;
    @BindView(R.id.btn_show_message)
    Button mBtnShowMessage;
    @BindView(R.id.btn_simple_list)
    Button mBtnSimpleList;
    @BindView(R.id.btn_onechioce_list)
    Button mBtnOnechioceList;
    @BindView(R.id.btn_morechioce_list)
    Button mBtnMorechioceList;
    @BindView(R.id.btn_custom_list)
    Button mBtnCustomList;
    @BindView(R.id.btn_custom_view)
    Button mBtnCustomView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.btn_onechioce_self)
    Button mBtnOnechioceSelf;
    @BindView(R.id.activity_demo020900)
    LinearLayout mActivityDemo020900;

    private String[] mStrings = {"111", "222", "334", "442134", "666"};

    @OnClick({R.id.btn_show_message, R.id.btn_simple_list,
            R.id.btn_onechioce_list, R.id.btn_onechioce_self,
            R.id.btn_morechioce_list, R.id.btn_custom_list,
            R.id.btn_custom_view, R.id.iv_back})
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
            case R.id.btn_onechioce_self:
                showDialog6();
                break;
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void showDialog6() {

        final OneChioceDialog.Builder builder = new OneChioceDialog.Builder(Demo020901Activity.this);
        builder.setTitle("需要填写的标题");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("这是第" + i + "条");
        }
        builder.setList(list);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String contact = builder.getContact();
                ToastUitl.showShort(contact);
            }
        });
        builder.create().show();
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020901;
    }

    @Override
    public void initView() {
        mTvTitle.setText("Dialog的使用方法");
    }
}
