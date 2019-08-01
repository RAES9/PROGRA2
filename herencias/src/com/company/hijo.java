package com.company;

public class hijo extends padre implements inter{
    @Override
    public void setX(Integer x) {
        super.setX(x);
    }

    @Override
    public void setY(Integer y) {
        super.setY(y);
    }

    @Override
    public Integer sumar() {
        return super.sumar();
    }

    public hijo(){
        setX(8);
        setY(15);
        System.out.println("Suma de X y Y: " + sumar());
        System.out.println("INTERFACE VALOR T :" + t);
    }

}
