package edu.itla.tripdom.view.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by fabio on 12/3/2017.
 */

public class PublicacionListAdapter extends BaseAdapter {

    private List<Publicacion> publicaciones;
    private Activity context;


    public PublicacionListAdapter(List<Publicacion> publicaciones, Activity context) {
        this.publicaciones = publicaciones;
        this.context = context;
    }

    @Override
    public int getCount() {
        return publicaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return publicaciones.get(position);
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
            convertView = inflater.inflate(R.layout.listview_publicacion_row, null, true);
        }
        TextView lvDescripcion = convertView.findViewById(R.id.listViewDescripcionPublicacion);
        TextView lvFechaPublicacion = convertView.findViewById(R.id.listViewFechaPublicacion);
        TextView lvPrecio = convertView.findViewById(R.id.listViewPrecioPublicacion);
        TextView lvPublicador = convertView.findViewById(R.id.listViewPublicador);
        Publicacion p =  publicaciones.get(position);

        lvDescripcion.setText(p.getDescripcion());
        lvFechaPublicacion.setText(p.getFechaviaje().toString());
        lvPrecio.setText(String.valueOf(p.getPrecio()));
        lvPublicador.setText(p.getUsuario().getNombre());

        return convertView;
    }
}