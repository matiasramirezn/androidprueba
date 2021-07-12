package com.csto.evaluacion1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static String nombre_bd = "ciudades";
    public static int version_bd = 1;

    public static String tabla_ciudades ="create table ciudades_chile (id_ciudad integer primary key autoincrement,"+
        "nombre_ciudad text, region integer)";

    public DbHelper(@Nullable Context context) {
        super(context, nombre_bd, null, version_bd);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla_ciudades);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists ciudades_chile");
        db.execSQL(tabla_ciudades);
    }
}
