package com.dembla.usethis.practice;

public class TestClass {

    // private instance variables
    private int a ;
    private int b ;

    TestClass(int a , int b){

        // 1. this used to refer the current class instance variables
        this.a = a ;
        this.b = b ;
    }

     TestClass(){

        // 2. To invoke the Constructor
         this(20,30) ;
         System.out.println("Inside Default Constructor") ;
     }

     // 3. Use this to return the current Object
     TestClass get(){
        return this ;
     }

     public  void display(){
        System.out.println("Displaying .... ") ;
     }

     public  void display(TestClass cl){
        System.out.println(cl.toString()) ;
     }

     public void gett(){
        // 4. Passing this as a Current Instance Object.
        display(this);
     }

     public  void invokemethod(){
        System.out.println("I am invoking") ;
        // 5. Invoking Method of current class.
        this.display();
     }

    public static void main(String[] args) {

        TestClass obj = new TestClass() ;
        obj.get().display();

        // by passing this to the method paramter
        obj.get().gett();
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
