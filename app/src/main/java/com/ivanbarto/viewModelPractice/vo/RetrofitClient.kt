package com.ivanbarto.viewModelPractice.vo

import com.google.gson.GsonBuilder
import com.ivanbarto.viewModelPractice.BuildConfig
import com.ivanbarto.viewModelPractice.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *Created by ivanbarto on 23/03/21
 */
object RetrofitClient {
    /**
     * This is the basic implementation of Retrofit Client
     * by lazy means that your object will be initialized when required
     */
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL) //your API base URL
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())) //add a JSON converter factory, like Gson
            .build().create(WebService::class.java)

    }
}