package com.example.test18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View.MeasureSpec
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.test18.databinding.ActivityMain2Binding
import com.example.test18.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val requestLauncher =registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            Log.d("nsh","it.data.data의 값이 뭔가? : ${it.data?.data}")
            Glide.with(this@MainActivity2)
                .load(it.data?.data)
                .override(200,200)
                .into(binding.resultView)
        }
        val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type="image/*"
        requestLauncher.launch(intent)

    }
}