package com.ivanbarto.viewModelPractice.data

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.vo.RetrofitClient

/**
 *Created by ivanbarto on 24/03/21
 */
class PaginatedCharactersDataSource() : PagingSource<Int,Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {return 0}

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val pageNumber = params.key ?: 1
        return try {
            val response = RetrofitClient.webService.getCharacters(pageNumber)

            var nextPageNumber: Int? = null

            response.info.next?.let { nextURL ->
                val uri = Uri.parse(nextURL)
                val nextPageQuery = uri.getQueryParameter("page")
                nextPageNumber = nextPageQuery?.toInt()
            }

            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}