package com.ivanbarto.viewModelPractice.domain

import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.GenericResponse
import com.ivanbarto.viewModelPractice.utils.constants.Urls
import retrofit2.http.GET

/**
 *Created by ivanbarto on 23/03/21
 */
interface WebService {
    /**
     * Interface that is used by retrofit client to do different http calls to a WS.
     * We will use coroutines to create this WebService interface
     */

    @GET(Urls.GET_CHARACTERS)
    suspend fun getCharacters(): GenericResponse<Character>
}