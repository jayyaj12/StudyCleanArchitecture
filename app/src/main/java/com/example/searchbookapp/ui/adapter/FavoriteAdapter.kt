package com.example.searchbookapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.databinding.ItemBookBinding

class FavoriteAdapter : ListAdapter<Document, FavoriteViewHolder>(diffUtil) {
    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Document>() {
            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.isbn == newItem.isbn
            }

            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val book = currentList[position]
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(book)
            }
        }

        return holder.bind(book)
    }

    private var onItemClickListener: ((Document) -> Unit)? = null

    fun setOnItemClickListener(listener: (Document) -> Unit) {
        onItemClickListener = listener
    }
}