package com.example.android.miscontactos.restApi.model;
import com.example.android.miscontactos.pojo.Contactos;
import java.util.ArrayList;

/**
 * Created by DOMINIC on 2/24/2018.
 */
//modelo de respuesta
public class ContactoResponse {

    ArrayList<Contactos> contactos;

    public ArrayList<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contactos> contactos) {
        this.contactos = contactos;
    }
}
