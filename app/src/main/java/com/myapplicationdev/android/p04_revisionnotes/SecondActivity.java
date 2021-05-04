package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayList<Note> aa;
	RevisionNotesArrayAdapter al;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView
		lv = (ListView) findViewById(R.id.lv);

		DBHelper db = new DBHelper(SecondActivity.this);
		aa = db.getAllNotes();
		al = new RevisionNotesArrayAdapter(this, R.layout.row, aa);
		lv.setAdapter(al);
	}
}
