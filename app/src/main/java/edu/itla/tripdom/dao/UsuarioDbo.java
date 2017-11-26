package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;

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

    public void crear(Usuario usuario)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nombre", usuario.getNombre());
        cv.put("email", usuario.getEmail());
        cv.put("telefono", usuario.getTelefono());
        cv.put("tipo_usuario", usuario.getTipo().toString());
    }

    public List<Usuario> buscar()
    {

    }
}
