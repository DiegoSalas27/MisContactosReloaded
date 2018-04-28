package com.example.android.miscontactos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.miscontactos.R;
import com.example.android.miscontactos.adapter.ContactoAdaptador;
import com.example.android.miscontactos.pojo.Contactos;
import com.example.android.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.example.android.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/15/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView listaContactos;
    private ArrayList<Contactos> contactos;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        //equivale a setContentView
        //Le asignamos la clase RecycleViewFragment a fragment+recyclerview.xml
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos); //el view se convierte en objeto
        //definir de que forma mostrar el recyclerView
        //elegimos una lista
        presenter = new RecyclerViewFragmentPresenter(this, getContext());



        //GridLayoutManager glm = new GridLayoutManager(this, 2); //contexto y numero de columnas a mostrar (parametros)
        //hacemos que el recyvlerView se comporte como un linearLayout

        return v;
    }
    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<>();

        contactos.add(new Contactos("Diego Salas", "959363398", "dominicsc2hs@gmail.com", R.drawable.andorra_texture, nlikes));
        contactos.add(new Contactos("Mama", "996453562", "jesussalas27@gmail.com", R.drawable.argentina_texture, nlikes));
        contactos.add(new Contactos("Pedro Cateriano", "123456789", "AntonioConsignielri@gmail.com", R.drawable.armenia_texture, nlikes));
        contactos.add(new Contactos("Carla Magna", "987654321", "PabloMArnol@gmail.com", R.drawable.austria_texture, nlikes));
        contactos.add(new Contactos("Gian Carlo Magno", "123454986", "DominicToretto@gmail.com", R.drawable.belgium_texture, nlikes));
    }*/

    //creamos la vista
    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        listaContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contactos> contactos) {

        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {

        listaContactos.setAdapter(adaptador);
    }
}
