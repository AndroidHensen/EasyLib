package com.hensen.easyutils.junjunjun1.activity

import androidx.fragment.app.Fragment
import org.greenrobot.eventbus.EventBus


abstract class EventFragment : Fragment() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}