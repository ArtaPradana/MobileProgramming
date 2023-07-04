package com.example.lmp21101020;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class latihan13a extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    TextView edtNama, edtNim, edtProdi, edtAlamat, edtAgama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan13a);

        //========<<mendeklarasikan dbHelper >>=========
        dbHelper = new DatabaseHelper(this);

        //========<< menghubungkan variabel ke object pada XML >>=========

        edtNama = findViewById(R.id.edtNama);
        edtNim = findViewById(R.id.edtNim);
        edtProdi = findViewById(R.id.edtProdi);
        edtAlamat = findViewById(R.id.edtAlamat);
        edtAgama = findViewById(R.id.edtAgama);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datamahasiswa WHERE nim = '" +
                getIntent().getStringExtra("nim") + "'", null);
        cursor.moveToFirst();

        {
            cursor.moveToPosition(0);
            edtNama.setText(cursor.getString(0).toString());
            edtNim.setText(cursor.getString(1).toString());
            edtProdi.setText(cursor.getString(2).toString());
            edtAlamat.setText(cursor.getString(3).toString());
            edtAgama.setText(cursor.getString(4).toString());

        }
    }
}