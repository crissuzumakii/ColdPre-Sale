package com.example.coldpre_sale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroActivity extends AppCompatActivity {
    ImageView imagencarro;
    EditText Registro;
    TextView CorreoElectronico;
    TextView Contraseña;
    Button BotonCrearRegistro;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        CorreoElectronico=findViewById(R.id.editcorreo);
        Contraseña=findViewById(R.id.editcontraseña);
        BotonCrearRegistro=findViewById(R.id.botonCrearregistro);

        mAuth = FirebaseAuth.getInstance();

        BotonCrearRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String email = CorreoElectronico.getText().toString().trim();
        String password = Contraseña.getText().toString().trim();

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validar longitud de la contraseña (mínimo 6, máximo 8 caracteres)
        if (password.length() < 6 || password.length() > 8) {
            Toast.makeText(this, "La contraseña debe tener entre 6 y 8 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistroActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish(); // Cerrar la actividad actual para evitar que el usuario vuelva a esta actividad al presionar "Atrás"
                        } else {
                            Toast.makeText(RegistroActivity.this, "Error al registrar", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}