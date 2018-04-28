package com.example.android.miscontactos.pojo;

/**
 * Created by DOMINIC on 8/5/2017.
 */

public class Contactos {

    private String nombreCompleto;
    //private String telefono;
    //private String eMail;
    private String UrlFoto;
    private int nlikes;
    private String id; // se genera automaticamente por eso no esta en el constructor

    public Contactos(String nombreCompleto, String UrlFoto, int nlikes){
        this.nombreCompleto = nombreCompleto;
        this.UrlFoto = UrlFoto;
        this.nlikes = nlikes;
    }

    public Contactos() {

    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return UrlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        UrlFoto = urlFoto;
    }

    public int getNlikes() {
        return nlikes;
    }

    public void setNlikes(int nlikes) {
        this.nlikes = nlikes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
