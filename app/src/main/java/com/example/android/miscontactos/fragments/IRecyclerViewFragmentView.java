package com.example.android.miscontactos.fragments;

import com.example.android.miscontactos.adapter.ContactoAdaptador;
import com.example.android.miscontactos.pojo.Contactos;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/21/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical(); //En este metodo se implementa la forma en como se muestra nuestro RV

    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contactos> contactos); //inicializa el adaptador recibiendo la lista de contactos

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador); //pasamos el adaptador al RV
}
