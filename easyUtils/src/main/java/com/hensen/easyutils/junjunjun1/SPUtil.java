package com.hensen.easyutils.junjunjun1;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @Desc:
 * @Author: xuyingjun
 * @Date: 2021/9/4.
 * @Email: xuyingjun@yy.com
 */
public class SPUtil {

    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;

    private static SPUtil instance;//单例模式 双重检查锁定

    public static void init(Context context) {
        if (instance == null) {
            instance = new SPUtil(context);
        }
    }

    public static SPUtil getInstance() {
        return instance;
    }

    public SPUtil(Context context) {
        mSp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        mEditor = mSp.edit();
    }
    /*--------------- 读 ---------------*/

    /**
     * 读取字符信息
     *
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    /**
     * 读取整型
     */
    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    /**
     * 读取布尔型
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }
    /*--------------- 写 ---------------*/

    /**
     * 写入string
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    /**
     * 写入int
     *
     * @param key
     * @param value
     */
    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    /**
     * 写入boolean
     *
     * @param key
     * @param value
     */
    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }
}