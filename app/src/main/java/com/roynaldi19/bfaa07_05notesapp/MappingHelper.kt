package com.roynaldi19.bfaa07_05notesapp

import android.database.Cursor
import com.roynaldi19.bfaa07_05notesapp.db.DatabaseContract
import com.roynaldi19.bfaa07_05notesapp.model.Note

object MappingHelper {

    fun mapCursorToArrayList(noteCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()

        noteCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                notesList.add(Note(id, title, description, date))
            }
        }
        return notesList
    }
}