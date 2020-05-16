package com.dembla.inheritance.practice;

public class MultipleInheritanceSupport{  //  extends  ParentOne , Parent2  {    // Not Valid

    // Getting a Compilation Error as Multiple inheritance is not supported by Java.

    //From the code, we see that, on calling the method fun() using Test object will cause complications such as
    // whether to call Parent1’s fun() or Parent2’s fun() method.
}



class ParentOne{

    void fun(){
        System.out.println("Parent 1 ") ;
    }

}

class Parent2{

    void fun(){
        System.out.println("Parent 2") ;
    }

}