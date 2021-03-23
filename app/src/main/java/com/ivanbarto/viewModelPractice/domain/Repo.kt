package com.ivanbarto.viewModelPractice.domain

import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.Episode
import com.ivanbarto.viewModelPractice.data.model.GenericResponse
import com.ivanbarto.viewModelPractice.data.model.Location
import com.ivanbarto.viewModelPractice.vo.Resource

class Repo {

    interface Characters{
        /**
         * This interface is an abstraction which represents an entity who goes to the place where
         * we need to get the data. Note that each get returns a Resource type object. For more info,
         * see Resource Class.
         */
        suspend fun getCharacters() : Resource<GenericResponse<Character>> //TODO add filters
        fun getCharactersByName(name : String) : Resource<List<Character>>
    }

    interface Locations{
        fun getLocations() : Resource<List<Location>> //TODO add filters
        fun getLocationsByName(name : String) : Resource<List<Location>>
    }

    interface Episodes{
        fun getEpisodes() : Resource<List<Episode>>//TODO add filters
        fun getEpisodesByName(name: String) : Resource<List<Episode>>
    }



}