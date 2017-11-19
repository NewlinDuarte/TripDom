package edu.itla.tripdom.entity;

/**
 * Created by MESCyT on 19/11/2017.
 */

public class PublicacionDetalle {

    private int id;
    private int publicacionId;
    private String lugar;
    private String descripcion;

    //region Getters amd Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //endregion
}
