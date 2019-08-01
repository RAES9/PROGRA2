package com.company;

public class ListaDoblementeEnlazada {
    private Nodo primero;
    private  Nodo ultimo;

    public ListaDoblementeEnlazada(){
        primero = null;
        ultimo = null;
    }
    public void insertarInicio(int valor){
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        if (primero == null){
            primero = nuevo;
            ultimo = primero;
        }else{
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
            primero = nuevo;
        }
    }
    public void insertarFinal(int valor){
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        if (ultimo == null){
            ultimo = nuevo;
            primero = ultimo;
        }else{
            nuevo.anterior = ultimo;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    public void mostrar(){
        Nodo temporal = primero;
        while (temporal != null){
            System.out.print(temporal.valor + "->");
            temporal = temporal.siguiente;
        }
        temporal = ultimo.anterior;
        while (temporal != null){
            if (temporal.anterior != null) {
                System.out.print(temporal.valor + "->");
            }else{
                System.out.print(temporal.valor);
            }
            temporal = temporal.anterior;
        }
        System.out.println("");
    }

    public Nodo buscar(int valor){
        Nodo temporal = primero;
        while (temporal != null){
            if (temporal.valor == valor){
                return temporal;
            }
            temporal = temporal.siguiente;
        }
        return null;
    }

    public void eliminar(int valor){
        if (primero != null){
            Nodo temporal = primero;
            Nodo ant = null;
            while (temporal != null){
                if (temporal.valor == valor){
                    if (ant == null){
                        primero = primero.siguiente;
                        primero.anterior = null;
                        temporal = primero;

                    }else {
                        ant.siguiente = temporal.siguiente;
                        temporal = temporal.siguiente;
                        temporal.anterior = ant;
                    }
                }else{
                    ant = temporal;
                    temporal = temporal.siguiente;
                }
            }
        }

    }
}
