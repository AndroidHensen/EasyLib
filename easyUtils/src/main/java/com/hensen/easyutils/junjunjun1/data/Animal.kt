package com.hensen.easyutils.junjunjun1.data

import com.hensen.easyutils.junjunjun1.SPUtil
import java.util.*

object Animal {
    var data: ArrayList<String> = ArrayList()

    init {
        data.add("公鸡")
        data.add("金鱼")
        data.add("山羊")
        data.add("小毛驴")
        data.add("马")
        data.add("小猪")
        data.add("小狗")
        data.add("小猫")
        data.add("小鸭子")
    }

    fun save(data: MutableList<String>) {
        SPUtil.getInstance().putList("Animal", data)
    }

    fun get(): MutableList<String>? {
        return SPUtil.getInstance().getList<String>("Animal")
    }
}