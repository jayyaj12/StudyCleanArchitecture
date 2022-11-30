package com.example.searchbookapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchbookapp.data.model.Notice
import com.example.searchbookapp.databinding.ItemNoticeBinding

class NoticeAdapter : ListAdapter<Notice, NoticeViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Notice>() {
            override fun areItemsTheSame(oldItem: Notice, newItem: Notice): Boolean {
                Log.e("areItemsTheSame", (oldItem.title == newItem.title).toString())
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Notice, newItem: Notice): Boolean {
                Log.e("areContentsTheSame", (oldItem == newItem).toString())
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        return NoticeViewHolder(
            ItemNoticeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}