package com.company;

public class HashTable {
    private final Integer size = 5;
    private NodoHash raiz;

    class NodoHash{
        int key;
        Pila pila = new Pila();
        NodoHash sig;
    }

    public HashTable(){
        for (int i = 0; i < size; i++){
            NodoHash nuevo = new NodoHash();
            nuevo.key = i;
            if (raiz == null){
                raiz = nuevo;
            }else{
                NodoHash temporal = raiz;
                while (temporal.sig != null){
                    temporal = temporal.sig;
                }
                temporal.sig = nuevo;
            }
        }
    }

    private Integer hash(int k){
        Integer key = 0;
        key = (k & 0xfffffff) % size;
        return key;
    }


    public void insertar(int k){
        NodoHash temporal = raiz;
        while (temporal.key != hash(k)){
            temporal = temporal.sig;
        }
        temporal.pila.insertar(k);
    }

    public void mostrarTodo(){
        for (int i = 0; i < size; i++){
            mostrarPorLlave(i);
        }
    }

    public void mostrarPorLlave(int k){
        NodoHash temporal = raiz;
        while (temporal.key != hash(k)){
            temporal = temporal.sig;
        }
        System.out.println("Key " + k);
        temporal.pila.imprimir();
    }
}
