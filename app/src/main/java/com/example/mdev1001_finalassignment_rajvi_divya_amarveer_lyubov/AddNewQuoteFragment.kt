package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddNewQuoteFragment : Fragment() {

    lateinit var db : DbHelper
    private lateinit var quote: EditText
    private lateinit var author: EditText
    private lateinit var errorMsg: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_new_quote, container, false)
        db = DbHelper(view.context)
        quote = view.findViewById(R.id.inputQuote)
        author = view.findViewById(R.id.inputAuthor)
        val btnAddNew = view.findViewById<Button>(R.id.btnAddNew)

        // below we add on click listener to add quote button
        btnAddNew.setOnClickListener{
            db.addQuote(
                quote = quote.text.toString(),
                author = author.text.toString()
            )

            // Toast to message on the screen
            Toast.makeText(this.view?.context, "Quote was added", Toast.LENGTH_LONG).show()

            quote.text.clear()
            author.text.clear()
        }

        return view
    }
    private fun validateInputs(): Boolean{
        var error = false
        if (quote.text.toString().trim() == ""){
            errorMsg = "Please, insert a quote"
        }else if (author.text.toString().trim() == ""){
            errorMsg = "Please, insert a quote author name"
            error = true
        }
        if (error){
            Toast.makeText(this.view?.context, errorMsg, Toast.LENGTH_LONG).show()

            return false
        }

        return true
    }


}