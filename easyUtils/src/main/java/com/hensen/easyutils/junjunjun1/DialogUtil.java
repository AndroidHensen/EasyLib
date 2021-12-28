package com.hensen.easyutils.junjunjun1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class DialogUtil {

    public static View showCustomDialog(Context context, int resId) {
        View view = LayoutInflater.from(context).inflate(resId, null, false);
        final AlertDialog dialog = new AlertDialog.Builder(context).setView(view).create();
        dialog.show();
        return view;
    }

    public static ProgressDialog showLoadingDialog(Context context, String title) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage(title);
        dialog.show();
        return dialog;
    }

    public static void showSingleDialog(Context context, String title, String msg, String positive,
                                        DialogInterface.OnClickListener listener) {
        AlertDialog dialog = createSingleDialog(context, title, msg, positive, listener);
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
    }

    public static void showDoubleDialog(Context context, String title, String msg, String positive,
                                        String negative, DialogInterface.OnClickListener listener,
                                        DialogInterface.OnClickListener listener2) {
        AlertDialog dialog = createDoubleDialog(context, title, msg, positive, negative, listener, listener2);
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.GRAY);
    }

    private static AlertDialog createSingleDialog(Context context, String title, String msg, String positive,
                                                  DialogInterface.OnClickListener listener) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(positive, listener)
                .create();
    }

    private static AlertDialog createDoubleDialog(Context context, String title, String msg, String positive,
                                                  String negative, DialogInterface.OnClickListener listener,
                                                  DialogInterface.OnClickListener listener2) {

        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(positive, listener)
                .setNegativeButton(negative, listener2)
                .create();
    }

}
