package com.example.searchbookapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.searchbookapp.data.model.NoticeModel
import com.example.searchbookapp.databinding.FragmentNoticeDetailBinding

class NoticeDetailFragment : Fragment() {

    private var _binding: FragmentNoticeDetailBinding? = null
    private val binding: FragmentNoticeDetailBinding get() = _binding!!
    private val args by navArgs<NoticeDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoticeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val notice: NoticeModel.NoticeList = args.notice
            titleTv.text = notice.title
            contentsTv.text = notice.contents
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}