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
import android.widget.Toast
import com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov.databinding.FragmentUpdateQuoteBinding

class UpdateQuoteFragment : Fragment() {

    lateinit var db : DbHelper
    private var quoteId = 0
    lateinit var quote: EditText
    lateinit var author: EditText

    private var _binding:FragmentUpdateQuoteBinding? = null
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        quoteId = arguments?.getInt("quoteId") ?: 0
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //db = DbHelper(view.context)

        fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)

        _binding = FragmentUpdateQuoteBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        db = DbHelper(view.context)

        val quote = db.getSingleQuote(quoteId)

        binding.updateQuote.text = quote.quote.toEditable()
        binding.updateAuthor.text = quote.author.toEditable()

        binding.btnUpdateQuote.setOnClickListener{
            Toast.makeText(this.view?.context, "Quote was updated", Toast.LENGTH_LONG).show()
        }


        binding.btnDeleteQuote.setOnClickListener {
            db.deleteQuote(quoteId)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}