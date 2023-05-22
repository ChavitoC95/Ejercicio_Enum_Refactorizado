package org.example;

import org.example.clases.Equipo;
import org.example.clases.Jugador;
import org.example.clases.Llave;
import org.example.clases.Ronda;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Mensaje de bienvenida

        JOptionPane.showMessageDialog(null, "Bienvenidos");
                menu();  //Llamamos a la funcion Menu
    }
    public static void mostrarOpciones(){
        JOptionPane.showMessageDialog(null,"Seleccione una opcion:\n" +
                "1. Crear lista de equipos\n" +
                "2. Cargar los equipos\n" +
                "3. Elegir equipo\n" +
                "4. Crear llave derecha\n" +
                "5. Crear llave izquierda\n" +
                "6. Crear rondas\n" +
                "7. Jugar torneo\n" +
                "8. Mostrar resultado del torneo\n" +
                "0. Salir","Opciones",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void menu() {
        //selecionamos las opciones
        JOptionPane.showMessageDialog(null, "Bienvenido al Menu\n" +
                "Selecciona una de las siguientes opciones:");

        // Se definen las variables que se utilizarán durante la ejecución del programa.
        boolean salir;
        ArrayList<Equipo> listaDeEquipos;
        Jugador jugador;
        Llave llaveDerecha;
        Llave llaveIzquierda;
        Ronda ronda;
        String opcion;
        // Se inicializan las variables que se utilizarán durante la ejecución del programa.
        salir = true;
        listaDeEquipos = null;
        jugador = null;
        llaveDerecha = null;
        llaveIzquierda = null;
        ronda = null;
        opcion= " ";

        do {
            mostrarOpciones();
            // Se utiliza la función mostrarOpciones() para mostrar las opciones disponibles.
            opcion=JOptionPane.showInputDialog(null,"Ingrese la opcion: ",
                    "Ingreso opcion",JOptionPane.INFORMATION_MESSAGE);
            //Usamos un Switch para recorrer el programa
            switch (opcion) {
                case "1":
                    listaDeEquipos = crearListaDeEquipos(listaDeEquipos);
                    break;
                case "2":
                    agregarEquipos(listaDeEquipos);
                    break;
                case "3":
                    jugador = elegirEquipo(listaDeEquipos);
                    break;
                case "4":
                    llaveDerecha = crearLlaveDerecha(listaDeEquipos);
                    break;
                case "5":
                    llaveIzquierda = crearLlaveIzquierda(listaDeEquipos);
                    break;
                case "6":
                    ronda = crearRondas();
                    break;
                case "7":
                    jugarTorneo(ronda, llaveIzquierda, llaveDerecha, jugador);
                    break;
                case "8":
                    resultadoDelTorneo(jugador);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Saliendo", "Salida", JOptionPane.CLOSED_OPTION);
                    salir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Ingreso invalido");
            }

        } while (salir);
    }

    //Creamos la funcion para crear la lsita de Equipos

    public static ArrayList<Equipo> crearListaDeEquipos(ArrayList<Equipo> listaDeEquipos) {
        //usamos un condicional para crear la lista
    if (listaDeEquipos == null) {
        JOptionPane.showMessageDialog(null, "Se creo la lista de equipos"
                , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        return new ArrayList<Equipo>();
    } else {
        JOptionPane.showMessageDialog(null, "La lista de equipos ya se creo"
                , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        return listaDeEquipos;
    }
    }
    //Creamos una funcion para agregar los equipos a un ArrayList
    public static void agregarEquipos(ArrayList<Equipo> listaDeEquipos) {
        //Definimos e inicializamos las variables

        String opcion;
        opcion = " ";
        opcion = JOptionPane.showInputDialog(null, "Desea agregarl los equipos manualmente? SI/No");
        //Usamos un condicional para evaluar si cargamos manualmente los equipos o elegimos automaticamente
        if (opcion == "si") {
            cargarEquipoManualmente(listaDeEquipos);
        }
        // Si el usuario selecciona "no", cargamos los equipos automáticamente
        else {
            //creamos los equipos

            Equipo equipo1 = new Equipo("Belgica");
            Equipo equipo2 = new Equipo("Francia");
            Equipo equipo3 = new Equipo("Portugal");
            Equipo equipo4 = new Equipo("Brasil");
            Equipo equipo5 = new Equipo("Italia");
            Equipo equipo6 = new Equipo("Argelia");
            Equipo equipo7 = new Equipo("Alemania");
            Equipo equipo8 = new Equipo("Argentina");
            //añadimos al ArrayList los equipos
            listaDeEquipos.add(equipo1);
            listaDeEquipos.add(equipo2);
            listaDeEquipos.add(equipo3);
            listaDeEquipos.add(equipo4);
            listaDeEquipos.add(equipo5);
            listaDeEquipos.add(equipo6);
            listaDeEquipos.add(equipo7);
            listaDeEquipos.add(equipo8);
        }
        //Mostramos que ya se agregaron los equipos
        JOptionPane.showMessageDialog(null, "Se agregaron los equipos exitosamente"
                , "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }


    public static Jugador elegirEquipo(ArrayList<Equipo> listaDeEquipos) {
        //creamos al jugador

        Jugador jugador = new Jugador();
        jugador.elegirEquipo(listaDeEquipos); //Llamamos a la funcion elegir equipos
        return jugador;
    }

    public static Llave crearLlaveDerecha(ArrayList<Equipo> listaDeEquipos) {
        //creamos la llave derecha
        Llave llaveDerecha = new Llave();
        llaveDerecha.armarllaves(listaDeEquipos, 0);
        //asignamos los valores a la llave
        for(int i = 0; i < llaveDerecha.getEquiposDeLaLlave().size(); i++){
            System.out.println(llaveDerecha.getEquiposDeLaLlave().get(i).getNombre());
            JOptionPane.showMessageDialog(null, "La llave derecha esta compuesta por:"
                    + llaveDerecha.getEquiposDeLaLlave().get(i).getNombre()
                    , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }


        return llaveDerecha;
    }

    public static Llave crearLlaveIzquierda(ArrayList<Equipo> listaDeEquipos) {
        //creamos la llave izquierda

        Llave llaveIzquierda = new Llave();
        llaveIzquierda.armarllaves(listaDeEquipos, 4);
        //Asignamos los valores a la llave
        for(int i = 0; i < llaveIzquierda.getEquiposDeLaLlave().size(); i++){
            System.out.println(llaveIzquierda.getEquiposDeLaLlave().get(i).getNombre());
            JOptionPane.showMessageDialog(null, "La llave Izquierda esta compuesta por: "
                            + llaveIzquierda.getEquiposDeLaLlave().get(i).getNombre()
                    , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }

        return llaveIzquierda;
    }

    public static Ronda crearRondas() {
        // Creamos una Ronda
        Ronda ronda = new Ronda();
        JOptionPane.showMessageDialog(null, "Creamos la ronda"
                , "Informacion", JOptionPane.INFORMATION_MESSAGE);
        return ronda;
    }

    public static void jugarTorneo(Ronda ronda, Llave llaveIzquierda, Llave llaveDerecha, Jugador jugador) {
        //Utilizando las llaves creadas
        // llamamos a ronda, e invocamos la funcion que nos hace entrar a los cuartos, semis y final
        ronda.cuartosDeFinal(llaveIzquierda,llaveDerecha); //Cuartos

        jugador.sumarPuntos(); //Funcion que cuenta los puntos ganados
        ronda.semifinal(llaveIzquierda,llaveDerecha); //Semis

        jugador.sumarPuntos(); //Funcion que cuenta los puntos ganados

        ronda.finalTorneo(llaveIzquierda,llaveDerecha); //Final

        jugador.sumarPuntos(); //Funcion que cuenta los puntos ganados

    }
        //Creamos la funcion resultados
    public static void resultadoDelTorneo(Jugador jugador) {
        //Se muestra por pantalla el equipo ganador y los puntos
    JOptionPane.showMessageDialog(null,"Usted gano: " + jugador.getPuntaje() + " por haber elegido" +
            " a: " + jugador.getEquipoSeleccionado().getNombre());
    }
//Se crea la funcion de agregarequipos manualmente, que invocamos en la opcion 2
    public static void cargarEquipoManualmente(ArrayList<Equipo> listaDeEquipos){
        String nombreEquipo= null;
        for (int i = 0; i < 8; i++) {
            do{
                nombreEquipo = JOptionPane.showInputDialog(null, "Ingrese el nombre del equipo",
                        "Carga de equipos", JOptionPane.INFORMATION_MESSAGE);
                if(nombreEquipo==null || nombreEquipo.equals("")){
                    JOptionPane.showMessageDialog(null,"Ingrese un valor en la casilla","Error",JOptionPane.ERROR_MESSAGE);
                }
            }while(nombreEquipo==null || nombreEquipo.equals(""));
            listaDeEquipos.add(new Equipo(nombreEquipo));
    }
    }
}