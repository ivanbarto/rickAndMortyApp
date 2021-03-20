package com.ivanbarto.viewModelPractice.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.data.DataSource
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.domain.RepoImpl
import com.ivanbarto.viewModelPractice.ui.factory.viewModels.CharactersViewModelFactory


class CharactersFragment : Fragment() {

    private val onCharacterClick : (character : Character) -> Unit = {
        Log.d("onCharacterClick=====>", "$it")
    }

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

        CharactersAdapter(requireContext()).onCharacterClick = this.onCharacterClick

        return inflater.inflate(R.layout.fragment_characters, container, false)
    }

    companion object {
        val TAG = this::class
    }
}