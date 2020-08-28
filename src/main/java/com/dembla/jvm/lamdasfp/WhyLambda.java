package com.dembla.jvm.lamdasfp;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class WhyLambda {

    public static void main(String[] args) {

        // Using Anonymous class
        // 1. Have an Assosiated Object
        // 2. Instantiated on every use (unless declared as a singleton)
        // 3. Target type can have multiple methods
        Set<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }) ;

        // Using the Lambdas
        //1. No assosiated objects (invokedynamically) + compact representation
        //2. Memory allocation will be done only once for method
        //3. Works with only functional interfaces.
        Set<String> setUsingLambda = new TreeSet<>((s1,s2) ->  s1.length() - s2.length()) ;

    }

}
