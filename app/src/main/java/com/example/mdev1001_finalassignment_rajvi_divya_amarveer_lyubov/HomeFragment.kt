package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val btnAddNewQuote = view.findViewById<Button>(R.id.btnAddNewQuote)

        btnAddNewQuote.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_addNewQuoteFragment)
        }
        return view
    }

}