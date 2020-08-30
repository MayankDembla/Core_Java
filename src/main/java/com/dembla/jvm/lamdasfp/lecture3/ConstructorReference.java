package com.dembla.jvm.lamdasfp.lecture3;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {

        // Constructor Reference
        Supplier<String> supplier = String::new ; // () -> new String() ;
        System.out.println(supplier.get());

        Function<String,String> function = String::new ;
        System.out.println(function.apply("Hello"));

        BiFunction<Integer,Float, HashMap> biFunction = HashMap::new;
                         // initial capacity and load factor
        biFunction.apply(23,45.5f) ;

    }

}


