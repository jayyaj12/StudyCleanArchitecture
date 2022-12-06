package com.example.searchbookapp.data.db

import android.content.Context
import androidx.room.*
import com.example.searchbookapp.data.model.Document

@Database(
    entities = [Document::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(OrmConverter::class)
abstract class SearchBookDatabase : RoomDatabase() {

    abstract fun bookSearchDao(): SearchBookDao

    companion object {
        private var instance: SearchBookDatabase? = null

        private fun buildDatabase(context: Context): SearchBookDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                SearchBookDatabase::class.java,
                "book"
            ).build()

        fun getInstance(context: Context): SearchBookDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
    }

}