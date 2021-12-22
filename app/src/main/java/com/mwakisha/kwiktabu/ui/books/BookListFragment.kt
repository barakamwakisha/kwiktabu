package com.mwakisha.kwiktabu.ui.books

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.mwakisha.kwiktabu.databinding.FragmentBookListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookListFragment : Fragment() {
    private val viewModel by viewModels<BooksViewModel>()

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookListBinding.inflate(layoutInflater)

        binding.bookList.layoutManager = GridLayoutManager(context, 2)
        val adapter = BookAdapter()
        binding.bookList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allBooks.collectLatest {
                adapter.submitData(it)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}