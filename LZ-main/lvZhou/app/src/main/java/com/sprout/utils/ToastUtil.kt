package com.sprout.utils

import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import com.sprout.viewmodel.login.RegisterVieweModel

object ToastUtil {
    fun showToast(context: Context?, message: String?) {
        if (!TextUtils.isEmpty(message)) Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }
}