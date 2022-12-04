package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DbHelper(context: Context) : SQLiteOpenHelper(context, "QUOTESDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE MY_QUOTES(_id integer primary key autoincrement, QUOTE TEXT, AUTHOR TEXT);")
    }

    // below is the method for creating a database by a sqlite query
//    override fun onCreate(db: SQLiteDatabase) {
//        val query = ("CREATE TABLE MY_QUOTES  ( _id  INTEGER PRIMARY KEY AUTOINCREMENT, QUOTE TEXT, AUTHOR TEXT)")
//        // we are calling sqlite method for executing our query
//        db.execSQL(query)
//    }

    // this method is to check if table already exists
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS  MY_QUOTES;")
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addQuote(quote : String, author : String ) : Boolean {

        val sqliteDb = this.writableDatabase

        val values = contentValuesOf().apply {
            put("QUOTE", quote)
            put("AUTHOR", author)
        }

        val newRowId = sqliteDb.insert("MY_QUOTES",null, values)
        return newRowId.toInt() != -1

    }

    // below method is to get all data from our database
    fun getQuote(): Cursor? {

        // here we are creating a readable variable of our database as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to read data from the database
        return db.rawQuery("SELECT * FROM MY_QUOTES", null)

    }

    // here we have defined variables for our database
    companion object{

        // below is variable for database name
        private val DATABASE_NAME = "QUOTESDB"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_NAME = "MY_QUOTES"

        // below is the variable for id column
        val _id = "id"

        // below is the variable for quote column
        val QUOTE = "quote"

        // below is the variable for author column
        val AUTHOR = "author"
    }

}