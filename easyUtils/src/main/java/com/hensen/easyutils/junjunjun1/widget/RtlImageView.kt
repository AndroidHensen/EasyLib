package com.hensen.easyutils.junjunjun1.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * 处理图片镜像问题
 */
class RtlImageView(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    override fun onFinishInflate() {
        super.onFinishInflate()
        if (RtlUtil.isRtl()) {
            rotation = 180f
        }
    }
}