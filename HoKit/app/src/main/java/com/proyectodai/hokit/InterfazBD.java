package com.proyectodai.hokit;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

/**
 * Created by sdist on 04/05/2017.
 */
public class InterfazBD {

    ConexionBD con;
    SQLiteDatabase db;

    public InterfazBD (Context context){
        con = new ConexionBD(context);
    }

    public void open()throws SQLiteException{
        db= con.getWritableDatabase();
    }

    public void close() throws SQLiteException{
        con.close();
    }

    public long insertarDatos(String mat, int hi,int hf,String di){
        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("materia",mat);
        valores.put("horaini",hi);
        valores.put("horafin",hf);
        valores.put("dias",di);

        long clave = db.insert("materias",null,valores);
        close();
        return clave;
    }

    public void insertarDatosPrueba(){

        ContentValues valores;
        open();
        valores = new ContentValues();
        valores.put("materia","Materia");
        valores.put("horaini",10);
        valores.put("horafin",12);
        valores.put("dias", "LUMIVI");
        db.insert("materias",null, valores);

    }

    public String traerDato (long clave){
        open();
        String claveString =  Long.toString(clave);
        String query= "select * from materias where _id="+ claveString+";";
        Cursor c = db.rawQuery(query,null);
        c.moveToNext();
        String res= c.getString(1);
        c.close();
        close();
        return res;
    }

    public Cursor traerDatos(){
        Cursor res = null;
        open();
        String query = "select * from materias";
        res= db.rawQuery(query,null);
        if(res.getCount()==0){
            insertarDatosPrueba();
            res=db.rawQuery(query, null);
        }
        return res;
    }


    //Esta búsqueda es para la ventana que muestra solo las materias por día.
    public Cursor traerDatos(String dia) {
        Cursor res = null;
        open();
        String query = "select * from materias where dias like '%"+dia+"%'" ;
        res = db.rawQuery(query, null);
        if (res.getCount() == 0) {
            insertarDatosPrueba();
            res = db.rawQuery(query, null);
        }
        return res;
    }

//8426793082

}