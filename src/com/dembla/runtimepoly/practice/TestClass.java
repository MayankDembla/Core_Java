package com.dembla.runtimepoly.practice;

public class TestClass {

    public static void main(String[] args) {


     // Superclass type and subclass reference
     // Runtime compiler will decide according to the reference not type.
        A a = new A();
        a.m1();

        a = new B() ;
        a.m1();

        a = new C() ;
        a.m1();
    }
}


class  A{
    void m1(){
        System.out.println("Inside A's m1 method") ;
    }
}

class B extends  A {

    // Overriding method
    @Override
    void m1(){
      System.out.println("Inside B's m1 method") ;
    }
}

class C extends  A {

    @Override
    public  void m1(){
        System.out.println("Inside C's m1 method") ;
    }

}