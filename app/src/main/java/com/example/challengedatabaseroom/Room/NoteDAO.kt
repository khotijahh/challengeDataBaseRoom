package com.example.challengedatabaseroom.Room

import androidx.room.*

@Dao
interface NoteDAO {
     @Insert
      fun addNote (note: Note)

     @Update
      fun updateNote (note: Note)

     @Delete
      fun deleteNote(note: Note)

     @Query("SELECT * FROM Note")
      fun getNotes():List<Note>

    @Query("SELECT * FROM Note Where id=:note_id")
    fun getNote(note_id: Int):List<Note>
}