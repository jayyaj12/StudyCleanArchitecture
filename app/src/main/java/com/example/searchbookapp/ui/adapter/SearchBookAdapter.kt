package com.example.searchbookapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.databinding.ItemBookBinding

class SearchBookAdapter :
    ListAdapter<Document, SearchBookViewHolder>(BookDiffCallback) {

    companion object {
        private val BookDiffCallback = object : DiffUtil.ItemCallback<Document>() {
            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookViewHolder {
        return SearchBookViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchBookViewHolder, position: Int) {
        val book = currentList[position]
        holder.bind(book)
    }
}