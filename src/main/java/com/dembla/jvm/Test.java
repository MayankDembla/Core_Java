package com.dembla.jvm;

import com.dembla.jvm.dummy.ProClass;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Test {

    // Declaring instance variable with name `x`
    String x = "Parent`s Instance Variable";

    public void printInstanceVariable() {
        System.out.println(x);
    }

    public void printLocalVariable() {
        // Shadowing instance variable `x` with a local variable with the same name
        String x = "Local Variable";
        System.out.println(x);
        // If we still want to access the instance variable, we do that by using `this.x`
        System.out.println(this.x);
    }

    public static void main(String[] args) {

//        ProClass object = new ProClass(){} ;
//        object.test() ;

        test() ;
        new Test().printLocalVariable();

    }


    public static void test(){
        Integer count = 0 ;

        List<Integer> test = new ArrayList<>() ;
        test.add(count) ;
        int temp = test.get(0) ;
        test.set(0,6) ;

        System.out.println(count) ;
        System.out.println(test) ;
    }
}
