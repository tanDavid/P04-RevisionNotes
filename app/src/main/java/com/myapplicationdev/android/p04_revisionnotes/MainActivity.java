package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etNote;
    RadioGroup rgStars;
    RadioButton rb;
    Button btnInsert, btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNote = findViewById(R.id.editTextNote);
        rgStars = findViewById(R.id.radioGroupStars);
        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = (RadioButton) findViewById(rgStars.getCheckedRadioButtonId());
                DBHelper db = new DBHelper(MainActivity.this);
                if (Integer.valueOf(rb.getText().toString()) > 0 && !etNote.getText().toString().isEmpty()) {
                    db.insertNote(etNote.getText().toString(), Integer.valueOf(rb.getText().toString()));
                } else {
                    Toast.makeText(MainActivity.this, "Failed to insert due to empty value entries", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });



    }

}
