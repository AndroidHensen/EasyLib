package com.hensen.easyutils.junjunjun1.data

import com.hensen.easyutils.junjunjun1.SPUtil
import java.util.*

object Fruit {
    var fruits: ArrayList<String> = ArrayList()

    init {
        fruits.add("苹果")
        fruits.add("凤梨")
        fruits.add("梨")
        fruits.add("香蕉")
        fruits.add("葡萄")
        fruits.add("黑加仑")
        fruits.add("葡萄")
        fruits.add("桃子")
        fruits.add("橙子")
        fruits.add("樱桃")
        fruits.add("西瓜")
        fruits.add("蓝莓")
        fruits.add("蔓越莓")
        fruits.add("草莓")
        fruits.add("枸杞")
        fruits.add("葡萄柚")
        fruits.add("火龙果")
        fruits.add("菠萝蜜")
        fruits.add("奇异果")
        fruits.add("杨桃")
        fruits.add("柠檬")
        fruits.add("青柠")
        fruits.add("榴莲")
        fruits.add("荔枝")
        fruits.add("芒果")
        fruits.add("牛油果")
        fruits.add("椰子")
        fruits.add("哈密瓜")
        fruits.add("橄榄")
        fruits.add("木瓜")
        fruits.add("山竹")
    }

    fun save(fruit: MutableList<String>) {
        SPUtil.getInstance().putList("fruits", fruit)
    }

    fun get(): MutableList<String>? {
        return SPUtil.getInstance().getList<String>("fruits")
    }
}