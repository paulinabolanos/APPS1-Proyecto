package com.example.bisonapp40;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBSQLite extends SQLiteOpenHelper {
    public static final String nombreBD = "bisonapp";
    public static final int versionBD = 1;

    private static final String tablaUsuarios = "create table usuarios(noControl text primary key ,nombre text, apellido text, password text)";
    private static final String tablaActividades = "create table actividades(noControl text primary key, nombreT text, actividad text, " +
            "materia text, descripcion text, dia text, mes text, ano text, hora text)";

    public DBSQLite(Context context) {
        super(context, nombreBD, null, versionBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tablaUsuarios);
        db.execSQL(tablaActividades);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usuarios");
        db.execSQL(tablaUsuarios);
        db.execSQL("drop table if exists actividades");
        db.execSQL(tablaActividades);
    }

    public void agregarUsuario (String noControl, String nombre, String apellido, String password){
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            db.execSQL("insert into usuarios values('"+ noControl + "','" + nombre + "','" + apellido + "','" + password + "')");
            db.close();
        }
    }

    public int login (String noControl, String password){
        SQLiteDatabase db = getReadableDatabase();
        int i = 0;
        Cursor cursor = db.rawQuery("select * from usuarios", null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                if(cursor.getString(0).equals(noControl) && cursor.getString(3).equals(password)){
                    i++;
                }
            }while(cursor.moveToNext());
        }
        return i;
    }



    public void agregarActividad (String noControl, String nombreT, String actividad, String materia, String descripcion, String dia, String mes,
                                  String ano, String hora){
        SQLiteDatabase db = getWritableDatabase();

        if(db != null){
            db.execSQL("insert into actividades values('"+ noControl + "','" + nombreT + "','" + actividad + "','" + materia + "','" +
                    descripcion + "','" + dia + "','" + mes + "','" + ano + "','" + hora  + "')");
            db.close();
        }
    }

    public List<ActividadesModelo> mostrarActividades(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from actividades", null);
        List<ActividadesModelo> actividades = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                actividades.add(new ActividadesModelo(cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7), cursor.getString(8)));
            }while(cursor.moveToNext());
        }
        return actividades;
    }

}
