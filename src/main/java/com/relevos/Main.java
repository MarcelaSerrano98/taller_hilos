package com.relevos;

import com.relevos.dominio.Equipo;

public class Main {
    public static void main(String[] args) {
        // Creamos equipos
        Equipo equipoRojo = new Equipo("Rojo");
        Equipo equipoAzul = new Equipo("Azul");

        // Arrancan la carrera
        equipoRojo.iniciarCarrera();
        equipoAzul.iniciarCarrera();
    }
}