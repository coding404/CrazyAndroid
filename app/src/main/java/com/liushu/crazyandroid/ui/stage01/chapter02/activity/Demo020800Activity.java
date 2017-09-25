package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.utils.NotificationsUtils;
import com.liushu.crazyandroid.widget.SimpleShowDialog;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020800Activity extends BaseActivity {

    @Bind(R.id.btn_test0_simple)
    Button mBtnTest0Simple;
    @Bind(R.id.btn_test0_image)
    Button mBtnTest0Image;
    @Bind(R.id.ll_demo020800_test0)
    LinearLayout mLlDemo020800Test0;
    @Bind(R.id.calend_view)
    CalendarView mCalendView;
    @Bind(R.id.ll_demo020800_test1)
    LinearLayout mLlDemo020800Test1;
    @Bind(R.id.date_picker)
    DatePicker mDatePicker;
    @Bind(R.id.time_picker)
    TimePicker mTimePicker;
    @Bind(R.id.et_test03)
    EditText mEtTest03;
    @Bind(R.id.ll_demo020800_test2)
    LinearLayout mLlDemo020800Test2;
    @Bind(R.id.number_pick_low)
    NumberPicker mNumberPickLow;
    @Bind(R.id.number_pick_high)
    NumberPicker mNumberPickHigh;
    @Bind(R.id.ll_demo020800_test3)
    LinearLayout mLlDemo020800Test3;
    @Bind(R.id.sv)
    SearchView mSv;
    @Bind(R.id.lv_test5)
    ListView mLvTest5;
    @Bind(R.id.ll_demo020800_test4)
    LinearLayout mLlDemo020800Test4;
    @Bind(android.R.id.tabs)
    TabWidget mTabs;
    @Bind(R.id.tab01)
    LinearLayout mTab01;
    @Bind(R.id.tab02)
    LinearLayout mTab02;
    @Bind(R.id.tab03)
    LinearLayout mTab03;
    @Bind(android.R.id.tabcontent)
    FrameLayout mTabcontent;
    @Bind(android.R.id.tabhost)
    TabHost mTabhost;
    @Bind(R.id.ll_demo020800_test5)
    LinearLayout mLlDemo020800Test5;
    @Bind(R.id.ll_demo020800_test6)
    LinearLayout mLlDemo020800Test6;
    @Bind(R.id.btn_test8_send)
    Button mBtnTest8Send;
    @Bind(R.id.btn_test8_receive)
    Button mBtnTest8Receive;
    @Bind(R.id.ll_demo020800_test7)
    LinearLayout mLlDemo020800Test7;
    private int mGroupPosition;
    private int mChildPosition;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private int minPrice = 25;
    private int maxPrice = 75;
    private static final int NOTIFICATION_ID = 0x123;
    private NotificationManager nm;
    private String[] mStrings = {"aaaa", "bbbbbbbbb", "ccccccc"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020800;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mGroupPosition = getIntent().getIntExtra("groupPosition", -1);
        mChildPosition = getIntent().getIntExtra("childPosition", -1);
        initView(mChildPosition);
    }

    private void initView(int childPosition) {
        switch (childPosition) {
            case 0:
                mLlDemo020800Test0.setVisibility(View.VISIBLE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData0();
                break;
            case 1:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.VISIBLE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData1();
                break;
            case 2:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.VISIBLE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData2();
                break;
            case 3:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.VISIBLE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData3();
                break;
            case 4:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.VISIBLE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData4();
                break;
            case 5:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.VISIBLE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData5();
                break;
            case 6:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.VISIBLE);
                mLlDemo020800Test7.setVisibility(View.GONE);
                initData6();
                break;
            case 7:
                mLlDemo020800Test0.setVisibility(View.GONE);
                mLlDemo020800Test1.setVisibility(View.GONE);
                mLlDemo020800Test2.setVisibility(View.GONE);
                mLlDemo020800Test3.setVisibility(View.GONE);
                mLlDemo020800Test4.setVisibility(View.GONE);
                mLlDemo020800Test5.setVisibility(View.GONE);
                mLlDemo020800Test6.setVisibility(View.GONE);
                mLlDemo020800Test7.setVisibility(View.VISIBLE);
                initData7();
                break;
            default:
                break;
        }

    }

    private void initData7() {
        nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
    }

    private void initData6() {

    }

    private void initData5() {

        ToastUitl.showShort("没有完成，需要TabActivity");
      /*  TabHost tabHost = getTabHost();
        // 创建第一个Tab页
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator("已接电话") // 设置标题
                .setContent(R.id.tab01); //设置内容
        // 添加第一个标签页
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2")
                // 在标签标题上放置图标
                .setIndicator("呼出电话", getResources()
                        .getDrawable(R.drawable.ic_launcher))
                .setContent(R.id.tab02);
        // 添加第二个标签页
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3")
                .setIndicator("未接电话")
                .setContent(R.id.tab03);
        // 添加第三个标签页
        tabHost.addTab(tab3);
*/

    }

    private void initData4() {
        mLvTest5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings));
        mLvTest5.setTextFilterEnabled(true);
        mSv.setIconifiedByDefault(false);
        mSv.setSubmitButtonEnabled(true);
        mSv.setQueryHint("查找");
        mSv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (TextUtils.isEmpty(query)) {
                    mLvTest5.clearTextFilter();
                } else {
                    mLvTest5.setFilterText(query);
                }

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ToastUitl.showShort("您选择的是：" + newText);
                return false;
            }
        });

    }

    private void initData3() {
        mNumberPickLow.setMinValue(10);
        mNumberPickLow.setMaxValue(50);
        mNumberPickLow.setValue(minPrice);
        mNumberPickHigh.setMinValue(60);
        mNumberPickHigh.setMaxValue(100);
        mNumberPickHigh.setValue(maxPrice);
        mNumberPickLow.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice = newVal;
                showSelectPrice();
            }
        });
        mNumberPickHigh.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice = newVal;
                showSelectPrice();
            }
        });


    }

    private void showSelectPrice() {
        ToastUitl.showShort("您选择的最低价格为：" + minPrice + '\n' + "最高价格为：" + maxPrice);
    }

    private void initData2() {
        Calendar instance = Calendar.getInstance();
        mYear = instance.get(Calendar.YEAR);
        mMonth = instance.get(Calendar.MONTH);
        mDay = instance.get(Calendar.DAY_OF_MONTH);
        mHour = instance.get(Calendar.AM_PM);
        mMinute = instance.get(Calendar.MINUTE);
        mDatePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                showDate(mYear, mMonth, mDay, mHour, mMinute);
            }
        });
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                showDate(mYear, mMonth, mDay, mHour, mMinute);
            }
        });
    }

    private void showDate(int year, int month, int day, int hour, int minute) {
        mEtTest03.setText("您的购买日期为：" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分");
    }

    private void initData1() {
        mCalendView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                ToastUitl.showShort("您的生日是：" + year + "年" + month + "月" + dayOfMonth + "日");
            }
        });

    }

    private void initData0() {
        mLlDemo020800Test0.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.btn_test0_simple, R.id.btn_test0_image, R.id.btn_test8_send, R.id.btn_test8_receive})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_test0_simple:
                Toast.makeText(Demo020800Activity.this, "简单的提示", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_test0_image:
                Toast toast = new Toast(this);
                //   toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                LinearLayout layout = new LinearLayout(this);
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);
                layout.addView(imageView);
                TextView textView = new TextView(this);
                textView.setText("带图片的提示");
                textView.setTextColor(Color.BLUE);
                textView.setTextSize(24);
                layout.addView(textView);
                toast.setView(layout);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.btn_test8_send:
                if (!NotificationsUtils.isNotificationEnabled(mContext)) {
                    initMessageNotify();
                }else {
                    // 创建一个启动其他Activity的Intent
                    Intent intent = new Intent(this, OtherActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                    Notification notify = new Notification.Builder(this)
                            // 设置打开该通知，该通知自动消失
                            .setAutoCancel(true)
                            // 设置显示在状态栏的通知提示信息
                            .setTicker("有新消息")
                            // 设置通知的图标
                            .setSmallIcon(R.drawable.notify)
                            // 设置通知内容的标题
                            .setContentTitle("一条新通知")
                            // 设置通知内容
                            .setContentText("恭喜你，您加薪了，工资增加20%!")
                            // 设置使用系统默认的声音、默认LED灯
                            .setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_LIGHTS)
                            // 设置通知的自定义声音
                            .setSound(Uri.parse("android.resource://org.crazyit.ui/"
                                    + R.raw.msg))
                            .setWhen(System.currentTimeMillis())
                            // 设改通知将要启动程序的Intent
                            .setContentIntent(pi)  // ①
                            .build();
                    // 发送通知
                    nm.notify(NOTIFICATION_ID, notify);
                }
                break;
            case R.id.btn_test8_receive:
// 取消通知
                nm.cancel(NOTIFICATION_ID);

                break;
        }
    }

    private void initMessageNotify() {
        SimpleShowDialog.Builder builder = new SimpleShowDialog.Builder(mContext);
        builder.setStringOrder("您暂未开通物泊消息通知的权限\n请前往设置");
        builder.setPositiveButton("下次再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("去设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                requestPermission();
            }
        });
        builder.create().show();
    }

    protected void requestPermission() {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", getPackageName());
            intent.putExtra("app_uid", getApplicationInfo().uid);
            startActivity(intent);
        } else if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } else {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        }
    }
}
