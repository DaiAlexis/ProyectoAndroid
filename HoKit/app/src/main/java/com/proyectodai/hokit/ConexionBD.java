package com.proyectodai.hokit;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sdist on 04/05/2017.
 */
public class ConexionBD extends SQLiteOpenHelper{

    String cadenaCreate="create table if not exists materias(_id integer primary key autoincrement, materia text not null, horaini int not null, horafin  int not null, dias text not null)";

    public ConexionBD(Context context) {
        super(context, "mater2.db", null,1);
    }//hay que generar nueva base de datos cada que ves que se actualiza algun parametro del create table

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(cadenaCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String cadenaUpdate="drop table if exists materias";
        db.execSQL(cadenaUpdate);
        onCreate(db);
    }
}