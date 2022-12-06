package com.example.searchbookapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbookapp.databinding.FragmentThirdBinding
import com.example.searchbookapp.ui.adapter.FavoriteAdapter
import com.example.searchbookapp.ui.viewmodel.SearchBookViewModel
import com.google.android.material.snackbar.Snackbar

class ThirdFragment() : Fragment() {
    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var searchBookViewModel: SearchBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchBookViewModel = (activity as MainActivity).searchBookViewModel

        setupFavoriteRecyclerview()
        setupTouchHelper(view)

        searchBookViewModel.favoriteBooks.observe(viewLifecycleOwner) {
            favoriteAdapter.submitList(it)
        }

    }

    private fun setupFavoriteRecyclerview() = with(binding) {
        favoriteAdapter = FavoriteAdapter()
        favoriteRv.apply {
            hasFixedSize()
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = favoriteAdapter
        }

        favoriteAdapter.setOnItemClickListener {
            val action = ThirdFragmentDirections.actionFragmentFavoriteToBookUrlFragment(it)
            findNavController().navigate(action)
        }
    }

    private fun setupTouchHelper(view: View) {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val book = favoriteAdapter.currentList[position]
                searchBookViewModel.deleteBook(book)
                Snackbar.make(view, "Book has Delete", Snackbar.LENGTH_SHORT).apply {
                    setAction("Undo") {
                        searchBookViewModel.saveBook(book)
                    }
                }.show()
            }
        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.favoriteRv)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}