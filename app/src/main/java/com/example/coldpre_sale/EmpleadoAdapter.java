package com.example.coldpre_sale;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    private List<Empleado> empleados;

    private int selectedPosition = RecyclerView.NO_POSITION;

    public EmpleadoAdapter() {
        empleados = new ArrayList<>();
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empleado, parent, false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        // Obtener el empleado en la posición actual
        Empleado empleado = empleados.get(position);
        holder.bind(empleado);

        holder.itemView.setSelected(selectedPosition == position);

        // Asignar los valores a las TextViews en el ViewHolder
        //holder.textViewTipoEmpleado.setText("Tipo Empleado: " + empleado.getTipoEmpleado());
        holder.textViewNombres.setText("Nombres: " + empleado.getNombres());
        holder.textViewApellidos.setText("Apellidos: " + empleado.getApellidos());
        holder.textViewRun.setText("Run: " + empleado.getRun());
        /*holder.textViewFechaNacimiento.setText("Fecha nacimiento: " + empleado.getFechaNacimiento());
        holder.textViewLicenciaConducir.setText("Licencia de conducir: " + empleado.getTipoLicencia());
        holder.textViewVencimientoLicencia.setText("Vencimiento licencia: " + empleado.getVencimientoLicencia());
        holder.textViewTallaPolar.setText("Talla polar: " + empleado.tallaPolar);
        holder.textViewTallaZapatos.setText("Talla zapatos: " + empleado.tallaZapatos);
        holder.textViewTallaPantalon.setText("Talla pantalon: " + empleado.tallaPantalon);
        holder.textViewTallaPolera.setText("Talla polera: " + empleado.tallaPolera);
        holder.textViewTallaCasaca.setText("Talla casaca: " + empleado.tallaCasaca);*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualizar la posición seleccionada y notificar cambios
                int previousSelectedPosition = selectedPosition;
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(previousSelectedPosition);
                notifyItemChanged(selectedPosition);

                // Notificar al listener que se hizo clic en un elemento
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(selectedPosition);
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return empleados.size();
    }
    public Empleado getItem(int position) {
        return empleados.get(position);
    }

    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
        notifyDataSetChanged();
    }

    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTipoEmpleado, textViewNombres, textViewApellidos, textViewRun,
                textViewFechaNacimiento, textViewLicenciaConducir, textViewVencimientoLicencia,
                textViewTallaPolar, textViewTallaZapatos, textViewTallaPantalon, textViewTallaPolera, textViewTallaCasaca;


        EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);
            //textViewTipoEmpleado = itemView.findViewById(R.id.textViewTipoEmpleado);
            textViewNombres = itemView.findViewById(R.id.tvNombres);
            textViewApellidos = itemView.findViewById(R.id.tvApellidos);
            textViewRun = itemView.findViewById(R.id.tvRut);
            /*textViewFechaNacimiento = itemView.findViewById(R.id.textViewFechaNacimiento);
            textViewLicenciaConducir = itemView.findViewById(R.id.textViewLicenciaConducir);
            textViewVencimientoLicencia = itemView.findViewById(R.id.textViewVencimientoLicencia);
            textViewTallaPolar = itemView.findViewById(R.id.textViewTallaPolar);
            textViewTallaZapatos = itemView.findViewById(R.id.textViewTallaZapatos);
            textViewTallaPantalon = itemView.findViewById(R.id.textViewTallaPantalon);
            textViewTallaPolera = itemView.findViewById(R.id.textViewTallaPolera);
            textViewTallaCasaca = itemView.findViewById(R.id.textViewTallaCasaca);*/

        }

        void bind(Empleado empleado) {
            textViewNombres.setText(empleado.getNombres());
            textViewApellidos.setText(empleado.getApellidos());
            // Puedes agregar más setText para otras propiedades según tus necesidades
        }
    }
}
