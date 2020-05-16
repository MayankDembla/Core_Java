package com.dembla.abstraction.practice;

public class Test {

    public static void main(String[] args) {
        Shape shape1 = new Circle("Blue",5) ;
        System.out.println(shape1.toString())  ;

        shape1 = new Rectangle("Red" , 5,6) ;
        System.out.println(shape1.toString()) ;
    }

}
