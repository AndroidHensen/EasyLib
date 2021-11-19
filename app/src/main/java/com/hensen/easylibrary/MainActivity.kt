package com.hensen.easylibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hensen.easyutils.junjunjun1.ToastUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ToastUtils.getInstance().showToast("Hello")
    }
}