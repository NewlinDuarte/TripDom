package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.itla.tripdom.view.ListaUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnUsuario = findViewById(R.id.ListaUsuariobtn);

        btnUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast message  = Toast.makeText(MainActivity.this, "Hola " + txtName.getText(), Toast.LENGTH_LONG);
                message.show();*/
                Intent intentar = new Intent(MainActivity.this, ListaUsuario.class);

                startActivity(intentar);


            }
        });

    }
}
