package org.example.clases;

import java.util.ArrayList;
import java.util.List;

public class Llave {
    // Creamos los Atributos
    private List <Equipo> equiposDeLaLlave;
    private String nombreDeLaLlave;
    //creamos los constructores vacio y sobrecargado
    public Llave() {
    }

    public Llave(List<Equipo> equiposDeLaLlave, String nombreDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
        this.nombreDeLaLlave = nombreDeLaLlave;
    }
    //Creamos los Get
    public List<Equipo> getEquiposDeLaLlave() {
        return equiposDeLaLlave;
    }

    public String getNombreDeLaLlave() {
        return nombreDeLaLlave;
    }
    //Creamos los Set
    public void setEquiposDeLaLlave(List<Equipo> equiposDeLaLlave) {
        this.equiposDeLaLlave = equiposDeLaLlave;
    }

    public void setNombreDeLaLlave(String nombreDeLaLlave) {
        this.nombreDeLaLlave = nombreDeLaLlave;
    }

    //Funcion que nos ayuda a armar las llaves y dividir los equipos para empezar los partidos
    public void armarllaves(List<Equipo> listaGeneral, int indiceInicial) {
        List<Equipo> equiposLLave = new ArrayList<>();
        for(int i = indiceInicial; i < indiceInicial + 4; i++){
            equiposLLave.add(listaGeneral.get(i));
        }
        this.equiposDeLaLlave = equiposLLave;
    }


}
