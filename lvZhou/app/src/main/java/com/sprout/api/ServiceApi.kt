package com.sprout.api


import com.sprout.bean.ChannelData
import com.sprout.model.BaseResp
import com.sprout.model.BrandData
import com.sprout.model.GoodData
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 网络请求API
 */
interface ServiceApi {

    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>

    //sprout.cdwan.cn/api/channel/channel
    @GET("channel/channel")
    suspend fun channel(): ChannelData

    @GET("tag/brand")
    suspend fun getBrand(@Query("page") page:Int,@Query("size") size:Int):BaseResp<BrandData>

    @GET("tag/good")
    suspend fun getGood(@Query("page") page:Int,@Query("size") size:Int):BaseResp<GoodData>


}