package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button iniciarSesionButton;
    private Button registrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarSesionButton = findViewById(R.id.button3);
        registrarButton = findViewById(R.id.button4);

        iniciarSesionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });
    }

    private void iniciarSesion() {
        Intent iniciar = new Intent(this, inicio_sesion.class);
        startActivity(iniciar);
    }

    private void registrarUsuario() {
        Intent registrar = new Intent(this, registro_usuario.class);
        startActivity(registrar);
    }
}
