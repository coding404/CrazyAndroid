package com.liushu.crazyandroid.ui.stage01.chapter02.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.TextView;

import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonutils.NotifyUtil;
import com.liushu.crazyandroid.R;
import com.liushu.crazyandroid.bean.NotifyBean;
import com.liushu.crazyandroid.ui.stage01.chapter02.adapter.NotifyAdapter;
import com.liushu.crazyandroid.widget.SimpleShowDialog;

import java.util.ArrayList;

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
    @Bind(R.id.lv_notify)
    ListView mLvNotify;
    private NotificationManager nm;
    private static final int NOTIFICATION_ID = 0x123;

    private ArrayList<NotifyBean> mDataList;
    private NotifyAdapter mAdapter;
    private NotifyUtil currentNotify;
    private int requestCode = (int) SystemClock.uptimeMillis();

    @Override
    public int getLayoutId() {
        return R.layout.activity_demo020807;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mTvTitle.setText("消息通知工具类");
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        initDatas();
        mAdapter = new NotifyAdapter(mContext, mDataList);
        mLvNotify.setAdapter(mAdapter);
        mLvNotify.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (!NotifyUtil.isNotificationEnabled(mContext)) {
                    initMessageNotify();
                } else {
                    switch (position) {
                        case 0:
                            notify_normal_singLine();
                            break;
                        case 1:
                            notify_normal_moreLine();
                            break;
                        case 2:
                            notify_mailbox();
                            break;
                        case 3:
                            notify_bigPic();
                            break;
                        case 4:
                            notify_customview();
                            break;
                        case 5:
                            notify_buttom();
                            break;
                        case 6:
                            notify_progress();
                            break;
                        case 7:
                            notify_headUp();
                            break;
                        case 8:
                            if (currentNotify != null) {
                                currentNotify.clear();
                            }
                            break;
                    }
                }
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn_send, R.id.btn_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_send:
                if (!NotifyUtil.isNotificationEnabled(mContext)) {
                    initMessageNotify();
                } else {
                    // 创建一个启动其他Activity的Intent
                    Intent intent = new Intent(this, OtherActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
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
                            .setContentIntent(pi)
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

    private void initDatas() {
        mDataList = new ArrayList<>();
        NotifyBean notifybean1 = new NotifyBean();
        notifybean1.setImageId(R.drawable.tb_bigicon);
        notifybean1.setTitleId(R.string.title1);
        notifybean1.setTypeId(R.string.type1);
        mDataList.add(notifybean1);
        NotifyBean notifybean2 = new NotifyBean();
        notifybean2.setImageId(R.drawable.netease_bigicon);
        notifybean2.setTitleId(R.string.title2);
        notifybean2.setTypeId(R.string.type2);
        mDataList.add(notifybean2);
        NotifyBean notifybean3 = new NotifyBean();
        notifybean3.setImageId(R.drawable.weixin);
        notifybean3.setTitleId(R.string.title3);
        notifybean3.setTypeId(R.string.type3);
        mDataList.add(notifybean3);
        NotifyBean notifybean4 = new NotifyBean();
        notifybean4.setImageId(R.drawable.xc_smaillicon);
        notifybean4.setTitleId(R.string.title4);
        notifybean4.setTypeId(R.string.type4);
        mDataList.add(notifybean4);
        NotifyBean notifybean5 = new NotifyBean();
        notifybean5.setImageId(R.drawable.yybao_smaillicon);
        notifybean5.setTitleId(R.string.title5);
        notifybean5.setTypeId(R.string.type5);
        mDataList.add(notifybean5);
        NotifyBean notifybean6 = new NotifyBean();
        notifybean6.setImageId(R.drawable.android_bigicon);
        notifybean6.setTitleId(R.string.title6);
        notifybean6.setTypeId(R.string.type6);
        mDataList.add(notifybean6);
        NotifyBean notifybean7 = new NotifyBean();
        notifybean7.setImageId(R.drawable.android_bigicon);
        notifybean7.setTitleId(R.string.title7);
        notifybean7.setTypeId(R.string.type7);
        mDataList.add(notifybean7);
        NotifyBean notifybean8 = new NotifyBean();
        notifybean8.setImageId(R.drawable.hl_smallicon);
        notifybean8.setTitleId(R.string.title8);
        notifybean8.setTypeId(R.string.type8);
        mDataList.add(notifybean8);
        NotifyBean notifybean9 = new NotifyBean();
        notifybean9.setImageId(R.drawable.ic_launcher);
        notifybean9.setTitleId(R.string.title9);
        notifybean9.setTypeId(R.string.title9);
        mDataList.add(notifybean9);

    }

    /**
     * 高仿淘宝
     */
    private void notify_normal_singLine() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.tb_bigicon;
        String ticker = "您有一条新通知";
        String title = "双十一大优惠！！！";
        String content = "仿真皮肤充气娃娃，女朋友带回家！";

        //实例化工具类，并且调用接口
        NotifyUtil notify1 = new NotifyUtil(mContext, 1);
        notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, false);
        currentNotify = notify1;
    }

    /**
     * 高仿网易新闻
     */
    private void notify_normal_moreLine() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.netease_bigicon;
        String ticker = "您有一条新通知";
        String title = "朱立伦请辞国民党主席 副主席黄敏惠暂代党主席";
        String content = "据台湾“中央社”报道，国民党主席朱立伦今天(18日)向中常会报告，为败选请辞党主席一职，他感谢各位中常委的指教包容，也宣布未来党务工作由副主席黄敏惠暂代，完成未来所有补选工作。";
        //实例化工具类，并且调用接口
        NotifyUtil notify2 = new NotifyUtil(mContext, 2);
        notify2.notify_normail_moreline(pIntent, smallIcon, ticker, title, content, true, true, false);
        currentNotify = notify2;
    }

    /**
     * 收件箱样式
     */
    private void notify_mailbox() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int largeIcon = R.drawable.fbb_largeicon;
        int smallIcon = R.drawable.wx_smallicon;
        String ticker = "您有一条新通知";
        String title = "冰冰";
        ArrayList<String> messageList = new ArrayList<String>();
        messageList.add("文明,今晚有空吗？");
        messageList.add("晚上跟我一起去玩吧?");
        messageList.add("怎么不回复我？？我生气了！！");
        messageList.add("我真生气了！！！！！你听见了吗!");
        messageList.add("文明，别不理我！！！");
        String content = "[" + messageList.size() + "条]" + title + ": " + messageList.get(0);
        //实例化工具类，并且调用接口
        NotifyUtil notify3 = new NotifyUtil(mContext, 3);
        notify3.notify_mailbox(pIntent, smallIcon, largeIcon, messageList, ticker,
                title, content, true, true, false);
        currentNotify = notify3;
    }

    /**
     * 高仿系统截图通知
     */
    private void notify_bigPic() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.xc_smaillicon;
        int largePic = R.drawable.screenshot;
        String ticker = "您有一条新通知";
        String title = "已经抓取屏幕截图";
        String content = "触摸可查看您的屏幕截图";
        //实例化工具类，并且调用接口
        NotifyUtil notify4 = new NotifyUtil(mContext, 4);
        notify4.notify_bigPic(pIntent, smallIcon, ticker, title, content, largePic, true, true, false);
        currentNotify = notify4;
    }


    /**
     * 高仿应用宝
     */
    private void notify_customview() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        String ticker = "您有一条新通知";

        //设置自定义布局中按钮的跳转界面
        Intent btnIntent = new Intent(mContext, OtherActivity.class);
        btnIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //如果是启动activity，那么就用PendingIntent.getActivity，如果是启动服务，那么是getService
        PendingIntent Pintent = PendingIntent.getActivity(mContext,
                (int) SystemClock.uptimeMillis(), btnIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 自定义布局
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(),
                R.layout.yyb_notification);
        remoteViews.setImageViewResource(R.id.image, R.drawable.yybao_bigicon);
        remoteViews.setTextViewText(R.id.title, "垃圾安装包太多");
        remoteViews.setTextViewText(R.id.text, "3个无用安装包，清理释放的空间");
        remoteViews.setOnClickPendingIntent(R.id.button, Pintent);//定义按钮点击后的动作
        int smallIcon = R.drawable.yybao_smaillicon;
        //实例化工具类，并且调用接口
        NotifyUtil notify5 = new NotifyUtil(mContext, 5);
        notify5.notify_customview(remoteViews, pIntent, smallIcon, ticker, true, true, false);
        currentNotify = notify5;
    }

    /**
     * 高仿Android更新提醒样式
     */
    private void notify_buttom() {
        //设置想要展示的数据内容
        String ticker = "您有一条新通知";
        int smallIcon = R.drawable.android_bigicon;
        int lefticon = R.drawable.android_leftbutton;
        String lefttext = "以后再说";
        Intent leftIntent = new Intent();
        leftIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent leftPendIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        int righticon = R.drawable.android_rightbutton;
        String righttext = "安装";
        Intent rightIntent = new Intent(mContext, OtherActivity.class);
        rightIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //实例化工具类，并且调用接口
        NotifyUtil notify6 = new NotifyUtil(mContext, 6);
        notify6.notify_button(smallIcon, lefticon, lefttext, leftPendIntent, righticon, righttext, rightPendIntent, ticker, "系统更新已下载完毕", "Android 6.0.1", true, true, false);
        currentNotify = notify6;
    }


    /**
     * 高仿Android系统下载样式
     */
    private void notify_progress() {
        //设置想要展示的数据内容
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        int smallIcon = R.drawable.android_bigicon;
        String ticker = "您有一条新通知";
        //实例化工具类，并且调用接口
        NotifyUtil notify7 = new NotifyUtil(mContext, 7);
        notify7.notify_progress(rightPendIntent, smallIcon, ticker, "Android 6.0.1 下载", "正在下载中", true, false, false);
        currentNotify = notify7;
    }

    /**
     * Android 5。0 新特性：悬浮式通知
     */
    private void notify_headUp() {
        //设置想要展示的数据内容
        int smallIcon = R.drawable.hl_smallicon;
        int largeIcon = R.drawable.fbb_largeicon;
        String ticker = "您有一条新通知";
        String title = "范冰冰";
        String content = "文明，今晚在希尔顿酒店2016号房哈";
        Intent intent = new Intent(mContext, OtherActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);


        int lefticon = R.drawable.hl_message;
        String lefttext = "回复";
        Intent leftIntent = new Intent();
        leftIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent leftPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        int righticon = R.drawable.hl_call;
        String righttext = "拨打";
        Intent rightIntent = new Intent(mContext, OtherActivity.class);
        rightIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent rightPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //实例化工具类，并且调用接口
        NotifyUtil notify8 = new NotifyUtil(mContext, 8);
        notify8.notify_HeadUp(pendingIntent, smallIcon, largeIcon, ticker, title, content, lefticon, lefttext, leftPendingIntent, righticon, righttext, rightPendingIntent, true, true, false);
        currentNotify = notify8;
    }

    private void initMessageNotify() {
        SimpleShowDialog.Builder builder = new SimpleShowDialog.Builder(mContext);
        builder.setStringOrder("您暂未开通消息通知的权限\n请前往设置");
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
