package com.example.presentation.view.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.presentation.databinding.FragmentBookBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class BookFragment : Fragment() {

    private var _binding :FragmentBookBinding? = null
    private val binding get() = _binding!!
    @Inject
    lateinit var bookViewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentBookBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("bookViewModasdasddel $bookViewModel")

//        getSearchBook()
    }

    private fun getSearchBook() {
        bookViewModel.getSearchBook(
            query = "asd",
            sort = null,
            page = null,
            size = null,
            target = null
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}