package com.example.coldpre_sale;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Empleado implements Parcelable {
    String tipoEmpleado;
    String nombres;
    String apellidos;
    String run;
    String fechaNacimiento;
    String vencimientoLicencia;
    String tipoLicencia;
    String tallaPolar;
    String tallaZapatos;
    String tallaPantalon;
    String tallaPolera;
    String tallaCasaca;

    public Empleado() {
    }

    public Empleado(String tipoEmpleado, String nombres, String apellidos, String run, String fechaNacimiento,
                    String vencimientoLicencia, String tipoLicencia, String tallaPolar, String tallaZapatos,
                    String tallaPantalon, String tallaPolera, String tallaCasaca) {
        this.tipoEmpleado = tipoEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.run = run;
        this.fechaNacimiento = fechaNacimiento;
        this.vencimientoLicencia = vencimientoLicencia;
        this.tipoLicencia = tipoLicencia;
        this.tallaPolar = tallaPolar;
        this.tallaZapatos = tallaZapatos;
        this.tallaPantalon = tallaPantalon;
        this.tallaPolera = tallaPolera;
        this.tallaCasaca = tallaCasaca;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "tipoEmpleado='" + tipoEmpleado + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", run='" + run + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", vencimientoLicencia='" + vencimientoLicencia + '\'' +
                ", tipoLicencia='" + tipoLicencia + '\'' +
                ", tallaPolar='" + tallaPolar + '\'' +
                ", tallaZapatos='" + tallaZapatos + '\'' +
                ", tallaPantalon='" + tallaPantalon + '\'' +
                ", tallaPolera='" + tallaPolera + '\'' +
                ", tallaCasaca='" + tallaCasaca + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tipoEmpleado);
        dest.writeString(this.nombres);
        dest.writeString(this.apellidos);
        dest.writeString(this.run);
        dest.writeString(this.fechaNacimiento);
        dest.writeString(this.vencimientoLicencia);
        dest.writeString(this.tipoLicencia);
        dest.writeString(this.tallaPolar);
        dest.writeString(this.tallaZapatos);
        dest.writeString(this.tallaPantalon);
        dest.writeString(this.tallaPolera);
        dest.writeString(this.tallaCasaca);
    }

    public void readFromParcel(Parcel source) {
        this.tipoEmpleado = source.readString();
        this.nombres = source.readString();
        this.apellidos = source.readString();
        this.run = source.readString();
        this.fechaNacimiento = source.readString();
        this.vencimientoLicencia = source.readString();
        this.tipoLicencia = source.readString();
        this.tallaPolar = source.readString();
        this.tallaZapatos = source.readString();
        this.tallaPantalon = source.readString();
        this.tallaPolera = source.readString();
        this.tallaCasaca = source.readString();
    }

    protected Empleado(Parcel in) {
        this.tipoEmpleado = in.readString();
        this.nombres = in.readString();
        this.apellidos = in.readString();
        this.run = in.readString();
        this.fechaNacimiento = in.readString();
        this.vencimientoLicencia = in.readString();
        this.tipoLicencia = in.readString();
        this.tallaPolar = in.readString();
        this.tallaZapatos = in.readString();
        this.tallaPantalon = in.readString();
        this.tallaPolera = in.readString();
        this.tallaCasaca = in.readString();
    }

    public static final Creator<Empleado> CREATOR = new Creator<Empleado>() {
        @Override
        public Empleado createFromParcel(Parcel source) {
            return new Empleado(source);
        }

        @Override
        public Empleado[] newArray(int size) {
            return new Empleado[size];
        }
    };
}