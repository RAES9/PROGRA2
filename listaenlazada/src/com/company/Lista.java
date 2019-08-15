package com.company;

import java.util.ArrayList;

public class Lista {
    private  Nodo primero;
    public void insertar(int valor){
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        if (primero==null){
            primero = nuevo;
        }else{
            Nodo temporal = primero;
            while (temporal.siguiente != null){
                temporal = temporal.siguiente;
            }
            temporal.siguiente = nuevo;
        }
    }
    public void mostrar(){
        if (primero == null){
            System.out.println("La lista esta vacia");
        }else{
            Nodo temporal = primero;
            while (temporal != null){
                System.out.println(temporal.valor+"->");
                temporal = temporal.siguiente;
            }
            System.out.println("null");
            System.out.println("");
        }

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
            Nodo anterior = null;
            while (temporal != null){
                if (temporal.valor == valor){
                    break;
                }
                anterior = temporal;
                temporal = temporal.siguiente;
            }
            if (temporal == null){
                System.out.println("El valor que desea eliminar no existe");
            }else if (anterior == null){
                primero = primero.siguiente;
            }else{
                anterior.siguiente = temporal.siguiente;
            }
        }

    }
    public void borrarTodo(){
        primero = null;
    }
}
