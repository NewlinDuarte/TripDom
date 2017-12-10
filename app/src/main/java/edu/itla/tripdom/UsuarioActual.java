package edu.itla.tripdom;

import edu.itla.tripdom.entity.Usuario;

/**
 * Created by MESCyT on 10/12/2017.
 */

public class UsuarioActual {
    private static Usuario usuario;

    private static Usuario getUsuario()
    {
        return  usuario;
    }

    public static void setUsuario(Usuario user)
    {
        usuario = user;
    }
}
