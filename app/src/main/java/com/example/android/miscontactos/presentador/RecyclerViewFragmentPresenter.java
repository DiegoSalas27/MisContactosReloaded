package com.example.android.miscontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.android.miscontactos.adapter.ContactoAdaptador;
import com.example.android.miscontactos.db.ConstructorContactos;
import com.example.android.miscontactos.fragments.IRecyclerViewFragmentView;
import com.example.android.miscontactos.pojo.Contactos;
import com.example.android.miscontactos.restApi.EndPointsApi;
import com.example.android.miscontactos.restApi.adapter.RestApiAdapter;
import com.example.android.miscontactos.restApi.model.ContactoResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DOMINIC on 8/21/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contactos> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactosBaseDatos() {

        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    //aqui implementamos la consulta al api de instagram (implementar retrofit)
    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserealizadorMediaRecent();
        EndPointsApi endPointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall = endPointsApi.getRecentMedia();

        //callback permite controlar los eventos que se dan en la peticion
        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso, intenta de nuevo", Toast.LENGTH_SHORT).show();
                Log.e("fallo la conexion: ", t.toString());
            }
        });

    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
