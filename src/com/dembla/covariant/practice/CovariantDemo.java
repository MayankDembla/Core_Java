package com.dembla.covariant.practice;

public class CovariantDemo {

    public static void main(String[] args) {
        Base base = new Derived() ;
        base.fun();
    }

}


class  A {
}

class B extends  A {
}


class Base{
    A fun(){
        System.out.println("Base Fun()") ;
        return  new A();
    }
}

class Derived extends Base{

    // Covariant return type As B Extends A
      B fun(){
         System.out.println("Derived fun()") ;
         return new B();
     }

}