
package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {

    private static final String Log_T = "ResgistrioUsuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

                usuario.setNombre(txtNombre.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setTelefono(txtTelefono.getText().toString());
                Log.i(Log_T,usuario.toString());
            }
        });

    }
}
