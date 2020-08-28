package com.dembla.jvm.generics;

import com.dembla.jvm.assertion.A;

import java.util.ArrayList;
import java.util.List;

public class InvateanceTest {

    public static void main(String[] args) {

//        invariancWorkAround(new ArrayList<String>());
        invariancWorkAround(new ArrayList<Integer>());

    }

    //   Invariance WorkAround
    static <T extends Number> void invariancWorkAround(List<T> list){

        // We can not add double here directly
//         list.add(22.2) ;

        // Typically Element of type T
        T element  = (T) new Double(23.3) ;
        list.add(element) ;
    }

}
