package com.hensen.easylibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import me.kareluo.ui.OptionMenu
import me.kareluo.ui.OptionMenuView.OnOptionMenuClickListener
import me.kareluo.ui.PopupMenuView
import me.kareluo.ui.PopupView
import java.util.*


class AFragment : Fragment() {

    var down: Button? = null
    var up: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        down = view.findViewById(R.id.down)
        up = view.findViewById(R.id.up)

        down?.setOnClickListener {
            val menuView = PopupMenuView(activity)
            menuView.setMenuItems(
                Arrays.asList(
                    OptionMenu("AAAAA")
                )
            );
            menuView.setSites(PopupView.SITE_BOTTOM);
            menuView.setOnMenuClickListener(object : OnOptionMenuClickListener {
                override fun onOptionMenuClick(position: Int, menu: OptionMenu): Boolean {
                    Toast.makeText(activity, menu.title, Toast.LENGTH_SHORT).show()
                    return true
                }
            })
            menuView.show(down)
        }
        up?.setOnClickListener {
            val menuView = PopupMenuView(activity)
            menuView.setMenuItems(
                Arrays.asList(
                    OptionMenu("AAAAA")
                )
            );
            menuView.setSites(PopupView.SITE_TOP);
            menuView.setOnMenuClickListener(object : OnOptionMenuClickListener {
                override fun onOptionMenuClick(position: Int, menu: OptionMenu): Boolean {
                    Toast.makeText(activity, menu.title, Toast.LENGTH_SHORT).show()
                    return true
                }
            })
            menuView.show(up)
        }
    }

}