package com.dembla.abstraction.practice;

public class Rectangle extends Shape {

    private double length ;
    private  double breadth ;

    Rectangle(String color, double length, double breadth){
        super(color);
        this.length = length ;
        this.breadth = breadth ;
    }

    @Override
    double area() {
        return length * breadth;
    }

    @Override
    public String toString() {
        return "Color is : " + getColor() + " Area is " + area();
    }
}
