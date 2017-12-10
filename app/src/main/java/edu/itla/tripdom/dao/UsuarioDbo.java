package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by MESCyT on 26/11/2017.
 */

//todo: create methods for update, delete
public class UsuarioDbo {
    private DbConnection connection;
    public UsuarioDbo(Context context)
    {
        connection = new DbConnection(context);
    }

    //Creates a "Usuario" in the "usuario" table in the database
    public void crear(Usuario usuario)
    {

        if(usuario.getId() > 0) {
            editar(usuario);
        }else{
            connection.getWritableDatabase();
            ContentValues cv = new ContentValues();

            //Campos para insertar en usuario
            cv.put("nombre", usuario.getNombre());
            cv.put("email", usuario.getEmail());
            cv.put("telefono", usuario.getTelefono());
            cv.put("tipo_usuario", usuario.getTipo().toString());

            //abriendo db para insertar en Usuario
            SQLiteDatabase db = connection.getWritableDatabase();
            Long id = db.insert("usuario", null, cv);

            //setting id value generated from database to "usuario.id" to confirm the insert went through correctly
            usuario.setId(id.intValue());

            //Cerrando Db
            db.close();
        }
    }

    public void editar(Usuario usuario)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para editar en usuario
        cv.put("nombre", usuario.getNombre());
        cv.put("email", usuario.getEmail());
        cv.put("telefono", usuario.getTelefono());
        cv.put("tipo_usuario", usuario.getTipo().toString());

        //abriendo db para insertar en Usuario
        SQLiteDatabase db = connection.getWritableDatabase();
        db.update("usuario",cv,"id =" + usuario.getId(), null);

        //Cerrando Db
        db.close();
    }

    public void eliminar(Usuario usuario)
    {
        connection.getWritableDatabase();

        //abriendo db para insertar en Usuario
        SQLiteDatabase db = connection.getWritableDatabase();
        db.delete("usuario","id = " + usuario.getId() , null);

        //Cerrando Db
        db.close();
    }

    public List<Usuario> buscar()
    {
        //User list where Usuario data will be held temporarily
        List<Usuario> userList = new ArrayList<>();

        //Structure that will hold each users data
        String columns[] = new String[]{"id", "nombre","email","telefono","tipo_usuario"};

        //opening db and cursor for accessing db and obtaining user data;
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("usuario", columns, null,  null, null, null, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            Usuario u = new Usuario();

            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
            u.setTipo(TipoUsuario.valueOf(cursor.getString(cursor.getColumnIndex("tipo_usuario"))));

            userList.add(u);

            cursor.moveToNext();
        }
        //closing cursor and db
        cursor.close();
        db.close();

        return userList;
    }


}
