package com.dembla.inheritance.practice;

public class DiamondProblem extends Parent1 { // extends parrent 1 , parent2 // Not Valid

    public static void main(String[] args) {
        GrandParent p = new ParentTwo() ;
        p.fun();

       DiamondProblem d = new DiamondProblem() ;
       d.test();
    }

    public void test(){
        fun() ;
    }

}


class GrandParent{
    void fun(){
        System.out.println("GrandParent") ;
    }
}

class Parent1 extends GrandParent{

    @Override
    void fun(){
     System.out.println("Parent1");
    }
}

class ParentTwo extends GrandParent {

    @Override
    void fun(){
        System.out.println("Parent 2") ;
    }

}