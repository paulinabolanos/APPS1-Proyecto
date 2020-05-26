package com.example.bisonapp40;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActividadesAdaptador extends RecyclerView.Adapter<ActividadesAdaptador.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtVwNombreT, txtVwActividad, txtVwMateria, txtVwDescripcion, txtVwDia, txtVwMes, txtVwAno, txtVwHora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVwNombreT = itemView.findViewById(R.id.txtVwNombreT);
            txtVwActividad = itemView.findViewById(R.id.txtVwActividad);
            txtVwMateria = itemView.findViewById(R.id.txtVwMateria);
            txtVwDescripcion = itemView.findViewById(R.id.txtVwDescripcion);
            txtVwDia= itemView.findViewById(R.id.txtVwDia);
            txtVwMes = itemView.findViewById(R.id.txtVwMes);
            txtVwAno = itemView.findViewById(R.id.txtVwAno);
            txtVwHora = itemView.findViewById(R.id.txtVwHora);
            //imgVw = itemView.findViewById(R.id.imgVw);
        }
    }
    public List<ActividadesModelo> actividadLista;

    public  ActividadesAdaptador (List<ActividadesModelo> actividadLista){
        this.actividadLista = actividadLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.actividad, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtVwNombreT.setText(actividadLista.get(position).getNombre());
        holder.txtVwActividad.setText(actividadLista.get(position).getActividad());
        holder.txtVwMateria.setText(actividadLista.get(position).getMateria());
        holder.txtVwDescripcion.setText(actividadLista.get(position).getDescripcion());
        holder.txtVwDia.setText(actividadLista.get(position).getDia());
        holder.txtVwMes.setText(actividadLista.get(position).getMes());
        holder.txtVwAno.setText(actividadLista.get(position).getAno());
        holder.txtVwHora.setText(actividadLista.get(position).getHora());


    }

    @Override
    public int getItemCount() {
        return actividadLista.size();
    }
}
