package com.example.searchbookapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.searchbookapp.data.model.Document

@Dao
interface SearchBookDao {

    // onConflict는 Insert 할 때 이미 같은 데이터가 있으면 데이터를 교체한다.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Document)

    @Delete
    suspend fun deleteBook(book: Document)

    @Query("SELECT * FROM Book")
    fun selectBooks(): LiveData<List<Document>>

}