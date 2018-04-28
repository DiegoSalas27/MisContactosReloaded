package com.example.android.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.android.miscontactos.R;
import com.example.android.miscontactos.pojo.Contactos;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/21/2017.
 */

public class ConstructorContactos {
    private static final int LIKE = 1;
    //Esta clase es el Interactor con la clase que consulta la base de datos. Clase clave para switchear la base de datos.

    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    //El primer estandar es que los datos siempre deben venir en un ArrayList de objetos contacto
    public ArrayList<Contactos> obtenerDatos(){
        /*ArrayList<Contactos> contactos = new ArrayList<>();

        contactos.add(new Contactos("Diego Salas", "959363398", "dominicsc2hs@gmail.com", R.drawable.andorra_texture, 0));
        contactos.add(new Contactos("Mama", "996453562", "jesussalas27@gmail.com", R.drawable.argentina_texture, 1));
        contactos.add(new Contactos("Pedro Cateriano", "123456789", "AntonioConsignielri@gmail.com", R.drawable.armenia_texture, 2));
        contactos.add(new Contactos("Carla Magna", "987654321", "PabloMArnol@gmail.com", R.drawable.austria_texture, 1));
        contactos.add(new Contactos("Gian Carlo Magno", "123454986", "DominicToretto@gmail.com", R.drawable.belgium_texture, 6));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        //la clave es el nombre del campo y se le asigna el valor en doble comillas
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Anahi Salgado");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "777999981");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "piera@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.andorra_texture);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Pedro Cateriano");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "1239788912");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "mirellaLopez@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.argentina_texture);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Carla Magna");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "123454986");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "dominicsc2hs@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.belgium_texture);

        db.insertarContactos(contentValues);
    }

    public void darLikeContacto(Contactos contacto){

        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        //obtenemos el id  del contacto al que le dimos like
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikeContacto(Contactos contacto){

        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }
}
