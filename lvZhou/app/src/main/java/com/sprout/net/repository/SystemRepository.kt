package com.sprout.net.repository


import com.shop.net.RetrofitFactory
import com.sprout.api.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

    suspend fun getGood(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getGood(page,size)
    }


}