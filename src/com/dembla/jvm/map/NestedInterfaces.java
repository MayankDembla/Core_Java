package com.dembla.jvm.map;

public class NestedInterfaces implements A.B {


    public static void main(String[] args) {

    }

    @Override
    public void getB() {

    }
}


interface A{

    void getA() ;

    interface B {
        void getB() ;
    }
}