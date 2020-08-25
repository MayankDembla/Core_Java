package com.dembla.jvm.lifetimeoftype;

public class Test extends  Test2{

    static {
        System.out.println("Test Static Block");
    }

    {
        System.out.println("Initializer Block ");
    }


    Test(){
        System.out.println("Constructor.. ");
    }


    public static void main(String[] args) {
        Test t = new Test() ;
    }
}


class Test2
{
    static {
        System.out.println("Test 2 Static Block");
    }

    Test2(){
        System.out.println("Test 2 Constructor");
    }

    {
        System.out.println("Initializer Block Test 2");
    }
}

interface Test3{

   

}