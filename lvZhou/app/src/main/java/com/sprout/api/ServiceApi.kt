package com.sprout.api


import com.sprout.bean.ChannelData
import com.sprout.bean.LoginData
import com.sprout.bean.TrendsListData
import com.sprout.model.BaseResp
import com.sprout.model.BrandData
import com.sprout.model.GoodData
import io.reactivex.Flowable
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

    //sprout.cdwan.cn/api/trends/submitTrends
    //发布动态
    @POST("trends/submitTrends")
    @FormUrlEncoded
    suspend fun submit()

    //sprout.cdwan.cn/api/trends/trendsList?command=1&page=2&size=5
    //动态的列表数据
    @GET("trends/trendsList")
    suspend fun trendsList(@Query("command") command:Int,
                           @Query("page")page : Int,@Query("size")size : Int):TrendsListData
}