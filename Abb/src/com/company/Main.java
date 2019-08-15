package com.company;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Abb arbolito = new Abb();
        arbolito.insertar(50);
        arbolito.insertar(55);
        arbolito.insertar(53);
        arbolito.insertar(52);
        arbolito.insertar(54);
        arbolito.insertar(57);
        arbolito.insertar(59);
        arbolito.insertar(56);
        arbolito.insertar(1);
        arbolito.insertar(0);
        arbolito.insertar(9);
        arbolito.insertar(80);
        arbolito.insertar(-1);

        arbolito.inOrder();
        escribir("diagrama.dot", arbolito.graphizinOrden());
        dibujar("diagrama.dot", "diagrama.png");
    }

    public static void dibujar(String rutaArchivoDot, String rutaArchivoPng) {
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", rutaArchivoPng, rutaArchivoDot);
            pbuilder.redirectErrorStream(true);
            pbuilder.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void escribir(String rutaArchivo, String contenido) {
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            fichero = new FileWriter(rutaArchivo);
            pw = new PrintWriter(fichero);
            pw.write(contenido);
            pw.close();
            fichero.close();
        } catch (Exception e) {
            System.out.println("Error al tratar de escribir el archivo: " + e.getMessage());
        } finally {
            try {

            } catch (Exception e) {
                System.out.println("No se pudo cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
