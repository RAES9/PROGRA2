package com.company;

public class Abb {
    private String textoInOrden;

    private class nodoArbol {
        private Abb hd;
        private Abb hi;
        private int dato;


        private void nodoArbol() {
            hd = null;
            hi = null;
            dato = 0;
        }
    }

    public nodoArbol raiz;

    public void abb() {
        nodoArbol raiz = new nodoArbol();
    }

    private boolean esVacio() {
        return (raiz == null);
    }

    public void insertar(int a) {
        if (esVacio()) {
            nodoArbol nuevo = new nodoArbol();
            nuevo.dato = a;
            nuevo.hd = new Abb();
            nuevo.hi = new Abb();
            raiz = nuevo;
        } else {
            if (a > raiz.dato) {
                (raiz.hd).insertar(a);
            }
            if (a < raiz.dato) {
                (raiz.hi).insertar(a);
            }
        }
    }

    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.dato + ", ");
            raiz.hi.preOrder();
            raiz.hd.preOrder();
        }
    }

    public void inOrder() {
        textoInOrden = "";
        if (!esVacio()) {
            raiz.hi.inOrder();
            System.out.print(raiz.dato + ", ");
            raiz.hd.inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.hd.posOrder();
            raiz.hi.posOrder();
            System.out.print(raiz.dato + ", ");
        }
    }

    public Abb buscar(int a) {
        Abb arbolito = null;
        if (!esVacio()) {
            if (a == raiz.dato) {
                return this;
            } else {
                if (a < raiz.dato) {
                    arbolito = raiz.hi.buscar(a);
                } else {
                    arbolito = raiz.hd.buscar(a);
                }
            }
        }
        return arbolito;
    }

    private int buscarMin() {
        Abb arbolActual = this;
        while (!arbolActual.raiz.hi.esVacio()) {
            arbolActual = arbolActual.raiz.hi;
        }
        int devuelvo = arbolActual.raiz.dato;
        arbolActual.raiz = null;
        return devuelvo;
    }

    private boolean esHoja() {
        boolean hoja = false;
        if ((raiz.hi).esVacio() && (raiz.hd).esVacio()) {
            hoja = true;
        }
        return hoja;
    }

    public String graphizinOrden() {
        String texto = "digraph G \n" +
                "{\n" +
                " node [shape=circle];\n" +
                " node [style=filled];\n" +
                " node [fillcolor=\"#EEEEEE\"];\n" +
                " node [color=\"#EEEEEE\"];\n" +
                " edge [color=\"#31CEF0\"];\n";
        nodoArbol iz = null;
        nodoArbol dr = null;
        while (raiz != null) {
            if (iz == null) {
                iz = raiz.hd.raiz;
                dr = raiz.hd.raiz;
            }
            if (raiz.hd.raiz != null) {
                texto += raiz.dato + " -> " + raiz.hd.raiz.dato + ";\n";
            }
            if (raiz.hi.raiz != null) {
                texto += raiz.dato + " -> " + raiz.hi.raiz.dato + ";\n";
            }
            raiz = raiz.hi.raiz;
        }
        while (iz!=null){
            try {
                if (iz != null) {
                    if (iz.hd.raiz != null) {
                        texto += iz.dato + " -> " + iz.hd.raiz.dato + ";\n";
                    }
                    if (iz.hi.raiz != null) {
                        texto += iz.dato + " -> " + iz.hi.raiz.dato + ";\n";
                    }
                    iz = iz.hd.raiz;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                iz=null;
            }
        }
        while (dr != null) {
            try {
                if (dr != null) {
                    if (dr.hd.raiz != null && !texto.contains(dr.dato + " -> " + dr.hd.raiz.dato + ";\n")) {
                        texto += dr.dato + " -> " + dr.hd.raiz.dato + ";\n";
                    }
                    if (dr.hi.raiz != null && !texto.contains(dr.dato + " -> " + dr.hi.raiz.dato + ";\n")) {
                        texto += dr.dato + " -> " + dr.hi.raiz.dato + ";\n";
                    }
                    dr = dr.hi.raiz;
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                dr=null;
            }
        }
        texto += "rankdir=TP;\n" + "}";
        return texto;
    }

    public void eliminar(int a) {
        Abb paraEliminar = buscar(a);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else {
                if (!paraEliminar.raiz.hi.esVacio() && !paraEliminar.raiz.hd.esVacio()) {
                    paraEliminar.raiz.dato = paraEliminar.raiz.hd.buscarMin();
                } else {
                    if (paraEliminar.raiz.hi.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.hd.raiz;
                    } else {
                        paraEliminar.raiz = paraEliminar.raiz.hi.raiz;
                    }
                }
            }
        }
    }
}