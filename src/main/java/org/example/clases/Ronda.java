package org.example.clases;

import javax.print.attribute.standard.JobPriority;
import javax.swing.*;
import java.util.List;

public class Ronda {
    // Creamos los Atributos
    private int numeroDeRonda;
    private  int cantidadEquiposEnRonda;
    private int cantidadEquiposEnLlave;
    //creamos los constructores vacio y sobrecargado
    public Ronda() {
    }

    public Ronda(int numeroDeRonda, int cantidadEquiposEnRonda, int cantidadEquiposEnLlave) {
        this.numeroDeRonda = numeroDeRonda;
        this.cantidadEquiposEnRonda = cantidadEquiposEnRonda;
        this.cantidadEquiposEnLlave = cantidadEquiposEnLlave;
    }
    //Creamos los Get
    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public int getCantidadEquiposEnRonda() {
        return cantidadEquiposEnRonda;
    }

    public int getCantidadEquiposEnLlave() {
        return cantidadEquiposEnLlave;
    }
    
    //Creamos los Set
    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public void setCantidadEquiposEnRonda(int cantidadEquiposEnRonda) {
        this.cantidadEquiposEnRonda = cantidadEquiposEnRonda;
    }

    public void setCantidadEquiposEnLlave(int cantidadEquiposEnLlave) {
        this.cantidadEquiposEnLlave = cantidadEquiposEnLlave;
    }
    //Funcion que realiza los cuartos de final.
    
    public void cuartosDeFinal(Llave llaveIzquierda, Llave llaveDerecha){
        this.numeroDeRonda = 1;
        this.cantidadEquiposEnLlave = 4;
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null, "Se jugaran los cuartos de Final" , "Cuartos de Final",
                JOptionPane.INFORMATION_MESSAGE);
        //Ciclo que nos ayuda a que no haya errores a la hora de simular los partidos entre los euqipos de las llaves
        for (int i = 0; i < cantidadEquiposEnLlave; i+=2){
            partido.simularpartido(llaveIzquierda.getEquiposDeLaLlave().get(i),llaveIzquierda.getEquiposDeLaLlave().get(i+1) );
            partido.simularpartido(llaveDerecha.getEquiposDeLaLlave().get(i),llaveDerecha.getEquiposDeLaLlave().get(i+1) );
        }
        //usamos la funcion que nos elimina a los equipos perdedores
        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        this.cantidadEquiposEnLlave=2;
    }
    //Funcion que elimina a los equipos perdedores
    public void removerEquipos(List<Equipo> equipos){
        int contadorEquiposPorLlave = cantidadEquiposEnLlave;
        for(int i = 0; i < contadorEquiposPorLlave; i++){
            Equipo auxiliar = equipos.get(i);
            if (!auxiliar.isAutorizacion()){
                equipos.remove(auxiliar);
                contadorEquiposPorLlave--;
            }

        }

    }
    //Funcion que nos ayuda a realizar las semifinales

    public void semifinal(Llave llaveIzquierda, Llave llaveDerecha){
        this.numeroDeRonda = 2;
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null, "Se jugara las semifinales" , "Semifinal",
                JOptionPane.INFORMATION_MESSAGE);
            partido.simularpartido(llaveIzquierda.getEquiposDeLaLlave().get(0),
                    llaveIzquierda.getEquiposDeLaLlave().get(1));
            partido.simularpartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                    llaveDerecha.getEquiposDeLaLlave().get(1) );
        //removemos a los perdedores

        removerEquipos(llaveIzquierda.getEquiposDeLaLlave());
        removerEquipos(llaveDerecha.getEquiposDeLaLlave());
        this.cantidadEquiposEnLlave=1;
    }
    //Funcion que nos deja jugar la final del torneo
    public void finalTorneo(Llave llaveIzquierda, Llave llaveDerecha){
        this.numeroDeRonda = 1;
        Partido partido = new Partido();
        JOptionPane.showMessageDialog(null, "Se jugara la final" , "Final",
                JOptionPane.INFORMATION_MESSAGE);
        Equipo equipo = partido.simularpartido(llaveDerecha.getEquiposDeLaLlave().get(0),
                llaveIzquierda.getEquiposDeLaLlave().get(0));
        JOptionPane.showMessageDialog(null, "El ganador del torneo es: " +
                equipo.getNombre() , "Ganador",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
