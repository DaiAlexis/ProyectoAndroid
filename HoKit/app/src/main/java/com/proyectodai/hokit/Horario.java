package com.proyectodai.hokit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Horario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment f1 = new FragmentoLista();
        ft.add(R.id.mostrarClases, f1);
        ft.commit();

        Fragment F2 = new Dia();
        ft = fm.beginTransaction();
        ft.add(R.id.mostrarDia, F2);
        ft.commit();


    }
}
