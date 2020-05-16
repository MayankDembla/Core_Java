package com.dembla.inheritance.practice;

public class SingleInheritance extends One {

   public void print_two(){
       value = 90 ;
       System.out.println("Two") ;
       print_one();
   }

    public static void main(String[] args) {
        new SingleInheritance().print_two();


    }

}


class One{

    protected int value ;

    protected void print_one(){
        System.out.println("One") ;
    }
}
