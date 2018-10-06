package com.example.juanes24.practica4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class AdapterPeluches extends RecyclerView.Adapter<AdapterPeluches.PeluchesViewHolder> {

    private ArrayList<Peluches> listPeluches;


    public AdapterPeluches(ArrayList<Peluches> listPeluches) {
        this.listPeluches = listPeluches;

    }

    @NonNull
    @Override
    public PeluchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PeluchesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeluchesViewHolder holder, int position) {
        Peluches peluches= listPeluches.get(position);
        holder.bindPeluches(peluches);

    }

    @Override
    public int getItemCount() {
        return listPeluches.size();
    }

    public class PeluchesViewHolder extends RecyclerView.ViewHolder {
        private TextView tNombre, tCantidad, tPrecio;

        public PeluchesViewHolder(View itemView) {
            super(itemView);
            tNombre=itemView.findViewById(R.id.tNombre);
            tCantidad=itemView.findViewById(R.id.tCantidad);
            tPrecio=itemView.findViewById(R.id.tPrecio);

        }

        public void bindPeluches(Peluches peluches){
            tNombre.setText(peluches.getNombre());
            tCantidad.setText(peluches.getCantidad());
            tPrecio.setText(peluches.getPrecio());

        }
    }




}
