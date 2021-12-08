package com.hensen.easyutils.junjunjun1.app

import android.app.Application
import android.util.Log
import com.hensen.easyutils.junjunjun1.SPUtil
import com.hensen.easyutils.junjunjun1.StringUtil
import com.hensen.easyutils.junjunjun1.ToastUtils

var app: Application? = null

public class JunJunJunAPK : Application() {

    override fun onCreate() {
        super.onCreate()

        Log.i("JunJunJunAPK", "init")
        app = this
        SPUtil.init(this)
        ToastUtils.init(this)
        StringUtil.init(this)
    }
}