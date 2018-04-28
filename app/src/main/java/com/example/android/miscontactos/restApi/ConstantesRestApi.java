package com.example.android.miscontactos.restApi;

/**
 * Created by DOMINIC on 2/24/2018.
 */
//maneja direcciones, base, version del api de instagram, token de acceso, etc
//final porque son puras constantes
//con static pueden ser accesadas por otra clase
public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "5875975293.3ebf831.8d5f725bfe634b7ebe729c54de66f9cb";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
}
