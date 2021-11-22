package com.hensen.easyutils.junjunjun1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

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

    public <T> void putList(String key, List<T> datalist) {
        if (null == datalist || datalist.size() <= 0)
            return;

        Gson gson = new Gson();
        String strJson = gson.toJson(datalist);
        mEditor.putString(key, strJson);
        mEditor.commit();
    }

    public <T> List<T> getList(String key) {
        List<T> datalist = new ArrayList<T>();
        String strJson = getString(key, null);
        if (null == strJson) {
            return datalist;
        }
        Gson gson = new Gson();
        datalist = gson.fromJson(strJson, new TypeToken<List<T>>() {
        }.getType());
        return datalist;
    }

    public <T> T getObject(Class<T> clazz) {
        String key = clazz.getName();
        String json = getString(key, null);
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            Gson gson = new Gson();
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public void putObject(Object object) {
        String key = object.getClass().getName();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        putString(key, json);
    }

    public void removeObject(Class<?> clazz) {
        mEditor.remove(clazz.getName());
        mEditor.commit();
    }

    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }
}