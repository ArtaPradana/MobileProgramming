package com.example.lmp21101020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class latihan9A extends AppCompatActivity {
    Button btntambah, btnhapus, btninfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan9);
        btntambah = findViewById(R.id.btnTambah);
        btnhapus=findViewById(R.id.btnHapus);
        btninfo=findViewById(R.id.btnInfo);
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(latihan9A.this, latihan10a.class);
                startActivity(i);
            }
        });
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(latihan9A.this, latihan10b.class);
                startActivity(i);
            }
        });
        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(latihan9A.this, latihan10c.class);
                startActivity(i);
            }
        });
    }
}