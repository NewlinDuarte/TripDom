package edu.itla.tripdom.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MESCyT on 19/11/2017.
 */

public class Publicacion implements Serializable {
    private  int id;
    private Date fechaPublicacion;
    private Date fechaviaje;
    private float precio;
    private  String descripcion;
    private String estado;
    private Usuario usuario;
    private  String origen;
    private int cupo;
    private List<PublicacionDetalle> publicacionDetalle;

    public void addDetalle(PublicacionDetalle pd)
    {
        if(publicacionDetalle == null)
        {
            publicacionDetalle = new ArrayList<>();
        }
        pd.setPublicacionId(this.id);
        publicacionDetalle.add(pd);
    }



    //region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Date getFechaviaje() {
        return fechaviaje;
    }

    public void setFechaviaje(Date fechaviaje) {
        this.fechaviaje = fechaviaje;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public List<PublicacionDetalle> getPublicacionDetalle()
    {
        return publicacionDetalle;
    }

    //endregion
}
