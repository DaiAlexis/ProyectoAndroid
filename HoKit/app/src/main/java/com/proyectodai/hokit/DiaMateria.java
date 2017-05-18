package com.proyectodai.hokit;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class DiaMateria extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_materia);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Intent intent= getIntent();
        Bundle b = intent.getExtras();
        String dia = b.getString("Dia");

//Otra forma de instanciar un fragmento para utilizar variables externas
        Fragment f1 = FragmentoListaDia.newInstance(dia);
        ft.add(R.id.mostrarClasesPorDia, f1);
        ft.commit();
    }
}
