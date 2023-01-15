package com.example.belajarandroiddasar

import android.app.Application
import android.util.Log

// pakai Application bukan yg AppCompat buat ambil Application Context
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Log.e("APP", "APPLICATION CREATED!")
    }
}