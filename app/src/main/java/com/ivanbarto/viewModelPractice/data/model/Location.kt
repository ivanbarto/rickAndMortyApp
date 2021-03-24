package com.ivanbarto.viewModelPractice.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val id: Long?,
    val name: String?,
    val type: String?,
    val dimension: String?,
    val residents: List<String>?,
    val url: String?,
    val created: String?
) : Parcelable