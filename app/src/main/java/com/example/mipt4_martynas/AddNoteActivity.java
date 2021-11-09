package com.example.mipt4_martynas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    boolean isFocused = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        EditText noteName = findViewById(R.id.editTextNoteName), noteText = findViewById(R.id.editTextNoteText);
        Button saveNote = findViewById(R.id.buttonConfirm);

        noteName.setOnFocusChangeListener(focusListener);
        noteText.setOnFocusChangeListener(focusListener);
        saveNote.setOnClickListener(this);

    }


    private View.OnFocusChangeListener focusListener = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean hasFocus) {
            if (hasFocus) {
                isFocused = true;
                findViewById(R.id.buttonConfirm).setEnabled(true);
            }
            else {
                isFocused = false;
            }
        }
    };

    public void onClick(View v) {
        EditText noteName = findViewById(R.id.editTextNoteName), noteText = findViewById(R.id.editTextNoteText);
        Button saveNote = findViewById(R.id.buttonConfirm);

        if (v.getId() == R.id.buttonConfirm) {
            noteName.setEnabled(false);
            noteText.setEnabled(false);
            noteName.setEnabled(true);
            noteText.setEnabled(true);
            noteName.setHintTextColor(Color.parseColor("#989898"));
            if (noteText.getText().toString().trim().isEmpty()) {
                saveNote.setEnabled(false);
                noteName.setHintTextColor(Color.RED);
            }
            else {
                Intent submitNote = new Intent(this, MainActivity.class);
                startActivity(submitNote);
            }
        }
    }
}

