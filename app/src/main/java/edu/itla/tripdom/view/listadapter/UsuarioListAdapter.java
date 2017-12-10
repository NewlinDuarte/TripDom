package edu.itla.tripdom.view.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by fabio on 12/3/2017.
 */

public class UsuarioListAdapter extends BaseAdapter {

    private List<Usuario> usuarios;
    private Activity context;


    public UsuarioListAdapter(List<Usuario> usuarios, Activity context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(R.layout.listview_usuario_row, null, true);
        }
        TextView lvNombre = convertView.findViewById(R.id.listViewNombreUsuario);
        TextView lvEmail = convertView.findViewById(R.id.listViewEmail);
        TextView lvTipoUsuario = convertView.findViewById(R.id.listViewTipoUsuario);
        Usuario u =  usuarios.get(position);

        lvNombre.setText(u.getNombre());
        lvEmail.setText(u.getEmail());
        lvTipoUsuario.setText(u.getTipo().toString());

        return convertView;
    }
}