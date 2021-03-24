package com.ivanbarto.viewModelPractice.ui.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ivanbarto.viewModelPractice.data.PaginatedCharactersDataSource
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.domain.Repo
import com.ivanbarto.viewModelPractice.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class CharactersViewModel(private val repo: Repo.Characters) : ViewModel() {

    /**
     * this ViewModel doesn't know from where the data is fetched. It just query information.
     * Also, it doesn't know where it has to dispatch the data fetched. For that purpose, it uses
     * emit().
     */


    val characters: Flow<PagingData<Character>> =
        Pager(config = PagingConfig(pageSize = 20, prefetchDistance = 2),
            pagingSourceFactory = { PaginatedCharactersDataSource() }
        ).flow.cachedIn(viewModelScope)

    val fetchPaginatedCharacters = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(
                Pager(
                    config = PagingConfig(pageSize = 20, prefetchDistance = 2),
                    pagingSourceFactory = { PaginatedCharactersDataSource() }
                ).flow.cachedIn(viewModelScope)))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

    val fetchCharacters = liveData(Dispatchers.IO) {
        /**
         * emit() is used to emit information, so the observers era able to see that data broadcast
         * and catch it
         */
        emit(Resource.Loading())
        try {
            emit(repo.getCharacters())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}