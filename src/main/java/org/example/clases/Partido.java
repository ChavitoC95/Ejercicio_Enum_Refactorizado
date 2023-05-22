package org.example.clases;

import org.example.enumeraciones.Resultado;

import javax.swing.*;

public class Partido {
    // Creamos los Atributos
    private int golesEquipoLocal = 2;
    private int golesEquipoVisitante = 3;
    //creamos los constructores vacio y sobrecargado
    public Partido() {
    }

    public Partido(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    //Creamos los Get
    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }
    //Creamos los Set
    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    //Creamos la funcion que nos permite realizar los partidos y decirnos quien gano, perdio,
    public Equipo simularpartido (Equipo equipoLocal, Equipo equipoVisitante) {
        JOptionPane.showMessageDialog( null, equipoLocal.getNombre() + " " + this.golesEquipoLocal + " - "
        + this.golesEquipoVisitante + " " + equipoVisitante.getNombre(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        equipoLocal.sumarGolesNuevos(this.golesEquipoLocal);
        equipoVisitante.sumarGolesNuevos(this.golesEquipoVisitante);

        //Condicional que nos ayuda a determinar un ganador, perdedor o empate

        if ( this.golesEquipoLocal  > this.golesEquipoVisitante){
            equipoVisitante.setAutorizacion(false);
            equipoVisitante.setResultadoEnElPartido(Resultado.Perdedor);
            equipoLocal.setResultadoEnElPartido(Resultado.Ganador);
           // JOptionPane.showMessageDialog(null, "Gano " + equipoLocal.getNombre(), "Resultado",
             //       JOptionPane.INFORMATION_MESSAGE);
            return equipoLocal;
        } else if (this.golesEquipoLocal  == this.golesEquipoVisitante) {
            JOptionPane.showMessageDialog(null, "Se jugara el desempate entre " + equipoLocal.getNombre()
            + " " + equipoVisitante.getNombre() , "Resultado" , JOptionPane.INFORMATION_MESSAGE);
            equipoLocal.setResultadoEnElPartido(Resultado.Empate);
            equipoVisitante.setResultadoEnElPartido(Resultado.Empate);
            simularpartido(equipoLocal, equipoVisitante);
        } else {
            equipoLocal.setAutorizacion(false);
            equipoLocal.setResultadoEnElPartido(Resultado.Perdedor);
            equipoVisitante.setResultadoEnElPartido(Resultado.Ganador);
            //JOptionPane.showMessageDialog(null, "Gano " + equipoVisitante.getNombre(), "Resultado",
              //      JOptionPane.INFORMATION_MESSAGE);
            return equipoVisitante;

        }
        return null;
    }

}
