package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController

class UpdateQuoteFragment : Fragment() {

    lateinit var db : DbHelper
    private var quoteId = 0
    lateinit var updateQuote: EditText
    lateinit var updateAuthor: EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        quoteId = arguments?.getInt("quoteId") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_update_quote, container, false)

        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

        db = DbHelper(view.context)

        updateQuote = view.findViewById(R.id.updateQuote)
        updateAuthor =view.findViewById(R.id.updateAuthor)

        var quote = db.getSingleQuote(quoteId)

        db = DbHelper(view.context)

        updateQuote = view.findViewById(R.id.updateQuote)
        updateAuthor =view.findViewById(R.id.updateAuthor)

        updateQuote.text = quote.quote.toEditable()
        updateAuthor.text = quote.author.toEditable()

        //updating a quote
        val btnUpdate = view.findViewById<Button>(R.id.btnUpdateQuote)
        btnUpdate.setOnClickListener {
            db.updateQuote(
                quoteId,
                updateQuote.text.toString(),
                updateAuthor.text.toString(),
            )
            Toast.makeText(this.view?.context, "Quote was updated", Toast.LENGTH_LONG).show()
        }

        //deleting a quote
        val btnDelete = view.findViewById<Button>(R.id.btnDeleteQuote)
        btnDelete.setOnClickListener {
            db.deleteQuote(quoteId)
        }

        return view
    }


}