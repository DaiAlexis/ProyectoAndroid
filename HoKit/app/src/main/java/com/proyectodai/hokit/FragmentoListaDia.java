package com.proyectodai.hokit;


import android.app.Fragment;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentoListaDia extends ListFragment {

    //Clase donde estan los metodos de la bd
    InterfazBD iBD;
    //Lector que tiene los datos despues de una busqueda
    Cursor res;
    //Conexion entre datos y el fragmento - usa el cursor
    SimpleCursorAdapter sca;
    //El fragmento...
    ListView lv;
    String dato;
    public FragmentoListaDia() {
        // Required empty public constructor
    }

    //Método para cargar datos que necesitamos usar en la instanciación del fragmento.
    public static Fragment newInstance(String dia){
        Fragment fl= new FragmentoListaDia();
        Bundle arg= new Bundle();
        arg.putString("Dia",dia);
        fl.setArguments(arg);

        return fl;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        //Nombres de las columnas en la bd
        String []arregloColumnas={"materia","horaini","horafin"};
        //Textviews del renglon donde se van a guardar los datos
        int []to={R.id.tvMat,R.id.tvHin,R.id.tvHfin};
        //crear conexion con la bd
        dato=getArguments().getString("Dia");
        iBD=new InterfazBD(this.getActivity());
        //crear cursor de la bd con los resultados de la tabla
        res=iBD.traerDatos(dato);
        //Pasarle el cursor a la actividad
        //startManagingCursor(res);
        //Crear el adaptador para mostrar los datos
        sca=new SimpleCursorAdapter(
                this.getActivity(), //Actividad papa de todos
                R.layout.fragment_fragmento_lista_dia, //Formato que se repite en la lista
                res, //Cursor que tiene los datos de la consulta
                arregloColumnas, //Nombres de las columnas de la bd
                to, //Elementos destino en el layout del renglon
                0); //Este cero no hay que pelarlo
        //Pegar el adaptador a la lista
        this.setListAdapter(sca);

        return v;
    }

}
