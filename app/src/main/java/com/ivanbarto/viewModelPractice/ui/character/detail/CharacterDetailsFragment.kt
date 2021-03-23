package com.ivanbarto.viewModelPractice.ui.character.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ivanbarto.viewModelPractice.R
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.utils.constants.Constants


class CharacterDetailsFragment : Fragment() {

//    private var character : Character?

//    init {
//        requireArguments().let {
//           character = it.getParcelable(Constants.CHARACTER_KEY)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charater_details, container, false)
    }

    companion object {
        val TAG = this::class
    }
}