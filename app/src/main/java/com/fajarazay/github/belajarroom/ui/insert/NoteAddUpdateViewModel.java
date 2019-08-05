package com.fajarazay.github.belajarroom.ui.insert;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.fajarazay.github.belajarroom.database.Note;
import com.fajarazay.github.belajarroom.repository.NoteRepository;

/**
 * Created by FAJAR SEPTIAN on 2019-08-05.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
public class NoteAddUpdateViewModel extends ViewModel {
    private NoteRepository mNoteRepository;

    public NoteAddUpdateViewModel(Application application) {
        mNoteRepository = new NoteRepository(application);
    }

    public void insert(Note note) {
        mNoteRepository.insert(note);
    }

    public void update(Note note) {
        mNoteRepository.update(note);
    }

    public void delete(Note note) {
        mNoteRepository.delete(note);
    }
}
