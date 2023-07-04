package com.example.lmp21101020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class latihan6a extends AppCompatActivity {
    ImageView gbrjerapah, gbrgajah, gbrtupai,gbrkudanil ,gbronta, gbrzebra, gbrburung, gbrharimau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan6a);

        //menghubungkan objek yang ada di XML dan java
        gbrjerapah = findViewById(R.id.jerapah);
        gbrgajah = findViewById(R.id.gajah);
        gbrtupai = findViewById(R.id.tupai);
        gbrkudanil = findViewById(R.id.kudanil);
        gbronta = findViewById(R.id.onta);
        gbrzebra = findViewById(R.id.zebra);
        gbrburung = findViewById(R.id.burung);
        gbrharimau = findViewById(R.id.harimau);

        //berikan perintah ketika gambar di klik
        gbrjerapah.setOnClickListener(view -> ketikaJerapahDiPilih());
        gbrgajah.setOnClickListener(view -> ketikaGajahDiPilih());
        gbrtupai.setOnClickListener(view -> ketikaTupaiDiPilih());
        gbrkudanil.setOnClickListener(view -> ketikaKudanilDiPilih());
        gbronta.setOnClickListener(view -> ketikaOntaDiPilih());
        gbrzebra.setOnClickListener(view -> ketikaZebraDiPilih());
        gbrburung.setOnClickListener(view -> ketikaBurungDiPilih());
        gbrharimau.setOnClickListener(view -> ketikaHarimauDiPilih());

    }

    private void ketikaJerapahDiPilih() {
        Intent IntentJerapah = new Intent(this,latihan6b.class);
        startActivity((IntentJerapah));
    }

    private void ketikaGajahDiPilih() {
        Intent IntentGajah = new Intent(this,latihan6c.class);
        startActivity((IntentGajah));
    }

    private void ketikaTupaiDiPilih() {
        Intent IntentTupai = new Intent(this,latihan6d.class);
        startActivity((IntentTupai));
    }

    private void ketikaKudanilDiPilih() {
        Intent IntentKudanil = new Intent(this,latihan6e.class);
        startActivity((IntentKudanil));
    }

    private void ketikaOntaDiPilih() {
        Intent IntentOnta = new Intent(this,latihan6f.class);
        startActivity((IntentOnta));
    }

    private void ketikaZebraDiPilih() {
        Intent IntentZebra = new Intent(this,latihan6g.class);
        startActivity((IntentZebra));
    }
    private void ketikaBurungDiPilih() {
        Intent IntentBurung = new Intent(this,latihan6h.class);
        startActivity((IntentBurung));
    }
    private void ketikaHarimauDiPilih() {
        Intent IntentHarimau = new Intent(this,latihan6j.class);
        startActivity((IntentHarimau));
    }

}