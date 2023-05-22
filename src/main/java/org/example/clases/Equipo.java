package org.example.clases;

import org.example.enumeraciones.Resultado;

public class Equipo {
    // Creamos los Atributos
    private String nombre;
    private boolean autorizacion = true;
    private Resultado resultadoEnElPartido;
    private int cantGolesEnELTorneo;
    //creamos los constructores vacio y sobrecargado
    public Equipo() {
    }
    public Equipo(String nombre){
        this.nombre = nombre;
    }
    public Equipo(boolean autorizacion, Resultado resultadoEnElPartido, int cantGolesEnELTorneo) {
        this.autorizacion = autorizacion;
        this.resultadoEnElPartido = resultadoEnElPartido;
        this.cantGolesEnELTorneo = cantGolesEnELTorneo;
    }
    //Creamos los Get
    public String getNombre() {
        return nombre;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public Resultado getResultadoEnElPartido() {
        return resultadoEnElPartido;
    }

    public int getCantGolesEnELTorneo() {
        return cantGolesEnELTorneo;
    }
    //Creamos los Set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public void setResultadoEnElPartido(Resultado resultadoEnElPartido) {
        this.resultadoEnElPartido = resultadoEnElPartido;
    }

    public void setCantGolesEnELTorneo(int cantGolesEnELTorneo) {
        this.cantGolesEnELTorneo = cantGolesEnELTorneo;
    }

    //Creamos una funcion que nos ayude a sumar los goles
    public void sumarGolesNuevos (int nuevosGoles) {
        this.cantGolesEnELTorneo += nuevosGoles;
    }

}
