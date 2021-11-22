package com.hensen.easyutils.junjunjun1;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {

    private Context context;
    private static ToastUtils instance;//单例模式 双重检查锁定

    public static void init(Context context) {
        if (instance == null) {
            instance = new ToastUtils(context);
        }
    }

    public static ToastUtils getInstance() {
        return instance;
    }

    public ToastUtils(Context context) {
        this.context = context;
    }

    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

