package com.sprout.ui.login

import android.content.Intent
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sprout.MainActivity
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.databinding.ActivityLogBinding
import com.sprout.ui.main.login.RegisterActivity
import com.sprout.utils.MyMmkv
import com.sprout.viewmodel.login.LogViewModel
import kotlinx.android.synthetic.main.activity_log.*

class LogActivity : BaseActivity<LogViewModel,ActivityLogBinding>(R.layout.activity_log,LogViewModel::class.java) {
    override fun initView() {
        img_pw.setOnClickListener(View.OnClickListener {
            if (img_pw.getTag() == 1) {
                //为1能看到
                img_pw.setImageResource(R.mipmap.ic_pw_open)
                img_pw.setTag(2)
                input_pw.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            } else {
                img_pw.setImageResource(R.mipmap.ic_pw_close)
                img_pw.setTag(1)
                input_pw.setTransformationMethod(PasswordTransformationMethod.getInstance())
            }
        })
    }

    override fun initVM() {
        mViewModel.info.observe(this, Observer {
            val token = it.token
            val uid = it.userInfo.uid
            if(!TextUtils.isEmpty(token)){
                MyMmkv.setValue("token",token)
                MyMmkv.setValue("uid",uid)
                intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun initData() {
        btn_login.setOnClickListener(View.OnClickListener {
//            val username = MyMmkv.getString("username")
//            if(TextUtils.isEmpty(username)){
//                ToastUtil.showToast(this, "还没注册，请先注册")
//            }else{
//                login()
//            }
            login()
        })

        btn_regi.setOnClickListener(View.OnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent,200)
        })
    }

    private fun login() {
        val pw = input_pw.text.toString()
        val name = input_username.text.toString()
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pw)){
            if(pw.length >= 8){
                mViewModel.login(name,pw)
            }else{
                Toast.makeText(this, "密码不少于8位", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "账号密码不为空", Toast.LENGTH_SHORT).show()
        }
    }

    override fun initVariable() {

    }
}