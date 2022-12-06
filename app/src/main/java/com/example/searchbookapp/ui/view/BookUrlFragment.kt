package com.example.searchbookapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.searchbookapp.databinding.FragmentBookUrlBinding
import com.example.searchbookapp.ui.viewmodel.SearchBookViewModel

class BookUrlFragment : Fragment() {
    private var _binding: FragmentBookUrlBinding? = null
    private val binding: FragmentBookUrlBinding get() = _binding!!
    private val args by navArgs<BookUrlFragmentArgs>()
    private lateinit var searchBookViewModel: SearchBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookUrlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchBookViewModel = (activity as MainActivity).searchBookViewModel

        val book = args.document
        binding.urlWv.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(book.url)
        }

        binding.favoriteFab.setOnClickListener {
            searchBookViewModel.saveBook(book)
        }
    }

    override fun onPause() {
        super.onPause()

        binding.urlWv.onPause()
    }

    override fun onResume() {
        super.onResume()

        binding.urlWv.onResume()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}