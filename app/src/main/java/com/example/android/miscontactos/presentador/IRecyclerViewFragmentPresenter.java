package com.example.android.miscontactos.presentador;

/**
 * Created by DOMINIC on 8/21/2017.
 */

public interface IRecyclerViewFragmentPresenter {

    public void obtenerContactosBaseDatos();

    void obtenerMediosRecientes(); //en este caso obtenemos las imagenes

    public void mostrarContactosRV();
}

