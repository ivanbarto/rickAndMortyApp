package com.ivanbarto.viewModelPractice.data.model

data class GenericResponse<Any>(
    val info:Info,
    val results: List <Any>
)
