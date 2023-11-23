package com.example.coldpre_sale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CrearEmpleadoActivity extends AppCompatActivity {

    private Spinner spnTipoEmpleado, spnTipoLicencia,spnPolar,spnZapatos,spnPantalon,spnPolera,spnCasaca;
    private EditText etNombres,etApellidos,etRun,etNacimiento,etVenceLicencia;
    private ImageView imgvLicencia,imgvPerfil;
    private Button btnFotoLicencia,btnFotoPerfil,btnCrear, btnIrMenu;
    DatabaseReference empleadoDbref;// Referencia la ubicacion de la base de datos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_empleado);

        spnTipoEmpleado= findViewById(R.id.spnTipoEmpleado);
        spnTipoLicencia= findViewById(R.id.spnTipoLicencia);
        spnPolar= findViewById(R.id.spnPolar);
        spnZapatos= findViewById(R.id.spnZapatos);
        spnPantalon= findViewById(R.id.spnPantalon);
        spnPolera= findViewById(R.id.spnPolera);
        spnCasaca= findViewById(R.id.spnCasaca);
        etNombres=findViewById(R.id.etNombres);
        etApellidos=findViewById(R.id.etApellidos);
        etRun=findViewById(R.id.etRun);
        etNacimiento=findViewById(R.id.etNacimiento);
        etVenceLicencia=findViewById(R.id.etVenceLicencia);
        imgvLicencia= findViewById(R.id.imgvLicencia);
        imgvPerfil= findViewById(R.id.imgvPerfil);
        btnFotoLicencia= findViewById(R.id.btnFotoLicencia);
        btnFotoPerfil= findViewById(R.id.btnFotoPerfil);
        btnCrear=findViewById(R.id.btnCrear);
        btnIrMenu= findViewById(R.id.btnIrMenu);

        //empleadoDbref apunta a la ubicación “Empleado” en la base de datos Firebase.
        // empleadoDbref para leer o escribir datos en esa ubicación.
        // crearEmpleadoData(), usas empleadoDbref para guardar un nuevo empleado en la base de datos
        empleadoDbref= FirebaseDatabase.getInstance().getReference().child("Empleado");

        btnIrMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CrearEmpleadoActivity.this,MenuActivity.class);
                startActivity(i);
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearEmpleadoData();
            }
        });


    }

    private void crearEmpleadoData(){

        // Si estan vacios los Campos
        if (etNacimiento.getText().toString().trim().isEmpty()||etRun.getText().toString().trim().isEmpty()||
                etApellidos.getText().toString().trim().isEmpty()||etNombres.getText().toString().trim().isEmpty()||
                etVenceLicencia.getText().toString().trim().isEmpty()||spnTipoEmpleado.getSelectedItem().toString().trim().isEmpty()||
                spnTipoLicencia.getSelectedItem().toString().trim().isEmpty()||spnCasaca.getSelectedItem().toString().trim().isEmpty()||
                spnPolera.getSelectedItem().toString().trim().isEmpty()||spnPolar.getSelectedItem().toString().trim().isEmpty()||
                spnPantalon.getSelectedItem().toString().trim().isEmpty()||spnZapatos.getSelectedItem().toString().trim().isEmpty()){

            ocultarTeclado();
            Toast.makeText(CrearEmpleadoActivity.this,"ERROR!! Complete todos los Campos",Toast.LENGTH_SHORT).show();

            //Si los campos estan llenos
        } else {
            String tipoEmpleado= ((String) spnTipoEmpleado.getSelectedItem()).toString();
            String nombres= etNombres.getText().toString();
            String apellidos= etApellidos.getText().toString();
            String run= etRun.getText().toString();
            String vencimientoLicencia= etVenceLicencia.getText().toString();
            String fechaNacimiento= etNacimiento.getText().toString();
            String tipoLicencia= ((String) spnTipoLicencia.getSelectedItem()).toString();
            String tallaPolar= ((String) spnPolar.getSelectedItem()).toString();
            String tallaZapatos= ((String) spnZapatos.getSelectedItem()).toString();
            String tallaPantalon= ((String) spnPantalon.getSelectedItem()).toString();
            String tallaPolera= ((String) spnPolera.getSelectedItem()).toString();
            String tallaCasaca= ((String) spnCasaca.getSelectedItem()).toString();
            //si estan todos lo campos llenos, se crea el objeto
            Empleado empleado = new Empleado(tipoEmpleado,nombres,apellidos,run,vencimientoLicencia,fechaNacimiento,
                    tipoLicencia,tallaPolar,tallaZapatos,tallaPantalon,tallaPolera,tallaCasaca);

            empleadoDbref.push().setValue(empleado);// Aqui hace la insercion de datos pasando el objeto
            Toast.makeText(CrearEmpleadoActivity.this,"Empleado fue creado Correctamente",Toast.LENGTH_SHORT).show();

            //Dejar input vacios
            etNombres.setText("");
            etApellidos.setText("");
            etRun.setText("");
            etNacimiento.setText("");
            etVenceLicencia.setText("");
        }

    }//Termina btn Crear

    private void ocultarTeclado(){
        View view=this.getCurrentFocus();
        if (view !=null){
            InputMethodManager imm= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

}