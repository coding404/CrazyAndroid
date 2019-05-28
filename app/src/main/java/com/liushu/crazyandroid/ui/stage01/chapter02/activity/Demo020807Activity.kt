package com.liushu.crazyandroid.ui.stage01.chapter02.activity

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.provider.Settings
import android.view.View
import android.widget.AdapterView
import android.widget.RemoteViews
import butterknife.OnClick
import com.jaydenxiao.common.base.BaseActivity
import com.jaydenxiao.common.commonutils.NotifyUtil
import com.liushu.crazyandroid.R
import com.liushu.crazyandroid.bean.NotifyBean
import com.liushu.crazyandroid.ui.stage01.chapter02.adapter.NotifyAdapter
import com.liushu.crazyandroid.widget.SimpleShowDialog
import kotlinx.android.synthetic.main.activity_demo020807.*
import kotlinx.android.synthetic.main.include_simple_title.*
import java.util.*

class Demo020807Activity : BaseActivity() {

    private var nm: NotificationManager? = null

    private var mDataList: ArrayList<NotifyBean>? = null
    private var mAdapter: NotifyAdapter? = null
    private var currentNotify: NotifyUtil? = null
    private val requestCode = SystemClock.uptimeMillis().toInt()

    override val layoutId: Int
        get() = R.layout.activity_demo020807

    override fun initView() {
        tv_title!!.text = "消息通知工具类"
        nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        initDatas()
        mAdapter = NotifyAdapter(mContext, mDataList)
        lv_notify!!.adapter = mAdapter
        lv_notify!!.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                if (!NotifyUtil.isNotificationEnabled(mContext)) {
                    initMessageNotify()
                } else {
                    when (position) {
                        0 -> notify_normal_singLine()
                        1 -> notify_normal_moreLine()
                        2 -> notify_mailbox()
                        3 -> notify_bigPic()
                        4 -> notify_customview()
                        5 -> notify_buttom()
                        6 -> notify_progress()
                        7 -> notify_headUp()
                        8 -> if (currentNotify != null) {
                            currentNotify!!.clear()
                        }
                    }
                }
            }
        })
    }

    @OnClick(R.id.iv_back, R.id.btn_send, R.id.btn_delete)
    fun onViewClicked(view: View) {
        when (view.id) {
            R.id.iv_back -> finish()
            R.id.btn_send -> if (!NotifyUtil.isNotificationEnabled(mContext)) {
                initMessageNotify()
            } else {
                // 创建一个启动其他Activity的Intent
                val intent = Intent(this, OtherActivity::class.java)
                val pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
                val notify = Notification.Builder(this)
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
                        .setDefaults(Notification.DEFAULT_SOUND or Notification.DEFAULT_LIGHTS)
                        // 设置通知的自定义声音
                        .setSound(Uri.parse("android.resource://org.crazyit.ui/" + R.raw.msg))
                        .setWhen(System.currentTimeMillis())
                        // 设改通知将要启动程序的Intent
                        .setContentIntent(pi)
                        .build()
                // 发送通知
                nm!!.notify(NOTIFICATION_ID, notify)
            }
            R.id.btn_delete -> nm!!.cancel(NOTIFICATION_ID)
        }
    }

    private fun initDatas() {
        mDataList = ArrayList()
        val notifybean1 = NotifyBean()
        notifybean1.imageId = R.drawable.tb_bigicon
        notifybean1.titleId = R.string.title1
        notifybean1.typeId = R.string.type1
        mDataList!!.add(notifybean1)
        val notifybean2 = NotifyBean()
        notifybean2.imageId = R.drawable.netease_bigicon
        notifybean2.titleId = R.string.title2
        notifybean2.typeId = R.string.type2
        mDataList!!.add(notifybean2)
        val notifybean3 = NotifyBean()
        notifybean3.imageId = R.drawable.weixin
        notifybean3.titleId = R.string.title3
        notifybean3.typeId = R.string.type3
        mDataList!!.add(notifybean3)
        val notifybean4 = NotifyBean()
        notifybean4.imageId = R.drawable.xc_smaillicon
        notifybean4.titleId = R.string.title4
        notifybean4.typeId = R.string.type4
        mDataList!!.add(notifybean4)
        val notifybean5 = NotifyBean()
        notifybean5.imageId = R.drawable.yybao_smaillicon
        notifybean5.titleId = R.string.title5
        notifybean5.typeId = R.string.type5
        mDataList!!.add(notifybean5)
        val notifybean6 = NotifyBean()
        notifybean6.imageId = R.drawable.android_bigicon
        notifybean6.titleId = R.string.title6
        notifybean6.typeId = R.string.type6
        mDataList!!.add(notifybean6)
        val notifybean7 = NotifyBean()
        notifybean7.imageId = R.drawable.android_bigicon
        notifybean7.titleId = R.string.title7
        notifybean7.typeId = R.string.type7
        mDataList!!.add(notifybean7)
        val notifybean8 = NotifyBean()
        notifybean8.imageId = R.drawable.hl_smallicon
        notifybean8.titleId = R.string.title8
        notifybean8.typeId = R.string.type8
        mDataList!!.add(notifybean8)
        val notifybean9 = NotifyBean()
        notifybean9.imageId = R.drawable.ic_launcher
        notifybean9.titleId = R.string.title9
        notifybean9.typeId = R.string.title9
        mDataList!!.add(notifybean9)

    }

    /**
     * 高仿淘宝
     */
    private fun notify_normal_singLine() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val smallIcon = R.drawable.tb_bigicon
        val ticker = "您有一条新通知"
        val title = "双十一大优惠！！！"
        val content = "仿真皮肤充气娃娃，女朋友带回家！"

        //实例化工具类，并且调用接口
        val notify1 = NotifyUtil(mContext, 1)
        notify1.notify_normal_singline(pIntent, smallIcon, ticker, title, content, true, true, false)
        currentNotify = notify1
    }

    /**
     * 高仿网易新闻
     */
    private fun notify_normal_moreLine() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val smallIcon = R.drawable.netease_bigicon
        val ticker = "您有一条新通知"
        val title = "朱立伦请辞国民党主席 副主席黄敏惠暂代党主席"
        val content = "据台湾“中央社”报道，国民党主席朱立伦今天(18日)向中常会报告，为败选请辞党主席一职，他感谢各位中常委的指教包容，也宣布未来党务工作由副主席黄敏惠暂代，完成未来所有补选工作。"
        //实例化工具类，并且调用接口
        val notify2 = NotifyUtil(mContext, 2)
        notify2.notify_normail_moreline(pIntent, smallIcon, ticker, title, content, true, true, false)
        currentNotify = notify2
    }

    /**
     * 收件箱样式
     */
    private fun notify_mailbox() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val largeIcon = R.drawable.fbb_largeicon
        val smallIcon = R.drawable.wx_smallicon
        val ticker = "您有一条新通知"
        val title = "冰冰"
        val messageList = ArrayList<String>()
        messageList.add("文明,今晚有空吗？")
        messageList.add("晚上跟我一起去玩吧?")
        messageList.add("怎么不回复我？？我生气了！！")
        messageList.add("我真生气了！！！！！你听见了吗!")
        messageList.add("文明，别不理我！！！")
        val content = "[" + messageList.size + "条]" + title + ": " + messageList[0]
        //实例化工具类，并且调用接口
        val notify3 = NotifyUtil(mContext, 3)
        notify3.notify_mailbox(pIntent, smallIcon, largeIcon, messageList, ticker,
                title, content, true, true, false)
        currentNotify = notify3
    }

    /**
     * 高仿系统截图通知
     */
    private fun notify_bigPic() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val smallIcon = R.drawable.xc_smaillicon
        val largePic = R.drawable.screenshot
        val ticker = "您有一条新通知"
        val title = "已经抓取屏幕截图"
        val content = "触摸可查看您的屏幕截图"
        //实例化工具类，并且调用接口
        val notify4 = NotifyUtil(mContext, 4)
        notify4.notify_bigPic(pIntent, smallIcon, ticker, title, content, largePic, true, true, false)
        currentNotify = notify4
    }


    /**
     * 高仿应用宝
     */
    private fun notify_customview() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val ticker = "您有一条新通知"

        //设置自定义布局中按钮的跳转界面
        val btnIntent = Intent(mContext, OtherActivity::class.java)
        btnIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        //如果是启动activity，那么就用PendingIntent.getActivity，如果是启动服务，那么是getService
        val Pintent = PendingIntent.getActivity(mContext,
                SystemClock.uptimeMillis().toInt(), btnIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        // 自定义布局
        val remoteViews = RemoteViews(mContext.packageName,
                R.layout.yyb_notification)
        remoteViews.setImageViewResource(R.id.image, R.drawable.yybao_bigicon)
        remoteViews.setTextViewText(R.id.title, "垃圾安装包太多")
        remoteViews.setTextViewText(R.id.text, "3个无用安装包，清理释放的空间")
        remoteViews.setOnClickPendingIntent(R.id.button, Pintent)//定义按钮点击后的动作
        val smallIcon = R.drawable.yybao_smaillicon
        //实例化工具类，并且调用接口
        val notify5 = NotifyUtil(mContext, 5)
        notify5.notify_customview(remoteViews, pIntent, smallIcon, ticker, true, true, false)
        currentNotify = notify5
    }

    /**
     * 高仿Android更新提醒样式
     */
    private fun notify_buttom() {
        //设置想要展示的数据内容
        val ticker = "您有一条新通知"
        val smallIcon = R.drawable.android_bigicon
        val lefticon = R.drawable.android_leftbutton
        val lefttext = "以后再说"
        val leftIntent = Intent()
        leftIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val leftPendIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val righticon = R.drawable.android_rightbutton
        val righttext = "安装"
        val rightIntent = Intent(mContext, OtherActivity::class.java)
        rightIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        //实例化工具类，并且调用接口
        val notify6 = NotifyUtil(mContext, 6)
        notify6.notify_button(smallIcon, lefticon, lefttext, leftPendIntent, righticon, righttext, rightPendIntent, ticker, "系统更新已下载完毕", "Android 6.0.1", true, true, false)
        currentNotify = notify6
    }


    /**
     * 高仿Android系统下载样式
     */
    private fun notify_progress() {
        //设置想要展示的数据内容
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val rightPendIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val smallIcon = R.drawable.android_bigicon
        val ticker = "您有一条新通知"
        //实例化工具类，并且调用接口
        val notify7 = NotifyUtil(mContext, 7)
        notify7.notify_progress(rightPendIntent, smallIcon, ticker, "Android 6.0.1 下载", "正在下载中", true, false, false)
        currentNotify = notify7
    }

    /**
     * Android 5。0 新特性：悬浮式通知
     */
    private fun notify_headUp() {
        //设置想要展示的数据内容
        val smallIcon = R.drawable.hl_smallicon
        val largeIcon = R.drawable.fbb_largeicon
        val ticker = "您有一条新通知"
        val title = "范冰冰"
        val content = "文明，今晚在希尔顿酒店2016号房哈"
        val intent = Intent(mContext, OtherActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val pendingIntent = PendingIntent.getActivity(mContext,
                requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT)


        val lefticon = R.drawable.hl_message
        val lefttext = "回复"
        val leftIntent = Intent()
        leftIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val leftPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, leftIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val righticon = R.drawable.hl_call
        val righttext = "拨打"
        val rightIntent = Intent(mContext, OtherActivity::class.java)
        rightIntent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
        val rightPendingIntent = PendingIntent.getActivity(mContext,
                requestCode, rightIntent, PendingIntent.FLAG_UPDATE_CURRENT)
        //实例化工具类，并且调用接口
        val notify8 = NotifyUtil(mContext, 8)
        notify8.notify_HeadUp(pendingIntent, smallIcon, largeIcon, ticker, title, content, lefticon, lefttext, leftPendingIntent, righticon, righttext, rightPendingIntent, true, true, false)
        currentNotify = notify8
    }

    private fun initMessageNotify() {
        val builder = SimpleShowDialog.Builder(mContext)
        builder.setStringOrder("您暂未开通消息通知的权限\n请前往设置")
        builder.setPositiveButton("下次再说") { dialog, which -> dialog.dismiss() }
        builder.setNegativeButton("去设置") { dialog, which ->
            dialog.dismiss()
            requestPermission()
        }
        builder.create().show()
    }

    protected fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val intent = Intent()
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", packageName)
            intent.putExtra("app_uid", applicationInfo.uid)
            startActivity(intent)
        } else if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            val intent = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.data = Uri.parse("package:$packageName")
            startActivity(intent)
        } else {
            val intent = Intent(Settings.ACTION_SETTINGS)
            startActivity(intent)
        }
    }

    companion object {
        private val NOTIFICATION_ID = 0x123
    }
}
