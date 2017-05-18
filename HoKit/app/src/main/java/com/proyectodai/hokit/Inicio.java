package com.proyectodai.hokit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }
    public void horarioBtn(View v){
        ProgressDialog pd =  new ProgressDialog(this);
        pd.setMessage("Cargando");
        new MyTask(this,Horario.class,pd).execute();
    }

    public void investigarBtn(View v){
        ProgressDialog pd =  new ProgressDialog(this);
        pd.setMessage("Cargando");
        new MyTask(this,Investigar.class,pd).execute();
    }
    public void diaSemanaBtn(View v){
        ProgressDialog pd =  new ProgressDialog(this);
        pd.setMessage("Cargando");
        new MyTask(this,DiaSemana.class,pd).execute();
    }
}
