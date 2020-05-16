package com.dembla.overload.practice;

public class Test {

    public int sum(int x, int y){
         return (x+y) ;
    }

   public int sum(int x, int y, int z){
        return  (x+y+z) ;
   }

   public double sum(double x, double y){
        return  (x+y) ;
   }

    public static void main(String[] args) {

        Test test = new Test() ;
        System.out.println(test.sum(10,20)) ;
        System.out.println(test.sum(10,20,30)) ;
        System.out.println(test.sum(10.5,20.5)) ;

        byte a = 25 ;
        test.show(a); // go to byte
        test.show("Mayank"); // go to String
        test.show(250); // go to int
        test.show('A'); //Char is Not present datatype highr is Int so to Int
        test.show("A"); // go for String
 //       test.show(7.5); // Since Float not present no higher thing present so error.

    }

    public void show(int x){
        System.out.println("In int" + x) ;
    }

    public void show(String str){
        System.out.println("In String " + str) ;
    }

    public  void show(byte b){
        System.out.println("In Byte " + b) ;
    }



}
