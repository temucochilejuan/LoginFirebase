package com.example.loginfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registro_usuario extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText correo, password, vpassword;
    private Button registrarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        mAuth = FirebaseAuth.getInstance();
        correo = findViewById(R.id.editTextText2);
        password = findViewById(R.id.editTextTextPassword2);
        vpassword = findViewById(R.id.editTextTextPassword3);
        registrarButton = findViewById(R.id.button2);

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String correoStr = correo.getText().toString();
        String passwordStr = password.getText().toString();
        String vpasswordStr = vpassword.getText().toString();

        if (passwordStr.equals(vpasswordStr)) {
            mAuth.createUserWithEmailAndPassword(correoStr, passwordStr)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Usuario Registrado", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            } else {
                                String errorMensaje = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(), "Autenticación Fallida: " + errorMensaje, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
    }
}
