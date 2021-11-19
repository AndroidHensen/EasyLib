package com.hensen.easyutils.junjunjun1;

import android.content.Context;

/**
 * @Desc:
 * @Author: xuyingjun
 * @Date: 2021/10/16.
 * @Email: xuyingjun@yy.com
 */
public class StringUtil {

    private Context context;
    private static StringUtil instance;//单例模式 双重检查锁定

    public static void init(Context context) {
        if (instance == null) {
            instance = new StringUtil(context);
        }
    }

    public static StringUtil getInstance() {
        return instance;
    }

    public StringUtil(Context context) {
        this.context = context;
    }

    public String getString(int id) {
        return context.getResources().getString(id);
    }
}
