package com.relevos.dominio;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Equipo {
    private String nombreEquipo;
    private ExecutorService organizador; 

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
      
        this.organizador = Executors.newSingleThreadExecutor();
    }

    public void iniciarCarrera() {
        System.out.println("El equipo " + nombreEquipo + " está listo en la línea de salida.");
        
       
        Corredor c1 = new Corredor(nombreEquipo + "-1");
        Corredor c2 = new Corredor(nombreEquipo + "-2");
        Corredor c3 = new Corredor(nombreEquipo + "-3");

       
        organizador.execute(c1);
        organizador.execute(c2);
        organizador.execute(c3);

       
        organizador.shutdown();
    }
}