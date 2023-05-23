package com.example.test18

import android.app.Application
import com.example.test18.retrofit.INetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication :Application() {
    //Application을 상속을 받아야함!!
    //INetworkService 인터페이스 타입의 변수를 선언
    //Retrofit 타입의 객체를 생성
    //retrofit.create(INetworkService::class.java)
    //위에서 정의한 인터페이스를 구현한 객체를 반환한 값 가지고 와서
    //
    var networkService: INetworkService

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    init { //클래스를 생성 또는 사용하면, 할당 작업.
        networkService = retrofit.create(INetworkService::class.java)
    }
}