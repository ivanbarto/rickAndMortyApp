package com.ivanbarto.viewModelPractice.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.data.DataSource
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.databinding.FragmentCharactersBinding
import com.ivanbarto.viewModelPractice.domain.RepoImpl
import com.ivanbarto.viewModelPractice.ui.factory.viewModels.CharactersViewModelFactory
import com.ivanbarto.viewModelPractice.utils.constants.Constants
import com.ivanbarto.viewModelPractice.vo.Resource


class CharactersFragment : Fragment() {
    companion object {
        val TAG = this::class
    }

    lateinit var binding: FragmentCharactersBinding


    private val onCharacterClick: (character: Character) -> Unit = {
        val bundle =
            Bundle().also { parcelable -> parcelable.putParcelable(Constants.CHARACTER_KEY, it) }
        findNavController().navigate(
            R.id.action_charactersFragment_to_characterDetailsFragment,
            bundle
        )
    }

    private val charactersViewModel by viewModels<CharactersViewModel> {
        CharactersViewModelFactory(
            RepoImpl(
                dataSource = DataSource()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCharactersBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         *ViewModel Observers
         */
        charactersViewModel.fetchCharacters.observe(viewLifecycleOwner, { result ->
            when (result) {
                is Resource.Loading -> {
                    Snackbar.make(
                        requireContext(),
                        binding.root,
                        getString(R.string.loading),
                        Snackbar.LENGTH_SHORT
                    ).also {
                        it.setBackgroundTint(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.successColor
                            )
                        )
                        it.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.black
                            )
                        )
                    }.show()
                }
                is Resource.Success -> {
                    setupCharacters(result.data)
                }
                is Resource.Failure -> {
                    Snackbar.make(
                        requireContext(),
                        binding.root,
                        getString(R.string.failure),
                        Snackbar.LENGTH_SHORT
                    ).also {
                        it.setBackgroundTint(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.errorColor
                            )
                        )
                    }.show()
                }
            }

        })

    }

    private fun setupCharacters(characters: List<Character>) {
        binding.rvCharacters.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvCharacters.adapter = CharactersAdapter(requireContext()).also {
            it.onCharacterClick = onCharacterClick
            it.setCharacters(characters)
        }
    }

}