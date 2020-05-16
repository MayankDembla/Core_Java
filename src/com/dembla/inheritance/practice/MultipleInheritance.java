package com.dembla.inheritance.practice;

public class MultipleInheritance  {

    public static void main(String[] args) {

        ThirdInterface test = new Testing() ;

    }
}


class Testing implements  ThirdInterface{

    @Override
    public void getMessage() {
        System.out.println("Messaging ... ") ;
    }

    @Override
    public void fun() {
       System.out.println("Funning") ;
    }

    @Override
    public void printMessage() {
       System.out.println("Printing another ....") ;
    }
}