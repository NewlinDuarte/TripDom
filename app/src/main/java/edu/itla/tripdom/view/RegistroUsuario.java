
package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private UsuarioDbo db;
    private static final String Log_T = "ResgistrioUsuario";

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

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario();

                //Obtaining data from the activity
                usuario.setNombre(txtNombre.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setTelefono(txtTelefono.getText().toString());
                usuario.setTipo(TipoUsuario.CLIENTE);

                Log.i(Log_T,usuario.toString());

                //Inserting user with data obtained in "RegistroUsuario"
                db.crear(usuario);
            }
        });

    }
}
