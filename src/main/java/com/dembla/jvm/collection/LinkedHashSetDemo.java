package com.dembla.jvm.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        linkedhashsetDemo() ; 
    }

    private static void linkedhashsetDemo() {

        Set<String> hashSet = new HashSet<>() ;
        hashSet.add("Raj") ;
        hashSet.add("John") ;
        hashSet.add("Anita") ;
        System.out.println("HashSet: " + hashSet);

        Set<String> ls = new LinkedHashSet<>();
        ls.add("Raj");
        ls.add("John");
        ls.add("Anita");
        System.out.println("LinkedHashSet: " + ls) ;
    }
}
