package com.hensen.easyutils.junjunjun1.logic;

import com.hensen.easyutils.junjunjun1.SPUtil

object SP {

    fun putUserName(username: String) {
        SPUtil.getInstance()
            .putString("username", username)
    }

    fun getUserName(): String {
        return SPUtil.getInstance()
            .getString("username", "")
    }

    fun putPassword(password: String) {
        SPUtil.getInstance()
            .putString("password", password)
    }

    fun getPassword(): String {
        return SPUtil.getInstance()
            .getString("password", "")
    }
}