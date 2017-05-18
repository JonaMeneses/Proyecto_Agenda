package com.example.paco.agendacards;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by paco on 08/03/17.
 */

public class ContactoAdapter extends
        RecyclerView.Adapter<ContactoAdapter.ViewHolder>{

    private static List<Contacto> lista;
    private static Context contexto;

    public ContactoAdapter(List<Contacto> lista,Context conetxto){
        this.lista = lista;
    }

    public static class ViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView lbNombre;
        public TextView lbTelefono;
        public Button btndetalle;


        public ViewHolder(View v){
            super(v);
            lbNombre = (TextView) v.findViewById(
                    R.id.lb_nombre);
            lbTelefono = (TextView) v.findViewById(
                    R.id.lb_telefono);
            btndetalle=(Button)v.findViewById(R.id.btn_detalle);

        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(contexto,);
            Contacto contacto = new Contacto();
            contacto=lista.get(getAdapterPosition());
            intent.putExtra("CONTACTO",contacto);
            startActivity(intent);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        View rootView = LayoutInflater.from(
                parent.getContext()).inflate(
                R.layout.item_contacto,parent,false);
        //Aquí paso la vista de la tarjeta.
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contacto c = lista.get(position);
        holder.lbNombre.setText(c.getNombre());
        holder.lbTelefono.setText(c.getTelefono());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
