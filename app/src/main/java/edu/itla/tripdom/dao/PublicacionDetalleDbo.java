package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.PublicacionDetalle;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Newlin on 11/30/2017.
 */

public class PublicacionDetalleDbo
{
    private DbConnection connection;

    //Create
    public void crear(PublicacionDetalle detalle)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para insertar en publicacion_detalle
        cv.put("publicacion_id", detalle.getPublicacionId());
        cv.put("lugar", detalle.getLugar());
        cv.put("descripcion", detalle.getDescripcion());


        //abriendo db para insertar en Usuario
        SQLiteDatabase db = connection.getWritableDatabase();
        Long id = db.insert("publicacion_detalle", null, cv);

        //setting id value generated from database to "usuario.id" to confirm the insert went through correctly
        detalle.setId(id.intValue());

        //Cerrando Db
        db.close();
    }

    //region Read methods
    public List<PublicacionDetalle> buscar()
    {
        //User list where Usuario data will be held temporarily
        List<PublicacionDetalle> pubDetalleList = new ArrayList<>();

        //Structure that will hold each users data
        String columns[] = new String[]{"id", "publicacion_id","lugar","descripcion"};

        //opening db and cursor for accessing db and obtaining user data;
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("publicacion_detalle", columns, null,  null, null, null, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            PublicacionDetalle pd = new PublicacionDetalle();

            pd.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pd.setPublicacionId(cursor.getInt(cursor.getColumnIndex("publicacion_id")));
            pd.setLugar(cursor.getString(cursor.getColumnIndex("lugar")));
            pd.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));

            pubDetalleList.add(pd);

            cursor.moveToNext();
        }
        //closing cursor and db
        cursor.close();
        db.close();

        return pubDetalleList;
    }

    public List<PublicacionDetalle> buscarPorPublicacion(int publicacionId)
    {
        //User list where Usuario data will be held temporarily
        List<PublicacionDetalle> pubDetalleList = new ArrayList<>();

        //Structure that will hold each users data
        String columns[] = new String[]{"id", "publicacion_id","lugar","descripcion"};

        //opening db and cursor for accessing db and obtaining user data;
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query("publicacion_detalle", columns, "WHERE publicacion_id = " + publicacionId,  null, null, null, null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast())
        {
            PublicacionDetalle pd = new PublicacionDetalle();

            pd.setId(cursor.getInt(cursor.getColumnIndex("id")));
            pd.setPublicacionId(cursor.getInt(cursor.getColumnIndex("publicacion_id")));
            pd.setLugar(cursor.getString(cursor.getColumnIndex("lugar")));
            pd.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));

            pubDetalleList.add(pd);

            cursor.moveToNext();
        }
        //closing cursor and db
        cursor.close();
        db.close();

        return pubDetalleList;
    }
    //endregion

    //Update
    public void editar(PublicacionDetalle detalle)
    {
        connection.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Campos para editar en publicacion_detalle
        cv.put("publicacion_id", detalle.getPublicacionId());
        cv.put("lugar", detalle.getLugar());
        cv.put("descripcion", detalle.getDescripcion());

        //abriendo db para insertar en publicacion_detalle
        SQLiteDatabase db = connection.getWritableDatabase();
        db.update("publicacion_detalle",cv,"id = ? AND publicacion_id = ?"  , new String[]{String.valueOf(detalle.getId()), String.valueOf(detalle.getPublicacionId())});

        //Cerrando Db
        db.close();
    }

    //Delete
    public void eliminar(PublicacionDetalle detalle)
    {
        connection.getWritableDatabase();

        //abriendo db para insertar en publicacion_detalle
        SQLiteDatabase db = connection.getWritableDatabase();
        db.delete("publicacion_detalle","id = ? AND publicacion_id = ?"  , new String[]{String.valueOf(detalle.getId()), String.valueOf(detalle.getPublicacionId())});

        //Cerrando Db
        db.close();
    }


}
