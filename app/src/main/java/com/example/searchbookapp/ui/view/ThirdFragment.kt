package com.example.searchbookapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.searchbookapp.data.model.Notice
import com.example.searchbookapp.databinding.FragmentThirdBinding
import com.example.searchbookapp.ui.adapter.NoticeAdapter
import com.example.searchbookapp.ui.viewmodel.NoticeViewModel
import com.example.searchbookapp.ui.viewmodel.NoticeViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ThirdFragment() : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private lateinit var noticeAdapter: NoticeAdapter
    private lateinit var noticeViewModel: NoticeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        val noticeViewModelFactory = NoticeViewModelFactory()
        noticeViewModel = ViewModelProvider(
            requireActivity(),
            noticeViewModelFactory
        )[NoticeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupNoticeRecyclerview()
        setupNoticeList()
        noticeAdapter.submitList(noticeViewModel.getNoticeList())

        binding.addItemBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                withContext(Dispatchers.Default) {
                    noticeViewModel.addClickAction(Notice("추가된 제목", "추가된 내용"))
                }

                // ListAdapter 의 submitList 메서드는 기존 list와 새로운 list의 주소값이 달라야만 값 비교가 가능. 따라서 갱신이 불가하다.
                // .toMutableList() 는 인스턴스를 복사하여 새로운 인스턴스 즉 다른 주소를 갖는 데이터를 생성해주는 메서드이다.
                noticeAdapter.submitList(noticeViewModel.getNoticeList().toMutableList())
            }
        }

        binding.deleteItemBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                withContext(Dispatchers.Default) {
                    noticeViewModel.deleteClickAction()
                }

                noticeAdapter.submitList(noticeViewModel.getNoticeList().toMutableList())
            }
        }
    }

    private fun setupNoticeRecyclerview() = with(binding) {
        noticeAdapter = NoticeAdapter()
        noticeRv.apply {
            hasFixedSize()
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = noticeAdapter
        }
    }

    private fun setupNoticeList() {
        noticeViewModel.setupNoticeList()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}