package com.hensen.easyutils.junjunjun1.data

import com.hensen.easyutils.junjunjun1.SPUtil
import java.util.*

object Sport {
    var data: ArrayList<String> = ArrayList()

    init {
        data.add("拳击")
        data.add("壁球")
        data.add("自由泳")
        data.add("足球")
        data.add("橄榄球")
        data.add("网球")
        data.add("篮球")
    }

    fun save(data: MutableList<String>) {
        SPUtil.getInstance().putList("Sport", data)
    }

    fun get(): MutableList<String>? {
        return SPUtil.getInstance().getList<String>("Sport")
    }
}