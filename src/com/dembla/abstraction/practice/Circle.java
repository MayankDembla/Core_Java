package com.dembla.abstraction.practice;

public class Circle extends  Shape {

    private double radius ;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius ;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString() {
        return "Circle Color is " + getColor() + " Area is : " + area() ;
    }
}
