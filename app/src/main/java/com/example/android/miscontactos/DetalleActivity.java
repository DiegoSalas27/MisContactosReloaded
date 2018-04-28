package com.example.android.miscontactos;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DOMINIC on 8/11/2017.
 */

public class DetalleActivity extends AppCompatActivity {

    //TextView tvNombre, tvTelefono, tvEmail;

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString("url");
        int likes = parametros.getInt("like");
        //String telefono = parametros.getString("telefono");
        //String email = parametros.getString("emaill");

        //tvNombre = (TextView) findViewById(R.id.tvNombre);
        //tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        //tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));
        //tvNombre.setText(nombre);
        //tvTelefono.setText(telefono);
        //tvEmail.setText(email);
    }
}
