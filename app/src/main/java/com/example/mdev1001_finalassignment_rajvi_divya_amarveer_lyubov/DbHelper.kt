package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context, "QUOTESDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE WORLD_QUOTES(_id integer primary key autoincrement, QUOTE TEXT, AUTHOR TEXT)")
        db?.execSQL("INSERT INTO WORLD_QUOTES(QUOTE, AUTHOR)VALUES('Life isn’t about getting and having, it’s about giving and being.', 'Kevin Kruse')")
        db?.execSQL("INSERT INTO WORLD_QUOTES(QUOTE, AUTHOR)VALUES('Whatever the mind of man can conceive and believe, it can achieve.', 'Napoleon Hill')")
        db?.execSQL("INSERT INTO WORLD_QUOTES(QUOTE, AUTHOR)VALUES('Strive not to be a success, but rather to be of value.', 'Albert Einstein')")
        db?.execSQL("INSERT INTO WORLD_QUOTES(QUOTE, AUTHOR)VALUES('Two roads diverged in a wood, and I—I took the one less traveled by, And that has made all the difference.', 'Robert Frost')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}