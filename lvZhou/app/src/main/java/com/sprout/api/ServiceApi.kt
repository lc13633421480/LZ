package com.sprout.api


import com.sprout.bean.*
import com.sprout.model.*
import okhttp3.RequestBody
import retrofit2.http.*

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

    //tag/goods?page=1&size=10
    @GET("tag/goods")
    suspend fun getGood(@Query("page") page:Int,@Query("size") size:Int):BaseResp<GoodData>

    //http://sprout.cdwan.cn/api/auth/login
    //登录
    @POST("auth/login")
    @FormUrlEncoded
    suspend fun Login(
        @Field("username") username: String,
        @Field("password") pw: String
    ): BaseResp<LoginData>

    /**
     * 注册
     */
    @POST("auth/register")
    @FormUrlEncoded
    suspend fun register(@Field("username")userName :String,
                         @Field("password")userPsw:String,
                         @Field("imei")imei:String,
                         @Field("lng")lng:String,
                         @Field("lat")lat:String):
            BaseResp<RegisterMessage>

    /**
     * 发布动态接口
     */
    @POST("trends/submitTrends")
    suspend fun submitTrends(@Body trends:RequestBody):BaseResp<SubmitTrendsData>

    //sprout.cdwan.cn/api/trends/trendsList?command=1&page=2&size=5
    /**
     * 获取动态数据
     */
    @GET("trends/trendsList")
    suspend fun trendsList(@Query("command") command:Int,
                           @Query("channelid") channelid:Int,
                           @Query("page") page:Int,
                           @Query("size") size: Int):BaseResp<List<TrendsData>>

    /**
     * 主题数据
     */
//    @GET("theme/getTheme")
//    suspend fun getTheme():BaseResp<List<ThemeData>>
}