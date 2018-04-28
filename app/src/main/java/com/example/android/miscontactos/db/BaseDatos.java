package com.example.android.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.miscontactos.pojo.Contactos;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/21/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME,null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    //aqui se crea la estructura de la base de datos, la composicion de las tablas, etc
    @Override
    public void onCreate(SQLiteDatabase db) {

        //creamos una tabla con los campos del contacto. Cada campo representa una un indice en la tabla
        //Sintaxis SQL
        //dentro de los parentesis estan los campos de nuestra base de datos
        //al CREATE_TABLE le sigue el nombre de la tabla
        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                ConstantesBaseDatos.TABLE_CONTACTS_ID +  " INTEGER PRIMARY KEY AUTOINCREMENT, " + //llave primaria
                ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, " + ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                ConstantesBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, "  +
                ConstantesBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER" +
                                       ")";
        String queryCrearTablaLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "(" + ConstantesBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //se utiliza este metodo si se necesita reestructurar la base de datos
        //usamos execSQL para ejecutar un query que no nos retorna un valor de retorno
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        onCreate(db);
    }

    //metodo de consulta a base de datos
    public ArrayList<Contactos> obtenerTodosLosContactos(){
        ArrayList<Contactos> contactos = new ArrayList<>();
        //tabla a consultar
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        //abrir la base de datos en forma de escritura o lectura
        SQLiteDatabase db = this.getWritableDatabase();
        //ejecutamos el query. Nos devuelve la coleccion de datos que consulto
        //rawQuery se utiliza cuando se devuelve un valor de retorno: el cursor registros
        Cursor registros = db.rawQuery(query, null); // registros nos ayuda a recorrer los registros

        while(registros.moveToNext()){ //empezamos a llenar el objeto contactos
            /*Contactos contactoActual = new Contactos();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.seteMail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES +") as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "=" + contactoActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);

            //si hay likes
            if(registrosLikes.moveToNext()){
                contactoActual.setNlikes(registrosLikes.getInt(0));
            } else{
                contactoActual.setNlikes(0);
            }

            contactos.add(contactoActual);*/
        }

        db.close();

        return contactos;
    }
    //guardamos los contactos creados
    public void insertarContactos(ContentValues contentValues){
        //abrimos la base de datos en modo escritura
        //con getWriteableDatabase guardamos datos o leemos datos. (store data)
        //to fetch data getReadableDatabase (fetch data)
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues);
        //contentValues tiene asociado el valor con su respectivo campo (tipo de clave-valor)
        db.close();

    }
    //pasa el id y el numero de likes a la tabla de contacto likes. inserta un contacto en la tabla contactos
    public void insertarLikeContacto(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        //contentvalues sirve para guardar datos a la base de datos
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
        db.close();
    }

    public int obtenerLikesContacto(Contactos contactos){

        int likes = 0;
        //este query devuelve la suma de todos los likes de un contacto en particular
        //la funcion SELECT COUNT nos permite sumar los valores del campo de numero de likes
        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "="+contactos.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        //recuperamos los datos en un Cursor (fetch data)
        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
           likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
