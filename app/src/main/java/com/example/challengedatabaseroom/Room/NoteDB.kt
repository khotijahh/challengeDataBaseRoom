package com.example.challengedatabaseroom.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB : RoomDatabase(){

    abstract fun NoteDAO() : NoteDAO

    companion object {

        @Volatile private var instance : NoteDB? = null
        private val LOCK = Any()


           operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
               instance ?: buildDatabase(context).also {
                   instance = it
               }
           }

           private fun buildDatabase(context: Context) = Room.databaseBuilder(
               context.applicationContext,
               NoteDB::class.java,
               "note12345.db"
           ).build()
    }
}
