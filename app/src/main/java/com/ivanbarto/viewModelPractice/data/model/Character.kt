package com.ivanbarto.viewModelPractice.data.model

import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Long?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: Origin,
    val location: Location?,
    val image: String?,
    val episode: List<String>?,
    val url: String?,
    val created: String?
) : Parcelable
