package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class DbHelper(context: Context) : SQLiteOpenHelper(context, "QUOTESDB", null, 1) {
    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE MY_QUOTES(_id integer primary key autoincrement, QUOTE TEXT, AUTHOR TEXT);")
    }

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

    fun getAllQuotes() : ArrayList<QuoteModel> {
        val sqliteDb = this.readableDatabase
        var cursor = sqliteDb.rawQuery("Select * from MY_QUOTES", null)
        val quotes = ArrayList<QuoteModel>()

        while (cursor.moveToNext()) {
            val model = QuoteModel(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2)
            )
            quotes.add(model)
        }
        return quotes
    }

    fun getSingleQuote(quoteId : Int) : QuoteModel{
        val sqliteDb = this.readableDatabase
        var cursor = sqliteDb.rawQuery("SELECT * FROM MY_QUOTES WHERE _id=$quoteId", null)
        val quotes = ArrayList<QuoteModel>()

        cursor.moveToFirst()

        val quote = QuoteModel(
            cursor.getInt(0),
            cursor.getString(1),
            cursor.getString(2)
        )
        cursor.close()

        return quote
    }

    fun updateQuote(quoteId:Int, quote : String, author : String) : Boolean{
        val sqliteDb = this.writableDatabase
        val values = contentValuesOf().apply {
            put("QUOTE", quote)
            put("AUTHOR", author)
        }
        val result = sqliteDb.update("MY_QUOTES", values, "_id=$quoteId",null)

        return result >= 1
    }

    fun deleteQuote(quoteId: Int) : Boolean{
        val sqliteDb = this.writableDatabase

        return sqliteDb.delete("MY_QUOTES", "_id=$quoteId", null) >= 1
    }

}