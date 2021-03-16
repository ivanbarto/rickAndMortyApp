package com.ivanbarto.viewModelPractice.vo


/**
 * This sealed class returns 3 classes. Each class represents an state of the api communication
 * process, where we can get data from those states. The Backend fills this Resource with data,
 * and that data will be displayed in the UI
 */

sealed class Resource<out T> {
    class Loading<out T> : Resource<T>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val exception: Exception) : Resource<Nothing>()
}