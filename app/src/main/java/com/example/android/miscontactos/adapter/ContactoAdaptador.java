package com.example.android.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miscontactos.DetalleContacto;
import com.example.android.miscontactos.db.ConstructorContactos;
import com.example.android.miscontactos.pojo.Contactos;
import com.example.android.miscontactos.DetalleActivity;
import com.example.android.miscontactos.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/11/2017.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contactos> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contactos> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y pasar a viewholder para obtener los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //asociamos el layout al recycler view a través de un inflater
        //indicamos que layout sera reciclado
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contact, parent, false);

        //pasamos este layout cardview_contacto inflado como un view a ContactoViewHolder y tome cada elemento que compone ese layout
        return new ContactoViewHolder(v);
}

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder contactoViewHolder, int position) {
        //aqui seteamos los valores que tiene cada uno de los objetos de la lista Contactos
        //esta funcion se invoca cada vez que se recorre la lista de Contactos y de cada lista obtiene la posicion de cada objeto y extrae sus elementos
        final Contactos contacto = contactos.get(position);
        //contactoViewHolder.imgFoto.setImageResource(contacto.getUrlFoto());
        Picasso.with(activity).load(contacto.getUrlFoto()).into(contactoViewHolder.imgFoto);
        //contactoViewHolder.tvNombre.setText(contacto.getNombre());
        //contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.tvLikes.setText(String.valueOf(contacto.getNlikes()));

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, contacto.getNombreCompleto(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                //intent.putExtra("emaill", contacto.geteMail());
                intent.putExtra("url", contacto.getUrlFoto());
                intent.putExtra("like", contacto.getNlikes());
                activity.startActivity(intent);

            }
        });
        /*contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);

                contactoViewHolder.tvLikes.setText(String.valueOf(constructorContactos.obtenerLikeContacto(contacto)) + " Likes");
            }
        });*/
    }

    @Override
    public int getItemCount() { //manejamos la cantidad de elementos que contiene la lista de contactos
        return contactos.size();
    }

    //para accesar a una clase estatica se accesa a traves del nombre de la clase que lo contiene
    //el view holder nos ayudara a crear views y asociarlos a su equivalente en objeto

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        //aca se definen todos los views de cardview_contacto.xml
        private TextView tvNombre, tvTelefono, tvLikes;
        private ImageView imgFoto;
        private ImageButton btnLike;


        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            //tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            //tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            //btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
        }
    }
}
