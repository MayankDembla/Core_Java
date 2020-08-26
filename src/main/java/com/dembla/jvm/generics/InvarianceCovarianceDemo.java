package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.List;

public class InvarianceCovarianceDemo {

    public static void main(String[] args) {

//        go(new ArrayList<Integer>()) ; // Compile time
        go(new Integer[1]) ;
    }

    // Invariance
    static void go(List<Number> list) {


    }

    // Covariance
    static void go(Number[] list){
      list[0] = 24.4 ;   // Run time Exception
    }

}
