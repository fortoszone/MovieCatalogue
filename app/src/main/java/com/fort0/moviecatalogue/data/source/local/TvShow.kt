package com.fort0.moviecatalogue.data.source.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class TvShow(
    var name: String = "",
    var viewerRating: String = "",
    var genre: String = "",
    var year: String = "",
    var description: String = "",
    var image: String = "",
    var id: String = ""
)