package com.dembla.usethis.practice;

public class A {

    B obj ;

    A(B obj){
        this.obj = obj ;
        obj.display();
    }


}


class B{

    A objec ;

    B(){
        //Using ‘this’ keyword as an argument in the constructor call
        objec = new A(this) ;
    }

    public void display(){
        System.out.println("Displaying B") ;
    }

    public static void main(String[] args) {
        B obj = new B() ;
    }



}