package com.example.diurno.paises;

import android.content.DialogInterface;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pais> listaArticulos;
    private MiAdaptador adapter;
    private TextView panel;
    private int aciertos = 0;
    private int fallos = 0;
    private TextView lblFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panel = (TextView) findViewById(R.id.panel);
        listaArticulos = new ArrayList<Pais>();
        listaArticulos = getAllPaises();
        lblFin = (TextView) findViewById(R.id.empty);

        final ListView lista = (ListView) findViewById(R.id.listaDerechos);
        adapter = new MiAdaptador(R.layout.list_item, listaArticulos);
        lista.setAdapter(adapter);
        lista.setEmptyView(lblFin);

        // item listener
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, final int position, long l) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialogo_mapa, null);


                final EditText capital = (EditText) mView.findViewById(R.id.et_capital);
                ImageView imagen = (ImageView) mView.findViewById(R.id.imagenMapa);
                TextView titulo = (TextView) mView.findViewById(R.id.titulo);

                // Establecemos la informacion
                imagen.setImageResource(listaArticulos.get(position).getImagen());
                titulo.setText(listaArticulos.get(position).getTitulo());


                mBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if(!capital.getText().toString().isEmpty()){
                            if(capital.getText().toString().trim().equals(listaArticulos.get(position).getCapital().toString().trim())){
                                aciertos++;
                                panel.setText("Aciertos " + aciertos + " Fallos " + fallos);

                                listaArticulos.remove(listaArticulos.get(position));
                                adapter.notifyDataSetChanged();


                                Toast.makeText(MainActivity.this, "Opcion correcta: " + capital.getText().toString(), Toast.LENGTH_SHORT).show();
                            } else {

                                fallos++;
                                panel.setText("Aciertos " + aciertos + " Fallos " + fallos);

                                Toast.makeText(MainActivity.this, "Opcion incorrectada", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Por favor rellene la casilla de la Capital", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mBuilder.setNegativeButton("Anular", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // No hace nada.
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialogo = mBuilder.create();

                dialogo.show();
            }

        });

        if (listaArticulos.isEmpty()){
            lista.setVisibility(View.INVISIBLE);
            lblFin.setVisibility(View.VISIBLE);
        }



    }

    private List<Pais> getAllPaises() {
        List<Pais> lista = new ArrayList<Pais>(){{
            add(new Pais("España", R.drawable.espana, "Madrid"));
            add(new Pais("Portugal", R.drawable.portugal, "Lisboa"));
            add(new Pais("Francia",R.drawable.francia, "Paris"));
            add(new Pais("Italia", R.drawable.italia, "Roma"));
            add(new Pais("Alemania", R.drawable.alemania, "Berlin"));
            add(new Pais("Holanda", R.drawable.holanda, "Amsterdam"));
            add(new Pais("Suecia", R.drawable.suecia, "Estocolmo"));
            add(new Pais("Polonia", R.drawable.polonia, "Varsovia"));
            add(new Pais("Noruega", R.drawable.noruega, "Oslo"));

            add(new Pais("Austria", R.drawable.austria, "Viena"));
            add(new Pais("Dinamarca", R.drawable.dinamarca, "Copenhague"));
            add(new Pais("Grecia", R.drawable.grecia, "Atenas"));
            add(new Pais("Islandia", R.drawable.islandia, "Reikiavik"));
            add(new Pais("Rumania", R.drawable.rumania, "Bucarest"));
            add(new Pais("Rusia", R.drawable.rusia, "Moscu"));
        }};
        return lista;
    }
}
