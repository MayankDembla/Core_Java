package com.dembla.inheritance.practice;

// Base Class
public class Bicycle {

     private int gear ;
     private int speed ;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrakes(int decrement){
        speed-=decrement ;
    }

    public void speedUp(int increment){
        speed += increment ;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "gear=" + gear +
                ", speed=" + speed +
                '}';
    }
}
