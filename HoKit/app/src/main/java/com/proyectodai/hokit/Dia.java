package com.proyectodai.hokit;



import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.FragmentManager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Dia extends android.app.Fragment {

    Button agregar;
    EditText materia,horai,horaf,dias;
    InterfazBD iBD;
    FragmentManager fm;
    public Dia() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_dia, container, false);
        agregar = (Button) v.findViewById(R.id.botonAgregar);
        materia=(EditText) v.findViewById(R.id.datoMateria);
        horai=(EditText) v.findViewById(R.id.datoHoraI);
        horaf=(EditText) v.findViewById(R.id.datoHoraF);
        dias=(EditText) v.findViewById(R.id.dias);

        fm = this.getActivity().getFragmentManager();


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mat=materia.getText().toString(),dia=dias.getText().toString();

                int hi= Integer.parseInt(horai.getText().toString()), hf=Integer.parseInt(horaf.getText().toString());
                //Instanciar objeto para conexion a bd
                iBD=new InterfazBD(v.getContext());
                //Insertar dato en la bd - ver el codigo de insertarDatos en la clase
                //InterfazBD
                long clave=iBD.insertarDatos(mat,hi,hf,dia);
                //Mostrar la llave primaria en un toast
                Toast.makeText(v.getContext(),"Llave: "+clave,Toast.LENGTH_SHORT).show();
                FragmentTransaction ft=fm.beginTransaction();
                android.app.Fragment fl=new FragmentoLista();
                ft.replace(R.id.mostrarClases,fl);
                ft.commit();
            }
        });
        /*
        agregar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String s=dato.getText().toString();
                //Instanciar objeto para conexion a bd
                iBD=new InterfazBD(v.getContext());
                //Insertar dato en la bd - ver el codigo de insertarDatos en la clase
                //InterfazBD
                long clave=iBD.insertarDatos(s);
                //Mostrar la llave primaria en un toast
                Toast.makeText(v.getContext(),"Llave: "+clave,Toast.LENGTH_SHORT).show();
                FragmentTransaction ft=fm.beginTransaction();
                android.app.Fragment fl=new FragmentoLista();
                ft.replace(R.id.actividadPrincipal,fl);
                ft.commit();
            }
        });*/


        return v;
    }

}