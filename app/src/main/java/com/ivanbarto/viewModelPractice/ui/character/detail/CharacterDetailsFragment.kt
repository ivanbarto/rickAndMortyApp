package com.ivanbarto.viewModelPractice.ui.character.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.databinding.FragmentCharaterDetailsBinding
import com.ivanbarto.viewModelPractice.utils.constants.Constants


class CharacterDetailsFragment : Fragment() {
    companion object {
        val TAG = this::class
    }

    private var character : Character? = null

    private lateinit var binding : FragmentCharaterDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharaterDetailsBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recoverData()
        setupData()
    }

    private fun setupData(){
        character?.let{
            binding.ivCharacter.load(it.image){
                crossfade(true)
            }
            binding.tvDimension.text = it.location?.dimension ?: "-"
            binding.tvGender.text = it.gender?: "-"
            binding.tvLocation.text = it.location?.name?: "-"
            binding.tvOrigin.text = it.origin.name?: "-"
            binding.tvName.text = it.name?: "-"
            binding.tvStatus.text = it.status?: "-"
            if (!it.type.isNullOrEmpty()){
                binding.tvType.text = it.type
            }
            binding.tvSpecie.text = it.species?: "-"
        }
    }

    private fun recoverData(){
        requireArguments().let {
            character = it.getParcelable(Constants.CHARACTER_KEY)
        }
    }


}