package com.fort0.moviecatalogue.utils

import android.content.Context
import com.fort0.moviecatalogue.data.source.remote.response.MovieResponse
import com.fort0.moviecatalogue.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {
    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movie.json").toString())
            val listArray = responseObject.getJSONArray("movie")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val name = movie.getString("name")
                val rating = movie.getString("rating")
                val genre = movie.getString("genre")
                val year = movie.getString("year")
                val desc = movie.getString("desc")
                val image = movie.getString("image")
                val id = movie.getString("id")

                val movieResponse = MovieResponse(name, rating, genre, year, desc, image, id)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShow.json").toString())
            val listArray = responseObject.getJSONArray("tvshow")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val name = tvshow.getString("name")
                val rating = tvshow.getString("rating")
                val genre = tvshow.getString("genre")
                val year = tvshow.getString("year")
                val desc = tvshow.getString("desc")
                val image = tvshow.getString("image")
                val id = tvshow.getString("id")

                val tvshowResponse = TvShowResponse(name, rating, genre, year, desc, image, id)
                list.add(tvshowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}