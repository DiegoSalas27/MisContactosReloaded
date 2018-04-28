package com.example.android.miscontactos.db;

/**
 * Created by DOMINIC on 8/21/2017.
 */

//una clase final jamas puede ser modificado sus datos clase constante (solo se puede accesar a los datos)
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "contactos"; //nombre de la base de datos (constante)
    public static final int DATABASE_VERSION = 1; //version de la base de datos

    //variables globales
    public static final String TABLE_CONTACTS = "contacto";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NOMBRE = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO = "telefono";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_FOTO = "foto";

    public static final String TABLE_LIKES_CONTACT = "contacto_likes"; //nombre de la tabla y sus campos
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
