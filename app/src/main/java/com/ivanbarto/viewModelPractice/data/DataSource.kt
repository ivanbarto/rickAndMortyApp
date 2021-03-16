package com.ivanbarto.viewModelPractice.data

import com.ivanbarto.viewModelPractice.data.model.Character
import com.ivanbarto.viewModelPractice.data.model.Location
import com.ivanbarto.viewModelPractice.data.model.Origin
import com.ivanbarto.viewModelPractice.vo.Resource

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

    fun getCharacters(): Resource<List<Character>> {
        val characters = listOf<Character>(
            Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "",
                "Male",
                Origin("Earth", "url.com"),
                Location(1, "Earth", "", "C-137", listOf("1", "2", "3"), "url.com", "23/2/2323"),
                "https://pm1.narvii.com/6241/f89c0a99a38fad53cf350d3187cc810e17e348ee_hq.jpg",
                listOf("1", "2", "3", "4"),
                "anurl.com",
                "23/1/2020"
            ),
            Character(
                1,
                "Morty Smith",
                "Alive",
                "Human",
                "",
                "Male",
                Origin("Earth", "url.com"),
                Location(1, "Earth", "", "C-137", listOf("1", "2", "3"), "url.com", "23/2/2323"),
                "https://i0.wp.com/www.korosenai.es/wp-content/uploads/2018/02/morty-smith.jpg?w=628",
                listOf("1", "2", "3", "4"),
                "anurl.com",
                "23/1/2020"
            ),
            Character(
                1,
                "Beth Sanchez",
                "Alive",
                "Human",
                "",
                "Male",
                Origin("Earth", "url.com"),
                Location(1, "Earth", "", "C-137", listOf("1", "2", "3"), "url.com", "23/2/2323"),
                "https://static.wikia.nocookie.net/rickandmorty/images/5/58/Beth_Smith.png/revision/latest?cb=20191122063320",
                listOf("1", "2", "3", "4"),
                "anurl.com",
                "23/1/2020"
            ),
            Character(
                1,
                "Jerry Smith",
                "Alive",
                "Human",
                "",
                "Male",
                Origin("Earth", "url.com"),
                Location(1, "Earth", "", "C-137", listOf("1", "2", "3"), "url.com", "23/2/2323"),
                "data:image/jpeg;base64,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",
                listOf("1", "2", "3", "4"),
                "anurl.com",
                "23/1/2020"
            ),
            Character(
                1,
                "Summer Smith",
                "Alive",
                "Human",
                "",
                "Male",
                Origin("Earth", "url.com"),
                Location(1, "Earth", "", "C-137", listOf("1", "2", "3"), "url.com", "23/2/2323"),
                "https://cdn.costumewall.com/wp-content/uploads/2017/10/summer-smith.jpg",
                listOf("1", "2", "3", "4"),
                "anurl.com",
                "23/1/2020"
            )
        )
        return Resource.Success(data = characters)
    }

}