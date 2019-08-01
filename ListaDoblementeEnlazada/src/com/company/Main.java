package com.company;

public class Main {

    public static void main(String[] args) {
	    ListaDoblementeEnlazada l = new ListaDoblementeEnlazada();
	    l.insertarFinal(1);
        l.insertarFinal(7);
        l.insertarFinal(3);
        l.insertarFinal(10);
        l.insertarFinal(35);
        l.insertarInicio(0);
        if (l.buscar(35) == null){
            System.out.println("EL valor que ingreso no existe");
        }else {
            System.out.println("Si existe el valor " + l.buscar(35).valor);
        }
        l.mostrar();
        l.eliminar(3);
        l.mostrar();
    }
}
