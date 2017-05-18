package com.proyectodai.hokit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DiaSemana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_semana);
    }

    public void regresarBtn(View v) {
        Intent inte= new Intent(this,Inicio.class);
        this.startActivity(inte);
    }
    private void cambio(View v,String s){
        ProgressDialog pd =  new ProgressDialog(this);
        pd.setMessage("Cargando con " + s);
        new MyTask(this,DiaMateria.class,pd,s).execute();
    }
    public void lunesBtn(View v){
        cambio(v,"LU");
    }
    public void martesBtn(View v){
        cambio(v,"MA");
    }
    public void miercolesBtn(View v){
        cambio(v,"MI");
    }
    public void juevesBtn(View v){
        cambio(v,"JU");
    }
    public void viernesBtn(View v){
        cambio(v,"VI");
    }
}
