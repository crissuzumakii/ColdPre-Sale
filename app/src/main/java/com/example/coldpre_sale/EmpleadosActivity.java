package com.example.coldpre_sale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmpleadosActivity extends AppCompatActivity {
    Button verInformacion;

    private RecyclerView recyclerView;
    private EmpleadoAdapter empleadoAdapter;
    private DatabaseReference empleadoDbRef;

    private int selectedPosition = RecyclerView.NO_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        verInformacion = findViewById(R.id.btnVerInformacion);

        recyclerView = findViewById(R.id.editTextempleados);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        empleadoAdapter = new EmpleadoAdapter();
        recyclerView.setAdapter(empleadoAdapter);

        empleadoDbRef = FirebaseDatabase.getInstance().getReference().child("Empleado");

        empleadoDbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                Empleado empleado = dataSnapshot.getValue(Empleado.class);
                empleadoAdapter.addEmpleado(empleado);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                // Puedes manejar los cambios si es necesario
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // Puedes manejar la eliminación si es necesario
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String previousChildName) {
                // Puedes manejar los movimientos si es necesario
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Puedes manejar los errores si es necesario
            }
        });

        verInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != RecyclerView.NO_POSITION) {
                    Empleado selectedEmpleado = empleadoAdapter.getItem(selectedPosition);
                    Intent i = new Intent(EmpleadosActivity.this, SelectEmpleadoActivity.class);
                    i.putExtra("selectedEmpleado", selectedEmpleado);
                    startActivity(i);
                }
            }
        });

        empleadoAdapter.setOnItemClickListener(new EmpleadoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                selectedPosition = position;
            }


        });


    }

}


