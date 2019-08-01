package com.company;

public class Main {

    public static void main(String[] args) {
	    Lista milista = new Lista();
	    milista.insertar(1);
        milista.insertar(2);
        milista.insertar(3);
        milista.insertar(4);
        milista.mostrar();
        if (milista.buscar(4) != null){
            System.out.println("Existe el valor " + milista.buscar(4).valor);
        }
        milista.eliminar(3);
        milista.mostrar();

        System.out.println("LISTA CIRCULAR PAPU :v");
        ListaCircular l = new ListaCircular();
        l.insertar(1);
        l.insertar(2);
        l.insertar(3);
        l.insertar(4);
        l.mostrar();
        if (l.buscar(3) != null){
            System.out.println("Existe el valor " + l.buscar(3));
        }else{
            System.out.println("El valor que ingreso no existe");
        }
        l.eliminar(10);
        l.mostrar();
        l.borrarTodo();
        l.mostrar();
    }
}
