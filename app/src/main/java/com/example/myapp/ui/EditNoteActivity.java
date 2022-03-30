package com.example.myapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.R;
import com.example.myapp.data.Note;

public class EditNoteActivity extends AppCompatActivity {

    private Note note;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        note =(Note) getIntent().getSerializableExtra(Note.NOTE);
        setContentView(R.layout.activity_edit_note);

    }

    void saveNote()
    {
        Intent result = new Intent();
        result.putExtra(Note.NOTE, note);
        setResult(RESULT_OK, result);
        finish();
    }
}
