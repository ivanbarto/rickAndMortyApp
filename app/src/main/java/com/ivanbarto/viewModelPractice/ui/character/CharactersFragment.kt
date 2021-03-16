package com.ivanbarto.viewModelPractice.ui.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.data.DataSource
import com.ivanbarto.viewModelPractice.domain.RepoImpl
import com.ivanbarto.viewModelPractice.ui.factory.viewModels.CharactersViewModelFactory


class CharactersFragment : Fragment() {

    private val viewModel by viewModels<CharactersViewModel> {
        CharactersViewModelFactory(
            RepoImpl(
                dataSource = DataSource()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    companion object {
        val TAG = this::class
    }
}