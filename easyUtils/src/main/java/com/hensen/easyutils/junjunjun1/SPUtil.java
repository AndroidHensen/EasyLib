package com.hensen.easyutils.junjunjun1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SPUtil {

    private SharedPreferences mSp;
    private SharedPreferences.Editor mEditor;

    private static SPUtil instance;//单例模式 双重检查锁定

    public static void init(Context context) {
        if (instance == null) {
            MMKV.initialize(context);
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

    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getString(String key) {
        return getString(key, "");
    }

    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    public void putLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    public long getLong(String key, long defValue) {
        return mSp.getLong(key, defValue);
    }

    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    public <T extends Serializable> void putObject(String key, T obj) {
        if (obj == null) {
            putString(key, "");
            return;
        }
        putString(key, obj2Base64(obj));
    }

    public <T extends Serializable> T getObject(String key) {
        return base64ToObj(getString(key));
    }

    public void putList(String key, List<? extends Serializable> list) {
        putString(key, obj2Base64(list));
    }

    public <E extends Serializable> List<E> getList(String key) {
        return (List<E>) base64ToObj(getString(key));
    }

    public boolean putMMKVList(String key, List<? extends Serializable> list) {
        MMKV kv = MMKV.defaultMMKV();
        if (list == null || list.size() == 0) { //清空
            kv.putInt(key + "size", 0);
            int size = kv.getInt(key + "size", 0);
            for (int i = 0; i < size; i++) {
                if (kv.getString(key + i, null) != null) {
                    kv.remove(key + i);
                }
            }
        } else {
            kv.putInt(key + "size", list.size());
            for (int i = 0; i < list.size(); i++) {
                kv.remove(key + i);
                kv.putString(key + i, new Gson().toJson(list.get(i)));
            }
        }
        return kv.commit();
    }

    public <E extends Serializable> List<E> getMMKVList(String key, E bean) {
        MMKV kv = MMKV.defaultMMKV();
        ArrayList<E> list = new ArrayList<E>();
        int size = kv.getInt(key + "size", 0);
        for (int i = 0; i < size; i++) {
            if (kv.getString(key + i, null) != null) {
                try {
                    list.add((E) new Gson().fromJson(kv.getString(key + i, null), bean.getClass()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public <K extends Serializable, V> void putMap(String key, Map<K, V> map) {
        putString(key, obj2Base64(map));
    }

    public <K extends Serializable, V> Map<K, V> getMap(String key) {
        return (Map<K, V>) base64ToObj(getString(key));
    }

    private String obj2Base64(Object obj) {
        //判断对象是否为空
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        String objectStr = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            // 将对象放到OutputStream中
            // 将对象转换成byte数组，并将其进行base64编码
            objectStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return objectStr;
    }

    private <T> T base64ToObj(String base64) {
        // 将base64格式字符串还原成byte数组
        if (TextUtils.isEmpty(base64)) {
            return null;
        }
        byte[] objBytes = Base64.decode(base64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        T t = null;
        try {
            bais = new ByteArrayInputStream(objBytes);
            ois = new ObjectInputStream(bais);
            t = (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bais != null) {
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }

    public void removeByKey(String key) {
        mEditor.remove(key);
        mEditor.apply();
    }
}