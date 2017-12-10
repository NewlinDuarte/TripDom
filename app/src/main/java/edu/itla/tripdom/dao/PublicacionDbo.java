package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by MESCyT on 10/12/2017.
 */

public class PublicacionDbo {

    SimpleDateFormat DF;

    private DbConnection connection;


    public void crear(Publicacion publicacion)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para insertar en usuario
        cv.put("fecha", DF.format(publicacion.getFechaPublicacion().toString()));
        cv.put("fechaViaje", DF.format(publicacion.getFechaviaje().toString()));
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
        cv.put("usuario_id", publicacion.getUsuario().getId());

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



    public List<Publicacion> getPublicaciones()
    {
        SQLiteDatabase db = connection.getReadableDatabase();


        Cursor cursor = db.rawQuery("SELECT p.*, u.nombre, u.email FROM publicacion p INNER JOIN usuario u ON p.usuario_id = u.id",null);
        cursor.moveToNext();
        List<Publicacion> publicaciones = new ArrayList<>();
        while(!cursor.isAfterLast())
        {
            Publicacion p = new Publicacion();
            Usuario u = new Usuario();

            try
            {
                p.setFechaPublicacion((DF.parse(cursor.getString(cursor.getColumnIndex("fecha")))));
                p.setFechaviaje(DF.parse(cursor.getString(cursor.getColumnIndex("fechaViaje"))));
                p.setPrecio(cursor.getFloat(cursor.getColumnIndex("costo")));
                p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
                p.setEstado(cursor.getString(cursor.getColumnIndex("status")));
                p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));
            }
            catch (ParseException ex)
            {
                p.setFechaPublicacion(new Date());
                p.setFechaviaje(new Date());
                p.setPrecio(0);
                p.setEstado("");
            }
            }
            return publicaciones;

    }
}
