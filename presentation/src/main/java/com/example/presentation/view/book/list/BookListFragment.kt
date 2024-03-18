package com.example.presentation.view.book.list

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.domain.model.UiBookModel
import com.example.presentation.BR
import com.example.presentation.R
import com.example.presentation.databinding.FragmentBookBinding
import com.example.sample.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class BookListFragment : BaseFragment<FragmentBookBinding, BookListViewModel>(R.layout.fragment_book), UiBookModel.OnItemClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSearchBook()
        setupUi()
    }

    private fun getSearchBook() {
        viewModel.getSearchBook(
            query = "KBS",
            sort = null,
            page = null,
            size = null,
            target = null
        )
    }

    private fun setupUi() {
        binding.setVariable(BR.eventHolder, this)
    }

    override fun setupObserver() {

    }

    override fun onItemClick(item: UiBookModel) {
        val action = BookListFragmentDirections.actionBookFragmentToBookDetailFragment(item)
        findNavController().navigate(action)
    }
}