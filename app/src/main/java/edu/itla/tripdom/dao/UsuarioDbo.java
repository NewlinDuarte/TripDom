package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import edu.itla.tripdom.entity.Usuario;

/**
 * Created by MESCyT on 26/11/2017.
 */

public class UsuarioDbo {
    private DbConnection connection;
    public UsuarioDbo(Context context)
    {
        connection = new DbConnection(context);
    }

    //Creates a "Usuario" in the "usuario" table in the database
    public void crear(Usuario usuario)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para insertar en usuario
        cv.put("nombre", usuario.getNombre());
        cv.put("email", usuario.getEmail());
        cv.put("telefono", usuario.getTelefono());
        cv.put("tipo_usuario", usuario.getTipo().toString());

        //abriendo db para insertar en Usuario
        SQLiteDatabase db = connection.getWritableDatabase();
        db.insert("usuario", null, cv);

        //Cerrando Db
        db.close();
    }

    public List<Usuario> buscar()
    {

    }
}
