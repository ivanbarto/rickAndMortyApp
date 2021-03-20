package com.ivanbarto.viewModelPractice.domain

import com.ivanbarto.viewModelPractice.data.DataSource
import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.Episode
import com.ivanbarto.viewModelPractice.data.model.Location
import com.ivanbarto.viewModelPractice.vo.Resource

/**
 *  An implementation of Repo which goes to the Datasource in search for Information. Note that
 *  this class knows where fetch data, but it doesn't know where dispatch it.
 */

class CharacterRepo (private val dataSource: DataSource) : Repo.Characters {
    override fun getCharacters(): Resource<List<Character>> {
        return dataSource.getCharacters()

    }

    override fun getCharactersByName(name: String): Resource<List<Character>> {
        TODO("Not yet implemented")
    }


}