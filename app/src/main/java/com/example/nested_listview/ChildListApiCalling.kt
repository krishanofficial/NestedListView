package com.example.nested_listview

import android.database.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ChildListApiCalling {
    @GET("apiDemo")
    fun getUser(): io.reactivex.Observable<List<ChildDataModel>>
    companion object factory{
        fun  create():ChildListApiCalling{
            val retrofit= Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://demo5681495.mockable.io/ ")
                .build()
            return retrofit.create(ChildListApiCalling::class.java)
        }
    }
}