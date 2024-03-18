package com.example.domain.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class UiBookModel(
    val title: String = "",
    val contents: String = "",
    val url: String = "",
    val datetime: String = "",
    val authors: List<String> = listOf(),
    val publisher: String = "",
    val price: Int = 0,
    val salePrice: Int = 0,
    val thumbnail: String = "",
    val status: String = ""
): Parcelable {

    interface OnItemClickListener {
        fun onItemClick(item: UiBookModel)
    }

    companion object : DiffUtil.ItemCallback<UiBookModel>() {
        override fun areItemsTheSame(oldItem: UiBookModel, newItem: UiBookModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun areContentsTheSame(oldItem: UiBookModel, newItem: UiBookModel): Boolean {
            return oldItem == newItem
        }
    }
}
