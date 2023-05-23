package com.example.test18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test18.Model.UserListModel
import com.example.test18.Model.UserModel
import com.example.test18.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.doGetUserList("2")

        binding.btn1test1.setOnClickListener {
            val test1= networkService.test1()

            test1.enqueue(object:Callback<UserModel>{
                override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                    val userModelSample = response.body()
                    Log.d("nsh","test1()호출예제2이고 값조회: ${userModelSample}")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                }

            })
        }

        userListCall.enqueue(
            object: Callback<UserListModel>{
                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {
                    //실제로 데이터는 response.body 에 있음.
                    val userList = response.body()
                    Log.d("nsh","userList(response.body())의 값:  ${userList}")
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}