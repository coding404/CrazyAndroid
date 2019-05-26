package com.jaydenxiao.common.commonutils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/**
 * des:权限对话框管理
 * Created by xsf
 * on 2016.06.10:21
 */
public class DialogPermissionUtil {

    public static void PermissionDialog(final Activity activity, String content){
        Dialog deleteDialog = new AlertDialog.Builder(activity)
                .setTitle("提示")
                .setMessage(content)
                .setPositiveButton("去设置",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                startSettingIntent(activity);
                            }
                        }).create();
        deleteDialog.show();
    }

    /**
     * 启动app设置授权界面
     * @param context
     */
    public static void startSettingIntent(Context context) {
        Intent localIntent = new Intent();
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package", context.getPackageName(),null));
        context.startActivity(localIntent);
    }
}
