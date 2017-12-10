package edu.itla.tripdom.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.DbConnection;
import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Publicacion;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.view.listadapter.PublicacionListAdapter;
import edu.itla.tripdom.view.listadapter.UsuarioListAdapter;

public class ListaPublicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_publicacion);

        Button btnAgregar = findViewById(R.id.listaPublicacionAgregarbtn);
        ListView listViewPublicacion = findViewById(R.id.listViewPublicacion);

        PublicacionDbo publicacionDbo = new PublicacionDbo(this);
        final List<Publicacion> publicaciones = publicacionDbo.getPublicaciones();


        ListView listview = findViewById(R.id.listViewPublicacion);

        listview.setAdapter(new PublicacionListAdapter(publicaciones, this));


        btnAgregar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intentar = new Intent(ListaPublicacion.this, RegistroPublicacion.class);


                startActivity(intentar);



            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Publicacion p =(Publicacion) parent.getItemAtPosition(position);

                Intent intentar = new Intent(ListaPublicacion.this, RegistroPublicacion.class);
                intentar.putExtra("publicacion", (Serializable) p);

                startActivity(intentar);


            }
        });
    }
}
