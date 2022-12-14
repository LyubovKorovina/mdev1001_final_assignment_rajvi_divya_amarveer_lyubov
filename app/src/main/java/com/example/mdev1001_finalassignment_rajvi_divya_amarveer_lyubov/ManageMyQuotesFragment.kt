package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ManageMyQuotesFragment : Fragment() {

    lateinit var db : DbHelper


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        val view = inflater.inflate(R.layout.fragment_manage_my_quotes, container, false)
        db = DbHelper(view.context)

        val listOfAllQuotes = db.getAllQuotes()

        val recyclerView = view.findViewById<RecyclerView>(R.id.listOfQuotes)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val quoteAdapter = QuoteAdapter(view.context, listOfAllQuotes)
        recyclerView.adapter = quoteAdapter


        // this is the code for btn Add quote
        val btnAddNewQuote = view.findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAddNewQuote.setOnClickListener {
            view.findNavController().navigate(R.id.action_manageMyQuotesFragment_to_addNewQuoteFragment)
        }

//        // this is the code for btn Update quote
//        val btnManage = view.findViewById<Button>(R.id.manageMyQuotes)
//        btnManage.setOnClickListener {
//            view.findNavController().navigate(R.id.action_manageMyQuotesFragment_to_updateQuoteFragment)
//        }

        return view
    }

}