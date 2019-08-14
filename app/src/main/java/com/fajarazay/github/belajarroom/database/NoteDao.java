package com.fajarazay.github.belajarroom.database;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by FAJAR SEPTIAN on 2019-08-05.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    @Update()
    void update(Note note);

    @Delete()
    void delete(Note note);

    @Query("SELECT * from note ORDER BY id ASC")
    DataSource.Factory<Integer, Note> getAllNotes();

    //Untuk menambahkan data dummy, tambahkan kode untuk insertAll ke dalam kelas NoteDao
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Note> list);
}
