package com.hensen.easylibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hensen.easyutils.junjunjun1.ToastUtils
import com.hensen.easyutils.junjunjun1.activity.HomeActivity

public class MainActivity : HomeActivity() {
    override fun getFragment(): List<Fragment> {
        val l = mutableListOf<Fragment>()
        l.add(Fragment())
        l.add(Fragment())
        l.add(Fragment())
        return l
    }

    override fun getIcon(): List<Int> {
        val l = mutableListOf<Int>()
        l.add(R.drawable.icon_tab_home)
        l.add(R.drawable.icon_tab_send)
        l.add(R.drawable.icon_tab_me)
        return l
    }

    override fun getTitlee(): List<String> {
        val l = mutableListOf<String>()
        l.add("你")
        l.add("我")
        l.add("他")
        return l
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ToastUtils.getInstance().showToast("Hello")
    }
}