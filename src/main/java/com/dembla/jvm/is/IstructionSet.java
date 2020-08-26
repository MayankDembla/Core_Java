package com.dembla.jvm.is;

public class IstructionSet {

    public static void main(String[] args) {

        Object hello = new IstructionSet() ;

        System.out.println(hello.toString()) ;
    }

    @Override
    public String toString() {

        System.out.println("Hello World ");

        return "Hello";
    }
}
