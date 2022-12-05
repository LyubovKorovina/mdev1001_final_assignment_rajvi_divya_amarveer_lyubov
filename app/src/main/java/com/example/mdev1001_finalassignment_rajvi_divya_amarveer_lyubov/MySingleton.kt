package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov



import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley


class MySingleton constructor(context: Context) {


    companion object {
        @Volatile
        private var INSTANCE: MySingleton? = null
        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MySingleton(context).also {
                    INSTANCE = it
                }
            }
    }
    private val requestQueue: RequestQueue by lazy {

        Volley.newRequestQueue(context.applicationContext)
    }
        fun <T> addToRequestQueue (reg: Request<T>) {
            requestQueue.add(reg)

        }
}
