package com.fort0.moviecatalogue.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fort0.moviecatalogue.data.source.local.TvShow

@Dao
interface TvShowDao {
    @Query("SELECT * FROM tvshow")
    fun getTvShow(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM tvshow WHERE isFavorite=1")
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShow>

    @Query("SELECT * FROM tvshow WHERE id=:id")
    fun getTvShowById(id: String): LiveData<TvShow>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShows: TvShow): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShow>)

    @Query("UPDATE tvshow SET isFavorite=:isFavorite WHERE id=:id")
    fun addTvShowToFavorite(id: String, isFavorite: Boolean)
}