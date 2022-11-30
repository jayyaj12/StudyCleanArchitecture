package com.example.searchbookapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.searchbookapp.data.model.Notice
import com.example.searchbookapp.data.model.NoticeModel

class NoticeViewModel : ViewModel() {

    fun addClickAction(item: Notice) {
        NoticeModel.noticeList.add(item)
    }

    fun deleteClickAction() {
        if (NoticeModel.noticeList.size > 0) {
            NoticeModel.noticeList.removeLast()
        }
    }

    fun getNoticeList(): List<Notice> {
        return NoticeModel.noticeList
    }

    fun setupNoticeList() {
        NoticeModel.noticeList.clear()
        
        for (i in 1..15) {
            NoticeModel.noticeList.add(Notice("제목 $i", "내용 $i"))
        }
    }

}