package com.example.searchbookapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.searchbookapp.data.model.Document
import com.example.searchbookapp.databinding.ItemBookBinding

class FavoriteViewHolder(
    private val binding: ItemBookBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(book: Document) {
        itemView.apply {
            binding.titleTv.text = book.title
            binding.contentsTv.text = book.contents
            Glide.with(context)
                .load(book.thumbnail)
                .into(binding.thumbnailIv)
        }
    }

}