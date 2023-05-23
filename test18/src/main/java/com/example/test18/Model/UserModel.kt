package com.example.test18.Model

import android.graphics.Bitmap
import android.provider.ContactsContract.CommonDataKinds.Email
import com.google.gson.annotations.SerializedName

data class UserModel(
    //data class 주생성자에 선언한 형식. 중괄호가 아니라, 소괄호 표기.
    var id: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var lastName: String,
    var avatar: String,
    var email: Email,
    var avatarBitmap: Bitmap
)