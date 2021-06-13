package com.fort0.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var name: String,
    var viewerRating: String,
    var genre: String,
    var year: String,
    var description: String,
    var image: String,
    var id: String
) : Parcelable
