package com.example.searchbookapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.searchbookapp.R
import com.example.searchbookapp.data.model.Notice
import com.example.searchbookapp.data.model.NoticeModel
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

        // 제목을 누르면 공지 상세로 이동
        holder.itemView.findViewById<TextView>(R.id.title_tv).setOnClickListener {
            onItemClickListener?.let {
                val noticeList: NoticeModel.NoticeList = NoticeModel.NoticeList(
                    currentList[position].title,
                    currentList[position].contents
                )
                it(noticeList)
            }
        }
    }

    private var onItemClickListener: ((NoticeModel.NoticeList) -> Unit)? = null

    fun setOnItemClickListener(listener: ((NoticeModel.NoticeList) -> Unit)) {
        onItemClickListener = listener
    }
}