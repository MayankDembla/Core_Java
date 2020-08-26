package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.List;

public class RawTypeDemo {

    public static void main(String[] args) {
        useRawTypeTest() ; 
    }

    private static void useRawTypeTest() {
        System.out.println("\n Inside Raw Type Test ... ");

        int ISBN = 1232423424 ;
        List<Double> prices = new ArrayList<>() ;

        HalfIntegrator.getPrice(ISBN, prices);
        Double price =  prices.get(0) ;
    }
}


class HalfIntegrator {

    public static void getPrice(int ISBN, List prices ){
       prices.add(45) ;
    }
}