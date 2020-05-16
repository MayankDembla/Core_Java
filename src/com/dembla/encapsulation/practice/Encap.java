package com.dembla.encapsulation.practice;

public class Encap {

    private String name ;
    private int rollNumber ;
    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class TestEnCapsulation{

    public static void main(String[] args) {
        Encap obj = new Encap() ;

        // setting values of the variables
        obj.setName("Harsh");
        obj.setAge(19);
        obj.setRollNumber(51);

        System.out.println("Geek's name: " + obj.getName());
        System.out.println("Geek's age: " + obj.getAge());
        System.out.println("Geek's roll: " + obj.getRollNumber());

        // Direct access of variables is not possible

    }

}