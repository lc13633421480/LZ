package com.sprout.api


import com.sprout.bean.ChannelData
import com.sprout.bean.LoginData
import com.sprout.bean.RegisterMessage
import com.sprout.bean.TrendsListData
import com.sprout.model.*
import io.reactivex.Flowable
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

    //sprout.cdwan.cn/api/trends/submitTrends
    //发布动态
    @POST("trends/submitTrends")
    @FormUrlEncoded
    suspend fun submit()

    /**
     * 发布动态接口
     */
    @POST("trends/submitTrends")
    suspend fun submitTrends(@Body trends: RequestBody):BaseResp<SubmitTrendsData>

    /**
     * 主题数据
     */
    @GET("theme/getTheme")
    suspend fun getTheme():BaseResp<List<ThemeData>>
}