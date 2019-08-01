package com.company;

public class ListaCircular {
    private Nodo primero;
    private  Nodo ultimo;

    public ListaCircular(){
        primero = null;
        ultimo = null;
    }
    public void insertar(int valor){
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        if(primero == null){
            primero = nuevo;
            ultimo = primero;
            primero.siguiente = ultimo;
        }else{
            ultimo.siguiente = nuevo;
            nuevo.siguiente = primero;
            ultimo = nuevo;
        }
    }
    public void mostrar(){
        if (primero == null){
            System.out.println("La lista esta vacia");
        }else {
            Nodo temporal = new Nodo();
            temporal = primero;
            do {
                System.out.println(temporal.valor + "->");
                temporal = temporal.siguiente;
            } while (temporal != primero);
        }
    }

    public Integer buscar(int valor){
        Nodo temporal = new Nodo();
        temporal = primero;
        do {
            temporal = temporal.siguiente;
            if (temporal.valor == valor){
                return temporal.valor;
            }
        }while (temporal != primero);
        return null;
    }

    public void eliminar(int valor) {
        Nodo temporal = new Nodo();
        temporal = primero;
        Nodo anterior = ultimo;
        Boolean encontro = false;
        do {
            if (temporal.valor == valor) {
                if (temporal == primero) {
                    primero = primero.siguiente;
                    ultimo.siguiente = primero;
                }else if(temporal == ultimo){
                    anterior.siguiente = ultimo.siguiente;
                    ultimo = anterior;
                }else{
                    anterior.siguiente = temporal.siguiente;
                }
                encontro = true;
            }
            anterior = temporal;
            temporal = temporal.siguiente;
        }while (temporal != primero);
        if (!encontro){
            System.out.println("El valor que ingreso no existe");
        }
    }
    public void borrarTodo(){
        primero = null;
        ultimo = null;
    }
}
