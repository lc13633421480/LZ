package com.sprout.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import com.sprout.MainActivity
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.databinding.ActivitySplashBinding
import com.sprout.login.LoginActivity
import com.sprout.utils.SpUtils

import com.sprout.viewmodel.SplashViewModel
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.layout_guidance_pop.view.*

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>(R.layout.activity_splash,SplashViewModel::class.java){

    private var popupWindow: PopupWindow? = null
    private var guidance:String? = null

    override fun initView() {

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
        if(hasFocus == true){
            guidance = SpUtils.instance!!.getString("guidance")
            if(!TextUtils.isEmpty(guidance)){
                //进入首页
                initHome()
            }else{
                initPw()
                Log.e("111", "createWindowContext: " )
            }
        }

    }
    //首页
    private fun initHome() {
        Handler().postDelayed({
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }

    //登录
    private fun initRegister() {
        Handler().postDelayed({
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }


    override fun initData() {

    }

    override fun initVM() {

    }

    private fun initPw() {
        val popupView: View = LayoutInflater.from(this)
            .inflate(R.layout.layout_guidance_pop, null)
        //设置popu
        popupWindow = PopupWindow(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //开启阴影
        val attributes = window.attributes
        attributes.alpha = 0.5f
        window.attributes = attributes
        //找到视图
        popupWindow!!.contentView = popupView
        popupWindow!!.isClippingEnabled = false

        initText(popupView)

        //点击不同意 返回上一页面 退出应用
        popupView.btn_guidance_no.setOnClickListener(View.OnClickListener {
            popupWindow!!.dismiss()//关闭弹窗
            initPwNo()
            finishAndRemoveTask()
        })


        //点击同意 进入下一界面 登录
        popupView.btn_guidance_ok.setOnClickListener() {
            popupWindow!!.dismiss()//关闭弹窗
            initPwNo()
            initRegister()
            val ok = "已经进入过引导页"
            SpUtils.instance!!.setValue("guidance", ok)
        }

        //在按钮的下方弹出  无偏移 第一种方式
        popupWindow!!.showAtLocation(bk_guidance, Gravity.CENTER, 0, 0) //开启弹窗

    }

    private fun initText(popupView: View) {
        //富文本
        val spannableString =
            SpannableString("3、你可阅读《用户协议》《隐私条款》了解详细信息，如你[同意]，可点击同意开始接受我们的服务。");
        //起始位置
        var startPos = spannableString.indexOf("《")
        //结束位置
        var endPos = spannableString.lastIndexOf("》") + 1
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#80A55F")),
            startPos, endPos, Spanned.SPAN_EXCLUSIVE_INCLUSIVE
        )
        //下划线
        val underlineSpan = UnderlineSpan()
        spannableString.setSpan(underlineSpan, 6, 18, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        //赋值
        popupView.tv_guidance_one.text = "1、为了你的使用体验,缓存图片和视频,降低流量消耗,我们会申请存储权限,同时,为了账号安全,防止被盗,我们会申请系统权限手机设备信息,其他敏感权限如摄像头、麦克风、位置，仅会在使用相关功能时经过明示授权才会开启。"
        popupView.tv_guidance_two.text = "2、绿洲采取严格的数据安全措施保护您的个人信息安全，未经您的同意，我们不会自第三方获取、共享或对外提供你的个人信息，您也可以随时更正或删除您的个人信息。"
        popupView.tv_guidance_three.text = spannableString
    }

    //关闭阴影
    private fun initPwNo() {
        //关闭阴影
        val attributes = window.attributes
        attributes.alpha = 1f
        window.attributes = attributes
    }

    override fun onDestroy() {
        super.onDestroy()
        if(popupWindow != null && popupWindow!!.isShowing){
            popupWindow!!.dismiss()
            popupWindow = null
        }
    }

    override fun initVariable() {

    }
}