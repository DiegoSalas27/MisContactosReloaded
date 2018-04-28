package com.example.android.miscontactos.restApi;

import com.example.android.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DOMINIC on 2/24/2018.
 */
//esta interface manejara las peticiones
public interface EndPointsApi {
    //aqui definimos los metodos que generan las peticiones para retrofit
    //call es un metodo de retrofit
    //debemos definir la peticion de la url hacia el endpoint
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia(); //getRecentMedia hace una peticion a un servidor (instagram) a traves del metodo
    //get en este caso
}
