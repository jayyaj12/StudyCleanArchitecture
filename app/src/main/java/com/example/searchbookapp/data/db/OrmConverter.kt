package com.example.searchbookapp.data.db

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// Room Db는 프리미티한 타입(기본형) 만 지원이 되기 떄문에 list를 String 으로 변환해주는 컨버터를 사용한다.
class OrmConverter {
    @TypeConverter
    fun fromList(value: List<String>) = Json.encodeToString(value)


    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<String>>(value)
}