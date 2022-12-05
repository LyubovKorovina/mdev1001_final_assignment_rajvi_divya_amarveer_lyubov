package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.navigation.findNavController
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class HomeFragment : Fragment() {
   private lateinit var  textv: TextView
    private lateinit var  buttonv: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

         textv = view?.findViewById<TextView>(R.id.quoteText)!!
          buttonv = view?.findViewById<Button>(R.id.btnRandomQuote)!!

        buttonv.setOnClickListener {
            fetchData()
        }
        val btnManageMyQuotes = view.findViewById<Button>(R.id.btnManageMyQuotes)
        btnManageMyQuotes.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_manageMyQuotesFragment)
        }

        return view
    }

    private fun fetchData() {

        val url = "https://dummyjson.com/quotes"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val quotesJsonArray = it.getJSONArray("quotes")
                //  Log.d("abc", quotesJsonArray[0].toString())
                val  quotesArray = ArrayList<Quotes>()
                for(i in 0 until quotesJsonArray.length() ){
                    val quotesJasonObject = quotesJsonArray.getJSONObject(i)
                  //  val quote1 = quotesJasonObject.getString("quote")
                  // textv.text = quote1

                    val quote = Quotes(
                        quotesJasonObject.getString("quote")
                    )
                    quotesArray.add(quote)
                }
                val random = (0..29).random()
                textv.text = quotesArray[random].quote

            },
            Response.ErrorListener {

            }
        )
        context?.let { MySingleton.getInstance(it).addToRequestQueue(jsonObjectRequest) }


    }

}