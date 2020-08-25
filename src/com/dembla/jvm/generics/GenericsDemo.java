package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {

        Container<String> stringContainer = new Store<>() ;
        stringContainer.set("Mayank");
        System.out.println(stringContainer.get());

        Container<Boolean> booleanContainer = new Store<>() ;
        booleanContainer.set(true);
        System.out.println(booleanContainer.get());

        Container<List<Integer>> listContainer = new Store<>() ;
        listContainer.set(Arrays.asList(1,2,3));
        System.out.println(listContainer.get()) ;

        // Restriction 1 : Type Argument can't be primitive
        // Container<int> intContainer  = new Store<>() ;

        // Restriction 2 : Can not use in the Static Context

        List<Number> list = new ArrayList<>() ; // Can Store SubType
        list.add(new Integer(34)) ;
        list.add(new Double(34.554)) ;
       // list.add(new String("dsf")) ;

        List[] array = new List[2] ; // new ArrayList[2] ;
        array[0] = new ArrayList() ;
        array[1] = new LinkedList() ;

    }
}


interface Container<T>{
    void set(T a) ;
    T get() ;
}

class Store<T> implements Container<T>{

    private T a ;

    @Override
    public void set(T a) {
      this.a = a ;
    }

    @Override
    public T get() {
        return a;
    }
}
