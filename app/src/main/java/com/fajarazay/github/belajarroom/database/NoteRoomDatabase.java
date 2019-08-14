package com.fajarazay.github.belajarroom.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by FAJAR SEPTIAN on 2019-08-05.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
@Database(entities = {Note.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    private static volatile NoteRoomDatabase INSTANCE;

    public static NoteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class, "note_database")
                            .build();
                    add();
                }
            }
        }
        return INSTANCE;
    }

    public abstract NoteDao noteDao();

    //generate dummy data
    private static void add() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                final List<Note> list = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    list.add(new Note("Tugas " + i, "Belajar Modul " + i, ""));
                }
                INSTANCE.noteDao().insertAll(list);
            }
        });
    }
}