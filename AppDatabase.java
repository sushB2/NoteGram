package edu.ewubd.notegram.dbhelpers;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.ewubd.notegram.entities.NoteEntity;

@Database(entities = {NoteEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract edu.ewubd.notegram.dbhelpers.NoteDAO noteDAO();

}