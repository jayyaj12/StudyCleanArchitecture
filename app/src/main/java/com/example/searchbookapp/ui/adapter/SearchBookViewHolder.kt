package com.example.searchbookapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.databinding.ItemBookBinding

class SearchBookViewHolder(
    private val binding: ItemBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Document) {
        val title = book.title
        val contents = book.contents

        itemView.apply {
            binding.titleTv.text = title
            binding.contentsTv.text = contents
            Glide.with(context)
                .load(book.thumbnail)
                .into(binding.thumbnailIv)
        }
    }

}