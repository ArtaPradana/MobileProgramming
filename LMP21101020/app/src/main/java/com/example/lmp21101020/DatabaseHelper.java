package com.example.lmp21101020;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String database_name="datamahasiswa.db";
    private static final int database_version=1;

    public DatabaseHelper(Context context) {
        super(context,database_name, null, database_version);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table datamahasiswa (nama text primary key, nim text null, prodi text null, alamat text null, agama text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO datamahasiswa (nama, nim, prodi, alamat, agama) " +
                " VALUES ('I Made Arta Pradana', '21101021', 'TI-MDI', 'Badung', 'Hindu' );";
        db.execSQL(sql);
        sql = "INSERT INTO datamahasiswa (nama, nim, prodi, alamat, agama) " +
                " VALUES ('I Kadek Sidiarta', '21101201', 'TI-MDI', 'Karangasem', 'Hindu');";
        db.execSQL(sql);
        sql = "INSERT INTO datamahasiswa (nama, nim, prodi, alamat, agama) " +
                " VALUES ('I Putu Alfin Teguh Wahyudi', '21102030', 'TI-MDI', 'Tabanan', 'Hindu');";
        db.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int
            arg2) {
// TODO Auto-generated method stub
    }
}
