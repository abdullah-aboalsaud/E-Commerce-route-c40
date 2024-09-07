package com.example.e_commerce_route_c40.api

import android.util.Log
import com.fady.myapplicationss.api.ServiceCategories
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiModule {
    private var retrofit: Retrofit? = null

    private var loggingInterceptor: HttpLoggingInterceptor? = null
    private var okHttpClient: OkHttpClient? = null

    init {
        initLoggingInterceptor()
        initOkHttpClient(loggingInterceptor!!)

    }

    private fun initOkHttpClient(loggingInterceptor: Interceptor): OkHttpClient {
        if (okHttpClient == null) {
            okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor)
                .build()
        }
        return okHttpClient!!

    }


    private fun initLoggingInterceptor(): HttpLoggingInterceptor {
        if (loggingInterceptor == null) {
            loggingInterceptor = HttpLoggingInterceptor {
                Log.e("API", it)
            }
            loggingInterceptor!!.level = HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor!!
    }


    private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://ecommerce.routemisr.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getCategoryService(): ServiceCategories {
        return getRetrofit(okHttpClient!!).create(ServiceCategories::class.java)
    }

}
