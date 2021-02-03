package com.sprout.ui.main.login

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.amap.api.location.AMapLocation
import com.amap.api.location.AMapLocationClient
import com.amap.api.location.AMapLocationClientOption
import com.amap.api.location.AMapLocationListener
import com.sprout.R
import com.sprout.base.BaseActivity
import com.sprout.databinding.ActivityRegisterBinding
import com.sprout.ui.login.LogActivity
import com.sprout.utils.MyMmkv
import com.sprout.utils.ToastUtil
import com.sprout.viewmodel.login.RegisterVieweModel
import kotlin.math.log

class RegisterActivity : BaseActivity<RegisterVieweModel,ActivityRegisterBinding>
    (R.layout.activity_register,RegisterVieweModel::class.java),
    AMapLocationListener {

    lateinit var mLocationClient: AMapLocationClient
    lateinit var mLocationOption: AMapLocationClientOption
    lateinit var username: String
    lateinit var userPsw: String
    override fun initView() {
        //点击注册
        mDataBinding.meRegistBtnRegist.setOnClickListener(View.OnClickListener {
            loginBtnCommit()
        })
    }

    override fun initData() {
//初始化 定位
//        location()
    }



    override fun initVM() {
        //加载数据
        mViewModel.registerMessage.observe(this, Observer {
            if (it.userInfo == null) {
                ToastUtil.showToast(this, "用户名已注册")
            } else {
                ToastUtil.showToast(this, "注册成功！请登录")
                MyMmkv.setValue("username",username)
                intent = Intent(this,LogActivity::class.java)
//                intent.putExtra("name",username)
//                intent.putExtra("pw",userPsw)
                setResult(300,intent)
                finish()
            }
        })
    }



        // 注册和登录接口的提交
        fun loginBtnCommit() {
            username = mDataBinding.meRegistInputUsername.text.toString()
            userPsw = mDataBinding.meRegistInputPw.text.toString()
            when {
                username.isEmpty() -> ToastUtil.showToast(this, "请填写账号")
                userPsw.isEmpty() -> ToastUtil.showToast(this, "请填写密码")
                else -> {
                    location()//注册
                }
            }
        }

    override fun initVariable() {

    }

    @SuppressLint("HardwareIds")
    override fun onLocationChanged(p0: AMapLocation) {
        val lat = p0.latitude //获取纬度
        val lon = p0.longitude //获取经度

        /**
         * AndroidId
         */
        val m_szAndroidID: String = Settings.Secure.getString(
            this.contentResolver,
            Settings.Secure.ANDROID_ID
        )

        mViewModel.register(
            username,
            userPsw,
            imei = m_szAndroidID,
            lat = lat.toString(),
            lng = lon.toString()
        )
        Log.e("111", "ok")
    }


    /*开启定位*/
    private fun location() {
        //初始化定位
        mLocationClient =
            AMapLocationClient(this)
        //设置定位回调监听
        mLocationClient.setLocationListener(this)
        //初始化定位参数
        mLocationOption = AMapLocationClientOption()
        //设置定位模式为Hight_Accuracy高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(true)
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption)
        //启动定位
        mLocationClient.startLocation()
    }
}


