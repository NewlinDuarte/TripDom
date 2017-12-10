package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.PublicacionDbo;
import edu.itla.tripdom.entity.Publicacion;

public class RegistroPublicacion extends AppCompatActivity {

    private Publicacion publicacion;
    private PublicacionDbo db;
    private SimpleDateFormat DF = new SimpleDateFormat("dd - MM - yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_publicacion);

        db = new PublicacionDbo(this);

        final EditText txtDescripcion = findViewById((R.id.descripcionPublicaciontxt));
        final EditText txtCupo = findViewById((R.id.cupoPublicaciontxt));
        final EditText txtPrecio = findViewById((R.id.precioPublicaciontxt));
        final EditText txtFechaViaje = findViewById((R.id.fechaViajePublicacionDate));
        Button btnGuardar = findViewById((R.id.guardarPublicacionbtn));

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                publicacion.setDescripcion(txtDescripcion.getText().toString());
                publicacion.setCupo(Integer.valueOf(txtCupo.getText().toString()));
                publicacion.setPrecio(Float.valueOf( txtPrecio.getText().toString()));
                try {
                    publicacion.setFechaviaje(DF.parse(txtFechaViaje.getText().toString()));
                }
                catch (ParseException ex){
                    publicacion.setFechaviaje(new Date());
                }


                //Inserting user with data obtained from "RegistroUsuario"
                db.crear(publicacion);
            }
        });



    }
}
