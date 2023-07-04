package com.example.lmp21101020;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class latihan10b extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    //    Menu menu;
    protected Cursor cursor;
    DatabaseHelper dbcenter;
    public static latihan10b da;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan10b);
        da = this;
        dbcenter = new DatabaseHelper(this);
        RefreshList();
    }
    public void RefreshList() {
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM datamahasiswa", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = findViewById(R.id.ListViewData);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String Selection=daftar[i];
                final CharSequence[] dialogitem={"Lihat Data", "Update Data", "Hapus Data"};
                AlertDialog.Builder builder = new AlertDialog.Builder(latihan10b.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(),
                                        latihan13a.class);
                                i.putExtra("nim", Selection);
                                startActivity(i);
                                break;

                            case 1:
                                Intent j = new Intent(getApplicationContext(),
                                        latihan14aEdit.class);
                                j.putExtra("nim",Selection);
                                startActivity(j);
                                break;

                            case 2:
                                SQLiteDatabase db =
                                        dbcenter.getWritableDatabase();
                                String sql="delete from datamahasiswa where nim = '" + Selection + "'";
                                db.execSQL(sql);
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
    }
}
