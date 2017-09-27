package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.utils.NotificationsUtils;
import com.liushu.crazyandroid.widget.SimpleShowDialog;

import butterknife.Bind;
import butterknife.OnClick;

public class Demo020807Activity extends BaseActivity {
    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.btn_send)
    Button mBtnSend;
    @Bind(R.id.btn_delete)
    Button mBtnDelete;
    private NotificationManager nm;
    private static final int NOTIFICATION_ID = 0x123;

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020807;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitle.setText("加薪通知");
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @OnClick({R.id.iv_back, R.id.btn_send, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_send:
                if (!NotificationsUtils.isNotificationEnabled(mContext)) {
                    initMessageNotify();
                } else {
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
                            .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS)
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
            case R.id.btn_delete:
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", getPackageName());
            intent.putExtra("app_uid", getApplicationInfo().uid);
            startActivity(intent);
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
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
