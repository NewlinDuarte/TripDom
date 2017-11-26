package edu.itla.tripdom.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MESCyT on 26/11/2017.
 */

public class DbConnection extends SQLiteOpenHelper
{

    public static String DATABASE_NAME = "tripdom.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context)
    {
        super(context, DATABASE_NAME,  null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
