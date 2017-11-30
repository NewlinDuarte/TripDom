package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Newlin on 11/30/2017.
 */

public class PublicacionDbo
{
    private DbConnection connection;
    public void crear(Publicacion publicacion)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para insertar en usuario
        cv.put("fecha", publicacion.getFechaPublicacion().toString());
        cv.put("fechaViaje", publicacion.getFechaviaje().toString());
        cv.put("costo", publicacion.getPrecio());
        cv.put("descripcion", publicacion.getDescripcion());
        cv.put("status", publicacion.getEstado());
        cv.put("cupo", publicacion.getCupo());


        //abriendo db para insertar en Usuario
        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion", null, cv);

        //setting id value generated from database to "usuario.id" to confirm the insert went through correctly
        publicacion.setId(id.intValue());

        //Cerrando Db
        db.close();
    }


    public void editar(Publicacion publicacion)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para editar en publicacion
        cv.put("fecha", publicacion.getFechaPublicacion().toString());
        cv.put("fechaViaje", publicacion.getFechaviaje().toString());
        cv.put("costo", publicacion.getPrecio());
        cv.put("descripcion", publicacion.getDescripcion());
        cv.put("status", publicacion.getEstado());
        cv.put("cupo", publicacion.getCupo());

        //abriendo db para insertar en publicacion
        SQLiteDatabase db = connection.getWritableDatabase();
        db.update("publicacion",cv,"id =" + publicacion.getId(), null);

        //Cerrando Db
        db.close();
    }

    public void eliminar(Publicacion publicacion)
    {
        connection.getWritableDatabase();

        //abriendo db para eliminar en publicacion
        SQLiteDatabase db = connection.getWritableDatabase();
        db.delete("publicacion","id = " + publicacion.getId() , null);

        //Cerrando Db
        db.close();
    }


    public List<Publicacion> buscar() throws ParseException {
        //User list where Usuario data will be held temporarily
        List<Publicacion> pubList = new ArrayList<>();

        //Structure that will hold each users data
        String columns[] = new String[]{"id", "fecha","fechaViaje","costo","descripcion","status","cupo"};

        //opening db and cursor for accessing db and obtaining user data;
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("publicacion", columns, null,  null, null, null, null);

        cursor.moveToFirst();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

        while(!cursor.isAfterLast())
        {
            Publicacion p = new Publicacion();

            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
            p.setFechaviaje(dateFormat.parse(cursor.getString(cursor.getColumnIndex("fecha"))));
            p.setFechaviaje(dateFormat.parse(cursor.getString(cursor.getColumnIndex("fechaViaje"))));
            p.setPrecio(cursor.getFloat(cursor.getColumnIndex("costo")));
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("status")));
            p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));

            pubList.add(p);

            cursor.moveToNext();
        }
        //closing cursor and db
        cursor.close();
        db.close();

        return pubList;
    }
}
