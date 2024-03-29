package com.fajarazay.github.belajarroom.ui.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fajarazay.github.belajarroom.database.Note;
import com.fajarazay.github.belajarroom.repository.NoteRepository;

import java.util.List;

/**
 * Created by FAJAR SEPTIAN on 2019-08-05.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
public class MainViewModel extends ViewModel {
    private NoteRepository mNoteRepository;

    public MainViewModel(Application application) {
        mNoteRepository = new NoteRepository(application);
    }

    LiveData<List<Note>> getAllNotes() {
        return mNoteRepository.getAllNotes();
    }
}
