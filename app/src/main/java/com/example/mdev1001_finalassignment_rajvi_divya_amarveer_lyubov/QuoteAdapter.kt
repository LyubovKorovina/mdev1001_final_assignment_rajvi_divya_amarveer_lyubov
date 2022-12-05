package com.example.mdev1001_finalassignment_rajvi_divya_amarveer_lyubov

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(val context: Context, val quotes : ArrayList<QuoteModel>)
    : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = quotes[position]

        holder.quoteId = quote.id
        holder.quoteText.text = quote.quote
        holder.quoteAuthor.text = quote.author

    }

    override fun getItemCount(): Int {
        return quotes.size }


    class QuoteViewHolder(val view : View):RecyclerView.ViewHolder(view) {
        var quoteId = 0
        var quoteText = view.findViewById<TextView>(R.id.quoteText)
        var quoteAuthor = view.findViewById<TextView>(R.id.quoteAuthor)
    }

    }

