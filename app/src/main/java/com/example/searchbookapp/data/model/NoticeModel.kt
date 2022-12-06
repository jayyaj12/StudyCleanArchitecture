package com.example.searchbookapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

object NoticeModel {
    var noticeList: ArrayList<Notice> = arrayListOf()

    @Parcelize
    data class NoticeList(
        val title: String,
        val contents: String
    ) : Parcelable
}