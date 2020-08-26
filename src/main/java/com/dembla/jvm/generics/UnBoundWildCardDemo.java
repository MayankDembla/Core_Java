package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnBoundWildCardDemo {

    public static void main(String[] args) {

        Container<String> stringStore = new Store<>();
        stringStore.set("java");

        Container<?> someStore = stringStore ;
        Object object = someStore.get();
        System.out.println("Stored element: " + object);

        List<Integer> intList1 = Arrays.asList(1, 2);
        List<Integer> intList2 = Arrays.asList(3, 4);

        invalidAggregate(intList1, intList2, new ArrayList());
    }

    public static void invalidAggregate(List<?> l1, List<?> l2, List<?> l3) {
        //l3.addAll(l1); // null ok
        //l3.addAll(l2);
    }

}

interface Containers<T>{

    public void setValue(T values) ;

    public void getValue() ;

}

class Stroes<T> implements Container<T> {

    private T t ;

    @Override
    public void set(T a) {
       this.t = a ;
    }


    @Override
    public T get() {
        return t;
    }
}






