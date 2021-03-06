package com.sprout.net.repository


import com.shop.net.RetrofitFactory
import com.sprout.api.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.RequestBody

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api   类似mvp的m层逻辑
 */
class SystemRepository {

    private lateinit var serviceApi: ServiceApi

    //初始化的方法
    init {
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)
    }

    /**
     * 刷新token
     */
    suspend fun refreshToken() = withContext(Dispatchers.IO){
        serviceApi.refreshToken()
    }


//    /**
//     * 获取主页数据
//     */
    suspend fun channel() = withContext(Dispatchers.IO){
        serviceApi.channel()
    }


    suspend fun getBrand(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getBrand(page,size)
    }

    suspend fun getGoods(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getGood(page, size)
    }

    suspend fun login(username:String,pw:String) = withContext(Dispatchers.IO){
        serviceApi.Login(username,pw)
    }

    suspend fun register(userName :String,userPsw:String,imei:String,lng:String,lat:String) = withContext(Dispatchers.IO){
        serviceApi.register(userName,userPsw,imei,lng, lat)
    }

    /**
     * 提交动态数据
     */
    suspend fun submitTrends(requestBody: RequestBody) = withContext(Dispatchers.IO){
        serviceApi.submitTrends(requestBody)
    }

    /**
     * 获取主题数据
     */
    suspend fun getTheme() = withContext(Dispatchers.IO){
        serviceApi.getTheme()
    }


}