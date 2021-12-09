package com.hensen.easyutils.junjunjun1.logic

import android.content.res.Resources

fun dp2px(dpValue: Float): Int {
    return (0.5f + dpValue * Resources.getSystem().getDisplayMetrics().density).toInt()
}