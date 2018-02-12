package com.example.diurno.paises;

/**
 * Created by Diurno on 20/11/2017.
 */

public class Pais {

    private String titulo;
    private int imagen;
    private String capital;

    public Pais(String titulo, int imagen, String capital) {
        this.titulo = titulo;
        this.imagen = imagen;
        this.capital = capital;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
