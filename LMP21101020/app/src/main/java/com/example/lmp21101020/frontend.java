package com.example.lmp21101020;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frontend extends AppCompatActivity {

    Button btnForm, btnList;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontend);

        btnForm = findViewById(R.id.button1);
        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KetikaBtnFormDiClick();
            }
        });

        btnList = findViewById(R.id.button2);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KetikaBtnListDiClick();
            }
        });
    }

    public void KetikaBtnFormDiClick(){
        Intent switchActivityIntent = new Intent(this, latihan5a.class);
        startActivity(switchActivityIntent);
    }

    public void KetikaBtnListDiClick(){
        Intent switchActivityIntent = new Intent(this, latihan6a.class);
        startActivity(switchActivityIntent);
    }
}