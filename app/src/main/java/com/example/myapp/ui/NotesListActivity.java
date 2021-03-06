package com.example.myapp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.myapp.R;
import com.example.myapp.data.InMemoryRepoImp;
import com.example.myapp.data.Note;
import com.example.myapp.data.Repo;
import com.example.myapp.recytler.NotesAdapter;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.OnNoteClickListener {

    private RecyclerView list;
    private Repo repo = InMemoryRepoImp.getInstance();
    private NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);
        list = findViewById(R.id.List);
        adapter = new NotesAdapter();
        adapter.setOnNoteClickListener(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter.setNotes(repo.getAll());
        list.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));






    }

    public static final int EDIT_NOTE_REQUEST = 10;

    @Override
    public void onNoteClick(Note note) {
        Log.d("hello",note.getDescription());

        Intent editNoteIntent = new Intent(this, EditNoteActivity.class);
        editNoteIntent.putExtra(Note.NOTE,note);
        startActivityForResult(editNoteIntent, EDIT_NOTE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}