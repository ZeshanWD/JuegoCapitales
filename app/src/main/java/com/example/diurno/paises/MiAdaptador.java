package com.example.diurno.paises;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zeeshan on 24/10/2017.
 */

public class MiAdaptador extends BaseAdapter {

    // Declare Variables
    private int layout;
    private List<Pais> list;

    public MiAdaptador(int layout, List<Pais> list) {
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Pais getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if(convertView == null){
            row = LayoutInflater.from(parent.getContext()).inflate(layout, null);

            Log.v("ZESHAN", "CALLING FiendViewById()");
            TextView titulo = (TextView) row.findViewById(R.id.list_item_title);
            ImageView imagen = (ImageView) row.findViewById(R.id.list_item_img);

            ViewHolder holder = new ViewHolder(titulo, imagen);
            row.setTag(holder);
        } else {
            row = convertView;
        }

        // cogo el ViewHolder con el metodo getTag, ya que antes metimos con el setTag()
        ViewHolder holder = (ViewHolder) row.getTag();
        // Cogemos el pueblo actual con la position
        Log.v("ZESHAN", "CALLING FiendViewById()");
        final Pais paisActual = getItem(position);
        holder.titulo.setText(paisActual.getTitulo());
        holder.imagen.setImageResource(paisActual.getImagen());

        return row;
    }

    static class ViewHolder{
        private TextView titulo;
        private ImageView imagen;

        ViewHolder(TextView titulo, ImageView imagen){
            this.titulo = titulo;
            this.imagen = imagen;
        }
    }
}
