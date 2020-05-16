package com.dembla.override.practice;

/**
 * Overriding and Access-Modifiers
 * can allow more, but not less,
 */
public class Test {

    public static void main(String[] args) {
        Parent parent = new Child() ;
        parent.m2();

        Parent obj2 = new Parent() ;
        obj2.m2();

    }

}

class Parent{

    // private method can not be overridden
    private void m1(){
        System.out.println("Parent M1() private") ;
    }

     protected void m2(){
        System.out.println("parent M2() protected") ;
    }
}

class Child extends Parent{
     // new m1 method
     // unique to Child Class
    private  void m1(){
       System.out.println("Chils M1 Private") ;
    }

    // Can Make it public but not private
    @Override
    public void m2(){
     System.out.println("Childs M2 Public");
    }

}