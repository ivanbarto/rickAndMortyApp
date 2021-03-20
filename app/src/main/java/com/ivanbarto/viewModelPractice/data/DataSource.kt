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
                "https://pm1.narvii.com/6545/c6c3b4cf93eb1f3e49d252db5daeaefbcb3ad446_hq.jpg",
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