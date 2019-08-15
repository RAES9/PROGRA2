package com.company;

public class Pila {
    class Nodo {
        int info;
        Nodo sig;
    }

    private Nodo raiz;

    public Pila() {
        raiz=null;
    }

    public void insertar(int x) {
        Nodo nuevo;
        nuevo = new Nodo();
        nuevo.info = x;
        if (raiz==null)
        {
            nuevo.sig = null;
            raiz = nuevo;
        }
        else
        {
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }

    public void imprimir() {
        Nodo reco=raiz;
        while (reco!=null) {
            System.out.print("->" + reco.info);
            reco=reco.sig;
        }
        System.out.println();
    }

}
