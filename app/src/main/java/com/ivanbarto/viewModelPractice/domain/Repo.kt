package com.ivanbarto.viewModelPractice.domain

import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.Episode
import com.ivanbarto.viewModelPractice.data.model.Location
import com.ivanbarto.viewModelPractice.vo.Resource

interface Repo {

    /**
     * This interface is an abstraction which represents an entity who goes to the place where
     * we need to get the data. Note that each get returns a Resource type object. For more info,
     * see Resource Class.
     */

    fun getCharacters() : Resource<List<Character>> //TODO add filters
    fun getCharactersByName(name : String) : Resource<List<Character>>


    fun getLocations() : Resource<List<Location>> //TODO add filters
    fun getLocationsByName(name : String) : Resource<List<Location>>

    fun getEpisodes() : Resource<List<Episode>>//TODO add filters
    fun getEpisodesByName(name: String) : Resource<List<Episode>>
}