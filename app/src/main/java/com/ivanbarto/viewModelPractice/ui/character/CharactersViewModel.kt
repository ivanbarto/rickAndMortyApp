package com.ivanbarto.viewModelPractice.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ivanbarto.viewModelPractice.domain.Repo
import com.ivanbarto.viewModelPractice.vo.Resource
import kotlinx.coroutines.Dispatchers

class CharactersViewModel(private val repo:Repo) : ViewModel() {

    /**
     * this ViewModel doesn't know from where the data is fetched. It just query information.
     * Also, it doesn't know where it has to dispatch the data fetched. For that purpose, it uses
     * emit().
     */

    val fetchCharacters = liveData(Dispatchers.IO) {
        /**
         * emit() is used to emit information so the observers era able to see that data broadcast
         * and catch that data
         */
        emit(Resource.Loading())
        try {
            emit(repo.getCharacters())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}