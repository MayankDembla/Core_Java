package com.dembla.jvm.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class IteratorDemo {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        iteratorDemo(list);
    }


    private static void iteratorDemo(List<Integer> list1){
        System.out.println("\n Inside Iterator Demo ");
        System.out.println("list1 " + list1);

        Iterator<Integer> iterator = list1.iterator() ;

        while(iterator.hasNext()){
            int element = iterator.next() ;
            System.out.println("element : " + element);

            if(element == 2){
                iterator.remove();
                iterator.forEachRemaining(Filter::add);
            }
        }
        System.out.println(list1);

        list1.forEach(System.out::println); // method reference

        System.out.println("Using Filter");
        list1.forEach(Filter::filter);

        System.out.println("Using Consumer");
        list1.forEach(new Filter()); // as it implements the Consumer



    }

}

class  Filter implements Consumer {
    static void filter(Integer i ){
        if(i == 1)
            System.out.println(i);
    }


    @Override
    public void accept(Object o) {
        if((int) o == 3 ){
            System.out.println(o);
        }
    }

    static void add(Integer i){
        System.out.println(i + 7 );
    }
}


