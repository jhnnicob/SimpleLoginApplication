package com.nico.loginapplication.apiservice

import com.nico.loginapplication.viewmodel.SignInBody
import com.nico.loginapplication.viewmodel.UserBody
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("user/auth/signin")
    fun signin(@Body info: SignInBody): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("user/auth/signin")
    fun registerUser(
        @Body info: UserBody
    ): retrofit2.Call<ResponseBody>
}
class RetrofitInstance {
    companion object {
        private const val BASE_URL: String = "http://servserver-env.eba-kawr6n3u.us-east-2.elasticbeanstalk.com/api/"

        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}