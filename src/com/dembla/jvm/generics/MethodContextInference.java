package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.List;

public class MethodContextInference {

    public static void main(String[] args) {

       List<Integer> list =  /*(List<Integer>)*/ outerMethod(insideMethod()) ;
        System.out.println(list);
    }

    static <T> List<T> outerMethod(List<T> somelist){
        return somelist ;
    }

    static <T> List<T> insideMethod()  {
        List<String> list  =  new ArrayList<>() ;
        list.add("Mayank") ;

        return (List<T>)list ;
    }
}
