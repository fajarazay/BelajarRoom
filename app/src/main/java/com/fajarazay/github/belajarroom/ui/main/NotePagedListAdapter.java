package com.fajarazay.github.belajarroom.ui.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.fajarazay.github.belajarroom.R;
import com.fajarazay.github.belajarroom.database.Note;
import com.fajarazay.github.belajarroom.ui.insert.NoteAddUpdateActivity;

/**
 * Created by FAJAR SEPTIAN on 2019-08-14.
 *
 * @Author Fajar Septian
 * @Email fajarajay10@gmail.com
 * @Github https://github.com/fajarazay
 */
public class NotePagedListAdapter extends PagedListAdapter<Note, NotePagedListAdapter.NoteViewHolder> {
    private static DiffUtil.ItemCallback<Note> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Note>() {
                @Override
                public boolean areItemsTheSame(Note oldNote, Note newNote) {
                    return oldNote.getTitle().equals(newNote.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(Note oldNote, @NonNull Note newNote) {
                    return oldNote.equals(newNote);
                }
            };
    private Activity activity;

    NotePagedListAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note, viewGroup, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, int position) {
        final Note note = getItem(position);
        if (note != null) {
            holder.tvTitle.setText(note.getTitle());
            holder.tvDate.setText(note.getDate());
            holder.tvDescription.setText(note.getDescription());
            holder.cvNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, holder.getAdapterPosition());
                    intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, note);
                    activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
                }
            });
        }
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvDescription, tvDate;
        final CardView cvNote;

        NoteViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvDate = itemView.findViewById(R.id.tv_item_date);
            cvNote = itemView.findViewById(R.id.cv_item_note);
        }
    }
}
