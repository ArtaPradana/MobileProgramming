package com.example.lmp21101020;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class latihan10a extends AppCompatActivity {
    protected Cursor cursor;

    DatabaseHelper dbHelper;
    Button btnSimpan;
    EditText editNama, editNim, editProdi, editAlamat, editAgama;
    String sqlText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan10a);

        //====<<mendeklarasikan dbHelper>>====
        dbHelper = new DatabaseHelper(this);
        //====<<Menghubungkan variabel ke object pada XML>>===
        btnSimpan = findViewById(R.id.btnSimpan);
        editNama = findViewById(R.id.editNama);
        editNim = findViewById(R.id.editNim);
        editProdi = findViewById(R.id.editProdi);
        editAlamat = findViewById(R.id.editAlamat);
        editAgama = findViewById(R.id.editAgama);

        generateAndDisplayID(); // Memanggil metode untuk menghasilkan dan menampilkan NIM

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                sqlText = "INSERT INTO datamahasiswa (nama, nim, prodi, alamat, agama) " + " VALUES ('" +
                        editNama.getText().toString() + "','" +
                        editNim.getText().toString() + "','" +
                        editProdi.getText().toString() + "','" +
                        editAlamat.getText().toString() + "','" +
                        editAgama.getText().toString() + "');";
                db.execSQL(sqlText);

                Toast.makeText(getApplicationContext(), "Data Tersimpan...", Toast.LENGTH_SHORT).show();
                finish();

                Intent i = new Intent(latihan10a.this, latihan9A.class);
                startActivity(i);
            }
        });
    }

    private void generateAndDisplayID() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT MAX(nim) FROM datamahasiswa";
        cursor = db.rawQuery(query, null);

        int nextID;
        if (cursor != null && cursor.moveToFirst()) {
            int maxID = cursor.getInt(0);
            nextID = maxID + 1;
        } else {
            nextID = 1;
        }

        String formattedID = String.format("%08d", nextID); // Format ID with leading zeros
        editNim.setText(formattedID);
    }
}
