package com.sprout.ui.login

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.Observer
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.databinding.ActivityLogBinding
import com.sprout.utils.MyMmkv
import com.sprout.viewmodel.login.LogViewModel

class LogActivity : BaseActivity<LogViewModel,ActivityLogBinding>(R.layout.activity_log,LogViewModel::class.java) {
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.info.observe(this, Observer {
            val token = it.token
            val uid = it.userInfo.uid
            if(!TextUtils.isEmpty(token)){
                MyMmkv.setValue("token",token)
                MyMmkv.setValue("uid",uid)
                Log.e("111", "initVM1: "+uid )

            }
        })
    }

    override fun initData() {
        mViewModel.login("yun","12345678")
    }

    override fun initVariable() {

    }
}