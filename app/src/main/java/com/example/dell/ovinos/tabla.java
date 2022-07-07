package com.example.dell.ovinos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class tabla extends SQLiteOpenHelper {
    public tabla(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ovinos(diio numeric(9) primary key,sexo text(10) not null,raza text(40) not null, edad numeric(2))");
        db.execSQL("create table control(id_visita integer primary key autoincrement, diio numeric(9)not null,fecha_visita date not null ,tratamiento text(50) not null, foreign key (diio) references ovinos(diio))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
