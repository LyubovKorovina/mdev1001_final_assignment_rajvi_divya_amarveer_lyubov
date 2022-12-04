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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ManageMyQuotesFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.fragment_manage_my_quotes, container, false)

        val btnAddNewQuote = view.findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAddNewQuote.setOnClickListener {
            view.findNavController().navigate(R.id.action_manageMyQuotesFragment_to_addNewQuoteFragment)
        }

        return view
    }

}