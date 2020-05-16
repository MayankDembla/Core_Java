package com.dembla.inheritance.practice;

public class Test {

    public static void main(String[] args) {
        MountainBike bike = new MountainBike(3,100,25) ;
        System.out.println(bike.toString() + bike.getSpeed()) ;

        bike.applyBrakes(15);
        System.out.println("After Applying the Brakes : ") ;
        System.out.println(bike.toString() + "Speed" + bike.getSpeed()) ;

        bike.speedUp(35);
        System.out.println("After Incrementing the Brakes" + bike.getSpeed()) ;
        System.out.println(bike.toString()) ;
    }

}
