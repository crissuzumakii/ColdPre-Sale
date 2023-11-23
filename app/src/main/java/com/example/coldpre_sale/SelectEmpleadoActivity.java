package com.example.coldpre_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SelectEmpleadoActivity extends AppCompatActivity {

    EditText tipoEmpleado, nombres, apellidos, run, fechaNacimiento, licenciaConducir, vencimientoLicencia, polar, zapatos, pantalon, polera, casaca;

    Button btnEditar;
    Empleado selectedEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_empleado);

        tipoEmpleado = findViewById(R.id.et_tipoEmpleado);
        nombres = findViewById(R.id.et_nombres);
        apellidos = findViewById(R.id.et_apellidos);
        run = findViewById(R.id.et_rut);
        fechaNacimiento = findViewById(R.id.et_fechaNacimiento);
        licenciaConducir = findViewById(R.id.et_licenciaConducir);
        vencimientoLicencia = findViewById(R.id.et_vencimientoLicencia);
        polar = findViewById(R.id.et_polar);
        zapatos = findViewById(R.id.et_zapatos);
        pantalon = findViewById(R.id.et_pantalon);
        polera = findViewById(R.id.et_polera);
        casaca = findViewById(R.id.et_casaca);
        btnEditar= findViewById(R.id.btnEditar);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("selectedEmpleado")) {
            Empleado selectedEmpleado = intent.getParcelableExtra("selectedEmpleado");

            if (selectedEmpleado != null) {
                tipoEmpleado.setText(selectedEmpleado.getTipoEmpleado());
                nombres.setText(selectedEmpleado.getNombres());
                apellidos.setText(selectedEmpleado.getApellidos());
                run.setText(selectedEmpleado.getRun());
                fechaNacimiento.setText(selectedEmpleado.getFechaNacimiento());
                licenciaConducir.setText(selectedEmpleado.getTipoLicencia());
                vencimientoLicencia.setText(selectedEmpleado.getVencimientoLicencia());
                polar.setText(selectedEmpleado.getTallaPolar());
                zapatos.setText(selectedEmpleado.getTallaZapatos());
                pantalon.setText(selectedEmpleado.getTallaPantalon());
                polera.setText(selectedEmpleado.getTallaPolera());
                casaca.setText(selectedEmpleado.getTallaCasaca());

            }
        }
        // update



        btnEditar.setOnClickListener(view -> {

            if (selectedEmpleado != null) {
                selectedEmpleado.setTipoEmpleado(tipoEmpleado.getText().toString());
                selectedEmpleado.setNombres(nombres.getText().toString());
                selectedEmpleado.setApellidos(apellidos.getText().toString());
                selectedEmpleado.setRun(run.getText().toString());


                Intent returnIntent = new Intent();
                returnIntent.putExtra("editarEmpleado", selectedEmpleado);
                setResult(SelectEmpleadoActivity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }



}