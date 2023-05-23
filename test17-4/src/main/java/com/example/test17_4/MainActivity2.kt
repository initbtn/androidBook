package com.example.test17_4

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //공유 프리퍼런스 예제 사용해보기

        val pref = getSharedPreferences("inputPref", Context.MODE_PRIVATE)
        pref.edit().run {
            putString("test", "앱별 공유 프리퍼런스 테스트 중 , 값 부분.")
            putString("name", "남성호, 공유 파일명(이름은 아무거나)은 : inputPref")
            commit()
        }
        val resultStr2 : String? = pref.getString("test","default")
        val resultStr3 : String? = pref.getString("name","default")
        val result3 = resultStr2.toString()
        val result4 = resultStr3.toString()
        Log.d("nsh","test result3 결과 : $result3")
        Log.d("nsh","name result4 결과 : $result4")

        
    }
}