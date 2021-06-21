package com.fort0.moviecatalogue.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fort0.moviecatalogue.data.source.local.Movies

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies")
    fun getMovies(): DataSource.Factory<Int, Movies>

    @Query("SELECT * FROM movies WHERE isFavorite=1")
    fun getFavoriteMovie(): DataSource.Factory<Int, Movies>

    @Query("SELECT * FROM movies WHERE id=:id")
    fun getMovieById(id: String): LiveData<Movies>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: Movies): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<Movies>)

    @Query("UPDATE movies SET isFavorite=:isFavorite WHERE id=:id")
    fun addMovieToFavorites(id: String, isFavorite: Boolean)
}