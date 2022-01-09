package edu.ewubd.notegram.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import edu.ewubd.notegram.dbhelpers.DateConverter;

@Entity
public class NoteEntity {
    @PrimaryKey(autoGenerate = true)
    public int Id;

    @ColumnInfo(name = "CreatedDate")
    @TypeConverters(DateConverter.class)
    public Date CreatedDate;

    @ColumnInfo(name = "Content")
    public String Content;
}