
package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.R;
import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private UsuarioDbo db;
    private static final String Log_T = "ResgistrioUsuario";
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Instancing db
        db = new UsuarioDbo(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        final EditText txtNombre = findViewById((R.id.txtNombre));
        final EditText txtEmail = findViewById((R.id.txtEmail));
        final EditText txtTelefono = findViewById((R.id.txtTelefono));

        Button btnGuardar = findViewById((R.id.btnGuardar));
        Button btnCambiar = findViewById((R.id.btnCambiar));


        //Get the bundle
        Bundle bundle = getIntent().getExtras();

        //Extract the data…
        if(bundle != null && bundle.containsKey("usuario")) {
            usuario = (Usuario) bundle.getSerializable("usuario");

            txtNombre.setText(usuario.getNombre());
            txtEmail.setText(usuario.getEmail());
            txtTelefono.setText(usuario.getTelefono());
        }



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Obtaining data from the activity
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setTelefono(txtTelefono.getText().toString());
                usuario.setTipo(TipoUsuario.PUBLICADOR);

                Log.i(Log_T,usuario.toString());

                //Inserting user with data obtained from "RegistroUsuario"
                db.crear(usuario);

            }
        });

        btnCambiar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(usuario !=null && usuario.getId() > 0){
                    UsuarioActual.setUsuario(usuario);
                }
            }
        });

    }
}
