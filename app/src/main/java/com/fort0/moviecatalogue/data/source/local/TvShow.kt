package com.fort0.moviecatalogue.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshow")
data class TvShow(
    @PrimaryKey
    var name: String = "",
    var viewerRating: String = "",
    var genre: String = "",
    var year: String = "",
    var description: String = "",
    var image: String = "",
    var id: String = "",
    var isFavorite: Boolean = false
)