package com.hensen.easyutils.junjunjun1

import android.view.View
import me.kareluo.ui.OptionMenu
import me.kareluo.ui.OptionMenuView
import me.kareluo.ui.PopupMenuView
import me.kareluo.ui.PopupView
import java.util.*

object BubbleUtils {
    fun showUp(view: View, title: String) {
        val menuView = PopupMenuView(view.context)
        menuView.setMenuItems(
            Arrays.asList(
                OptionMenu(title)
            )
        );
        menuView.setSites(PopupView.SITE_TOP)
        menuView.setOnMenuClickListener(object : OptionMenuView.OnOptionMenuClickListener {
            override fun onOptionMenuClick(position: Int, menu: OptionMenu): Boolean {
                return true
            }
        })
        menuView.show(view)
    }

    fun showBottom(view: View, title: String) {
        val menuView = PopupMenuView(view.context)
        menuView.setMenuItems(
            Arrays.asList(
                OptionMenu(title)
            )
        );
        menuView.setSites(PopupView.SITE_BOTTOM)
        menuView.setOnMenuClickListener(object : OptionMenuView.OnOptionMenuClickListener {
            override fun onOptionMenuClick(position: Int, menu: OptionMenu): Boolean {
                return true
            }
        })
        menuView.show(view)
    }
}