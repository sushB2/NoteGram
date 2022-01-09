package edu.ewubd.notegram.dbhelpers;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.ewubd.notegram.entities.NoteEntity;

@Dao
public interface NoteDAO {
    @Query("SELECT Id, CreatedDate, Content FROM NoteEntity ORDER BY Id DESC")
    List<NoteEntity> GetAll();

    @Query("SELECT Id, CreatedDate, Content FROM NoteEntity WHERE Id = :paramId")
    NoteEntity GetSingleNote(int paramId);

    @Insert
    void InsertNote(NoteEntity note);

    @Update
    void UpdateNote(NoteEntity note);

    @Delete
    void DeleteNote(NoteEntity note);
}