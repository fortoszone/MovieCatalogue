package com.fort0.moviecatalogue.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var name: String = "",
    var viewerRating: String = "",
    var genre: String = "",
    var year: String = "",
    var description: String = "",
    var image: Int = 0,
    var id: String = ""
) : Parcelable