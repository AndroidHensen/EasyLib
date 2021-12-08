package com.hensen.easyutils.junjunjun1.widget;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

import androidx.core.text.TextUtilsCompat;
import androidx.core.view.ViewCompat;

import java.util.Locale;

import static com.hensen.easyutils.junjunjun1.app.JunJunJunAPKKt.getApp;

public class RtlUtil {
    private static Boolean isSupportsRtl;

    private static boolean isSupportsRtl() {
        if (isSupportsRtl != null) {
            return isSupportsRtl;
        }
        try {
            PackageInfo info = getApp().getPackageManager()
                    .getPackageInfo(getApp().getPackageName(), 0);
            if ((info.applicationInfo.flags & ApplicationInfo.FLAG_SUPPORTS_RTL) != 0) {
                isSupportsRtl = true;
            } else {
                isSupportsRtl = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isSupportsRtl = false;
        }
        return isSupportsRtl;
    }

    public static boolean isRtl() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(
                Locale.getDefault()) == ViewCompat.LAYOUT_DIRECTION_RTL && isSupportsRtl();
    }

    /**
     * 当且仅当在文本中找到阿拉伯语unicode代码点时，它才将文本声明为阿拉伯语。您可以增强此逻辑以更适合您的需求。
     * <p>
     * 范围0600 - 06E0是阿拉伯字符和符号的代码点范围
     *
     * @param s 需要判断的字符串
     * @return 该字符串是否含有阿拉伯语
     */
    public static boolean isProbablyArabic(String s) {
        int i = 0;
        while (i < s.length()) {
            int c = s.codePointAt(i);
            if (c >= 0x0600 && c <= 0x06E0) {
                return true;
            }
            i += Character.charCount(c);
        }
        return false;
    }
}
