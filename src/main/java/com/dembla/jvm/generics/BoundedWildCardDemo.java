package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BoundedWildCardDemo<E> {

    public static void main(String[] args) {

        List<Integer>  l ;


        List<Integer> intList = Arrays.asList(1,2,3,4) ;
        display(intList);
        displayUsingGenericMethod(intList) ;

        List<Double> doubleList = Arrays.asList(1.2,2.3) ;
        display(doubleList);
        displayUsingGenericMethod(doubleList);

        List<String> stringList = Arrays.asList("ds","dsf","fhg") ;
//        display(stringList);
//        displayUsingGenericMethod(stringList);


        // Type Parameterized Array - Not  Exist

        Object[] ar =  new ArrayList[2] ;

        ar[0] = new ArrayList<String>() ;
        ar[1] = new LinkedList<Integer>() ;
    }

    static void display(List<? extends Number> lis){

        for(Number element : lis){
            System.out.println("display()/element " + element);
        }

//        lis.add(23) ; - Not Allowed as uses Class Type Parameter
    }

    static <T extends Number> void displayUsingGenericMethod(List<T> list){

        for (Number n : list){
            System.out.println("display()/Number : " + n );
        }

    }


}
