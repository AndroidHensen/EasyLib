package com.hensen.easyutils.junjunjun1;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

/**
 * @Desc:
 * @Author: xuyingjun
 * @Date: 2021/9/4.
 * @Email: xuyingjun@yy.com
 */
public class DialogUtil {

    public static void showSingleDialog(Context context, String title, String msg, String positive,
                                        DialogInterface.OnClickListener listener) {
        createSingleDialog(context, title, msg, positive, listener).show();
    }

    public static void showDoubleDialog(Context context, String title, String msg, String positive,
                                        String negative, DialogInterface.OnClickListener listener,
                                        DialogInterface.OnClickListener listener2) {

        createDoubleDialog(context, title, msg, positive, negative, listener, listener2).show();
    }

    private static AlertDialog createSingleDialog(Context context, String title, String msg, String positive,
                                                  DialogInterface.OnClickListener listener) {

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(positive, listener)
                .create();
        return dialog;
    }

    private static AlertDialog createDoubleDialog(Context context, String title, String msg, String positive,
                                                  String negative, DialogInterface.OnClickListener listener,
                                                  DialogInterface.OnClickListener listener2) {

        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(positive, listener)
                .setNegativeButton(negative, listener2)
                .create();
        return dialog;
    }
}
