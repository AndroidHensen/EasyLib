package com.hensen.easyutils.junjunjun1.data

import com.hensen.easyutils.junjunjun1.SPUtil
import java.util.*

object Fruit {
    var data: ArrayList<String> = ArrayList()

    init {
        data.add("苹果")
        data.add("凤梨")
        data.add("梨")
        data.add("香蕉")
        data.add("葡萄")
        data.add("黑加仑")
        data.add("葡萄")
        data.add("桃子")
        data.add("橙子")
        data.add("樱桃")
        data.add("西瓜")
        data.add("蓝莓")
        data.add("蔓越莓")
        data.add("草莓")
        data.add("枸杞")
        data.add("葡萄柚")
        data.add("火龙果")
        data.add("菠萝蜜")
        data.add("奇异果")
        data.add("杨桃")
        data.add("柠檬")
        data.add("青柠")
        data.add("榴莲")
        data.add("荔枝")
        data.add("芒果")
        data.add("牛油果")
        data.add("椰子")
        data.add("哈密瓜")
        data.add("橄榄")
        data.add("木瓜")
        data.add("山竹")
    }

    fun save(data: MutableList<String>) {
        SPUtil.getInstance().putList("Fruit", data)
    }

    fun get(): MutableList<String>? {
        return SPUtil.getInstance().getList<String>("Fruit")
    }
}