package com.hensen.easylibrary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.hensen.easyutils.junjunjun1.BubbleUtils
import com.hensen.easyutils.junjunjun1.DialogUtil


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
            down?.let { view ->
                DialogUtil.showDoubleDialog(activity, "AAA", "BBB", "确定", "取消", null, null)
            }
        }

        up?.setOnClickListener {
            up?.let { view ->
                BubbleUtils.showUp(view, "AAA")
            }
        }
    }

}