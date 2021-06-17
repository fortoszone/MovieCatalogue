package com.fort0.moviecatalogue.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fort0.moviecatalogue.data.source.local.Movies
import com.fort0.moviecatalogue.data.source.local.TvShow

@Database(
    entities = [Movies::class, TvShow::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app.db"
                ).build().apply {
                    INSTANCE = this
                }
            }
    }
}
