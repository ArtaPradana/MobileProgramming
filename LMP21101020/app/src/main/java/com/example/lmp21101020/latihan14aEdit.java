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

import org.w3c.dom.Text;

public class latihan14aEdit extends AppCompatActivity {

    DatabaseHelper dbHelper;
    Button btnSimpan;
    EditText editNama, editNim, editProdi, editAlamat, editAgama;
    String sql;
    @SuppressLint("MissingInflatedId")
    protected Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan14a_edit);
        dbHelper = new DatabaseHelper(this);
        btnSimpan = findViewById(R.id.btnSimpan);
        editNama = findViewById(R. id.editNama);
        editNim = findViewById(R.id.editNim);
        editProdi = findViewById(R.id.editProdi);
        editAlamat = findViewById(R.id.editAlamat);
        editAgama=findViewById(R.id.editAgama);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datamahasiswa WHERE nim = '" +
                getIntent().getStringExtra("nim") + "'", null);
        cursor.moveToFirst();
        {
            cursor.moveToPosition(0);
            editNama.setText(cursor.getString(0).toString());
            editNim.setText(cursor.getString(1).toString());
            editProdi.setText(cursor.getString(2).toString());
            editAlamat.setText(cursor.getString(3).toString());
            editAgama.setText(cursor.getString(4).toString());
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                sql = "UPDATE datamahasiswa SET nim='"+ editNim.getText().toString() +
                        "', nama='"+ editNama.getText().toString() +
                        "', prodi='"+ editProdi.getText().toString() +
                        "', alamat='"+ editAlamat.getText().toString() +
                        "', agama='"+ editAgama.getText().toString() +
                        "' WHERE nim='"+ editNim.getText().toString() +"'";
                db.execSQL(sql);

                Toast.makeText(getApplicationContext(),
                        "Edit Data Berhasil", Toast.LENGTH_LONG).show();
                finish();

                Intent i = new Intent(latihan14aEdit.this, latihan9A.class);
                startActivity(i);
            }
        });
    }
}