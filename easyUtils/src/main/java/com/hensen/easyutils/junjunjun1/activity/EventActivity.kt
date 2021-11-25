package com.hensen.easyutils.junjunjun1.activity

import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus


abstract class EventActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}