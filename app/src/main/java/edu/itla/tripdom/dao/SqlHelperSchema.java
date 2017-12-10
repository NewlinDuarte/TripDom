package edu.itla.tripdom.dao;

/**
 * Created by MESCyT on 26/11/2017.
 */

public class SqlHelperSchema {
    public static final String USUARIO_TABLE = "CREATE TABLE IF NOT EXISTS `usuario` (" +
            "`id` INTEGER PRIMARY KEY AUTOINCREMENT," +
            "`nombre` TEXT NOT NULL," +
            "`email` TEXT NOT NULL," +
            "`telefono` TEXT NOT NULL," +
            "`tipo_usuario` TEXT NOT NULL" +
            ");";

    public static final String PUBLICACION_TABLE = "CREATE TABLE IF NOT EXISTS `publicacion` (" +
            "`id`	INTEGER PRIMARY KEY AUTOINCREMENT," +
            "`fecha`	TEXT NOT NULL,         " +
            "`fechaViaje`	TEXT NOT NULL," +
            "`costo`	REAL NOT NULL," +
            "`descripcion`	TEXT NOT NULL," +
            "`status`	TEXT NOT NULL," +
            "`usuario_id`	INTEGER NOT NULL," +
            "`origen`	TEXT NOT NULL," +
            "`cupo`	INTEGER" +
            ");";

    public static final String PUBLICACION_DETALLE_TABLE = "CREATE TABLE IF NOT EXISTS `publicacion_detalle` (" +
            "`id`INTEGER PRIMARY KEY AUTOINCREMENT," +
            "`publicacion_id`INTEGER NOT NULL," +
            "`lugar`TEXT NOT NULL," +
            "`descripcion`TEXT NOT NULL" +
            ");";





}
