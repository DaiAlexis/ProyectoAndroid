package com.proyectodai.hokit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

/**
 * Created by sdist on 11/05/2017.
 */

//Esta clase es la conductora entre todos los activity que se encuentran en el poryecto
    //Para ir de un activity se optó por utilizar esta clase como "conectora", es decir, un diseño por capas.
public class MyTask extends AsyncTask<Void, Void,Void> {

    ProgressDialog pd;
    Context ma1;
    Class<?> ma2;
    String dia=" "; //Esto para el intent y el bundle de la búsqueda por días


    public MyTask(Context v1, Class<?> v2, ProgressDialog pd1) {
        this.ma1=v1;
        this.ma2=v2;
        this.pd=pd1;
    }
    public MyTask(Context v1, Class<?> v2, ProgressDialog pd1, String s) {
        this.ma1=v1;
        this.ma2=v2;
        this.pd=pd1;
        dia=s;
    }

    @Override
    protected void onPreExecute() {
        pd.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        pd.dismiss();
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent inte= new Intent(ma1,ma2);
        //Este intent siempre se pasa, pero sólo se recupera en el caso en el que necesitamos una búsqueda por día.
        inte.putExtra("Dia", dia);
        ma1.startActivity(inte);
        return null;
    }
}
