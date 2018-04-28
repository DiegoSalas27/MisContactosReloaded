package com.example.android.miscontactos.restApi.adapter;

import com.example.android.miscontactos.restApi.ConstantesRestApi;
import com.example.android.miscontactos.restApi.EndPointsApi;
import com.example.android.miscontactos.restApi.deserealizador.ContactoDeserealizador;
import com.example.android.miscontactos.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by DOMINIC on 2/25/2018.
 */

public class RestApiAdapter {

    //devolvemos un objeto de tipo endpoint
    public EndPointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)) //aqui se desealiza el Json (se traen los datos de cada arreglo)
                .build();

        return retrofit.create(EndPointsApi.class);
    }

    public Gson construyeGsonDeserealizadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder(); //asocia que todito lo que deserealize del json se asocie al objeto contactoresponse
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserealizador());
        return gsonBuilder.create();
    }
}
