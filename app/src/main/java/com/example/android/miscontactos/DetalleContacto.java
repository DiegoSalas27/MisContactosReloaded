package com.example.android.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleContacto extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
//    private TextView tvNombre;
//    private TextView tvTelefono;
//    private TextView tveMail;

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle parametros = getIntent().getExtras();
        String url = parametros.getString(KEY_EXTRA_URL);
        int likes = parametros.getInt(KEY_EXTRA_LIKES);

//        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
//        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
//        String eMail = parametros.getString(getResources().getString(R.string.pEmail));

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));
        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);

        Picasso.with(this).load(url).into(imgFotoDetalle);

//        tvNombre = (TextView) findViewById(R.id.tvNombre);
//        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
//        tveMail = (TextView) findViewById(R.id.tvEmail);
//
//        tvNombre.setText(nombre);
//        tvTelefono.setText(telefono);
//        tveMail.setText(eMail);

    }

    //intent implicito para poder tomar un recurso externo de la aplicacion (abrimos la aplicacion de llamadas
    // y se llama a traves de la aplicacion)
    /*
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(telefono.trim())));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }
    public void enviarMail(View v){
        String email = tveMail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        //con serType indicamos que tipo de aplicacion o identificador de aplicacion se encuentras las apps de email
        //nuestro chooser son las aplicaciones de email
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));
    }*/

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
