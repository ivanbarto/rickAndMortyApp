package com.ivanbarto.viewModelPractice.ui.factory.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ivanbarto.viewModelPractice.domain.Repo

/**
 *Created by ivanbarto on 16/03/21
 */

/**
 * These factories helps to create and deliver viewModels with their related parameters
 */

class CharactersViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)
    }
}