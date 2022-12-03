package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        var helper = DbHelper(applicationContext)
        var db :SQLiteDatabase = helper.readableDatabase
    }
}