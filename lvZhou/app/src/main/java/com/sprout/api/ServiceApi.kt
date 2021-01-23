package com.sprout.api


import com.sprout.bean.ChannelData
import com.sprout.bean.LoginData
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

}