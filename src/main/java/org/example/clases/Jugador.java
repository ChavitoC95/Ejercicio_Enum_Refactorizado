package org.example.clases;

import javax.swing.*;
import java.util.List;

public class Jugador {
    // Creamos los Atributos
    private Equipo equipoSeleccionado;
    private int puntaje;
    //creamos los constructores vacio y sobrecargado
    public Jugador() {
    }

    public Jugador(Equipo equipoSeleccionado, int puntaje) {
        this.equipoSeleccionado = equipoSeleccionado;
        this.puntaje = puntaje;
    }
    //Creamos los Get
    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public int getPuntaje() {
        return puntaje;
    }
    //Creamos los Set
    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Funcion que nos ayuda a elegir nuestro equipo favorito
    public void elegirEquipo(List<Equipo> listaEquipos) {

        String listaDeLosEquiposM = "Seleccione su equipo:  \n ";

        for (int i = 0; i < listaEquipos.size(); i ++){
       listaDeLosEquiposM += (i+1) + "." + listaEquipos.get(i).getNombre() + "\n" ;
        }
        JOptionPane.showMessageDialog(null, listaDeLosEquiposM,
                "Seleccion de Equipo", JOptionPane.INFORMATION_MESSAGE);
        //Definimos e inicializamos las variables:

        int indiceEquipo;
        String indiceEquipoC;
        indiceEquipo = 0;
        indiceEquipoC = " ";

        //ciclo que nos ayuda a elegir el equipo

        do {
            indiceEquipoC = JOptionPane.showInputDialog(null, "Ingrese el indice que quiere " +
                    " selecionar", "Ingrear equipo", JOptionPane.INFORMATION_MESSAGE);
            indiceEquipo = Integer.parseInt(indiceEquipoC) -1;
        }while (indiceEquipo < 1 || indiceEquipo > 7);
        JOptionPane.showMessageDialog(null, "El equipo elegido es: " +
                listaEquipos.get(indiceEquipo).getNombre());
        this.equipoSeleccionado = listaEquipos.get(indiceEquipo);
    }
    //Funcion que nos ayuda a sumar los puntos
    public  void sumarPuntos(){
        if(equipoSeleccionado.isAutorizacion()){
            puntaje++;
        }
    }
}
