package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class UpdateQuoteFragment : Fragment() {

    private lateinit var db : DbHelper
    private var quoteId = 0
    lateinit var quote: EditText
    lateinit var author: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_update_quote, container, false)
        db = DbHelper(view.context)

        quote = view.findViewById(R.id.inputQuote)
        author = view.findViewById(R.id.inputAuthor)



        return view
    }

}