package com.example.searchbookapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.searchbookapp.data.model.Notice
import com.example.searchbookapp.databinding.ItemNoticeBinding

class NoticeViewHolder(
    private val binding: ItemNoticeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(notice: Notice) {
        binding.apply {
            titleTv.text = notice.title
            contentsTv.text = notice.contents
        }
    }

}