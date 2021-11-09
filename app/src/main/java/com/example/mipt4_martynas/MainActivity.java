package com.example.mipt4_martynas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);

        Button createNote = findViewById(R.id.buttonAddNote);

        createNote.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.buttonAddNote) {
            Intent addNote = new Intent(this, AddNoteActivity.class);
            startActivity(addNote);
        }
    }

}