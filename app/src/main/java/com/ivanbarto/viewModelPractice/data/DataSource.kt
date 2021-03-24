package com.ivanbarto.viewModelPractice.data

import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.GenericResponse
import com.ivanbarto.viewModelPractice.vo.Resource
import com.ivanbarto.viewModelPractice.vo.RetrofitClient

/**
 * Class which provides fetch data. DataSource can be an intermediary which connects the app
 * with a local or remotes Database. This also formats data to appropriate or desired format.
 *
 * This class is completely decoupled because it doesn't know who uses it.
 */

class DataSource {

    /**
     * Here we do different API REST calls
     */


    suspend fun getCharacters(): Resource<GenericResponse<Character>> {
        /**
         * note that we return an Resource.Success, and we pass the type that the ws returns
         */
        return Resource.Success(RetrofitClient.webService.getCharacters(1) )
    }

}