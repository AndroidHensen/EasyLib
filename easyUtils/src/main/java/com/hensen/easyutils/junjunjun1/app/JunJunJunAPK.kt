package com.hensen.easyutils.junjunjun1.app

import android.app.Application
import com.hensen.easyutils.junjunjun1.SPUtil
import com.hensen.easyutils.junjunjun1.StringUtil
import com.hensen.easyutils.junjunjun1.ToastUtils

/**
 * @Desc:
 * @Author: xuyingjun
 * @Date: 2021/11/19.
 * @Email: xuyingjun@yy.com
 */
public class JunJunJunAPK : Application() {

    override fun onCreate() {
        super.onCreate()

        SPUtil.init(this)
        ToastUtils.init(this)
        StringUtil.init(this)
    }
}