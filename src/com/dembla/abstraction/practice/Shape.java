package com.dembla.abstraction.practice;

abstract class Shape {

   private String color ;

    // Abstract Methods
    abstract double area();
    public  abstract  String toString() ;

    // Abstract class can have the Constructor
    // But we can not make an Object.
    public Shape(String color){
        System.out.println("Shape Constructor Created !!") ;
        this.color = color ;
    }

    public String getColor(){
        return  color ;
    }
}
