package com.example.searchbookapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.searchbookapp.databinding.FragmentSecondBinding
import com.example.searchbookapp.ui.adapter.SearchBookAdapter
import com.example.searchbookapp.ui.viewmodel.SearchBookViewModel

class SecondFragment() : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchBookViewModel: SearchBookViewModel
    private lateinit var searchBookAdapter: SearchBookAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchBookViewModel = (activity as MainActivity).searchBookViewModel

        setupBookRecyclerview()
        searchBooks()

        searchBookViewModel.searchResult.observe(viewLifecycleOwner) { response ->
            val books = response.documents
            searchBookAdapter.submitList(books)
        }
    }

    private fun searchBooks() {
        var startTime: Long = System.currentTimeMillis()
        var endTime: Long

        binding.searchBookEt.addTextChangedListener { editView ->
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= 100) {
                editView?.let {
                    searchBookViewModel.searchBooks(editView.toString().trim())
                }
            }
            startTime = endTime
        }
    }

    private fun setupBookRecyclerview() {
        searchBookAdapter = SearchBookAdapter()
        binding.bookListRv.apply {
            setHasFixedSize(false)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = searchBookAdapter
        }

        searchBookAdapter.setOnItemClickListener {
            val action = SecondFragmentDirections.actionFragmentSearchToBookUrlFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}