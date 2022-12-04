package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddNewQuoteFragment : Fragment() {

    lateinit var db : DbHelper
    lateinit var quote: EditText
    lateinit var author: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_new_quote, container, false)
        db = DbHelper(view.context)
        quote = view.findViewById(R.id.inputQuote)
        author = view.findViewById(R.id.inputAuthor)
        val btnAddNew = view.findViewById<Button>(R.id.btnAddNew)

        // below we add on click listener to add quote button
        btnAddNew.setOnClickListener{
            val result = db.addQuote(
                quote = quote.text.toString(),
                author = author.text.toString()
            )
        }

        return view
    }

}