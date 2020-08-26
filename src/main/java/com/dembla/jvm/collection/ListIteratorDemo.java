package com.dembla.jvm.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

    public static void main(String[] args) {
        listIteratorDemo();
    }

    public static void listIteratorDemo(){
        System.out.println("\n Inside List Iterator Demo Method ... " );

        List<String> list = new ArrayList<>() ;
        list.add("a") ;
        list.add("b") ;
        list.add("c") ;
        list.add("d") ;
        list.add("e") ;

        System.out.println("\n Displaying Current element");
        // Keep Pointer in mind it is in mod of two index.
        for(ListIterator<String> iterator = list.listIterator(); iterator.hasNext(); ){
            System.out.println("Iterator.nextIndex: " + iterator.nextIndex() + " , iterator " + iterator.next());
        }

        System.out.println("\n Add , Remove and Set Operation ");

        for(ListIterator iterator = list.listIterator(); iterator.hasNext(); ){
            System.out.println("iterator.nextIndex : " + iterator.nextIndex() + ", iterator " + iterator.next()) ;

            if(iterator.nextIndex() == 1 ){
                System.out.println(" Adding test at Index 1 ");
                System.out.println("Before add " + iterator.nextIndex());
                iterator.add("test");
                System.out.println("Iterator.nextIndex " + iterator.nextIndex() + " , iterator.next  " + iterator.next());

                // Removing test that was just added.
                iterator.previous();
                iterator.previous();
                System.out.println("Before Remove  " + iterator.nextIndex());
                iterator.remove();
                System.out.println("Iterator.nextIndex " + iterator.nextIndex() + " , iterator.next  " + iterator.next());
               // Below will give the Illegal State Exception
                // Set Should be preceeded by the next/previous/set
                System.out.println("Next Index is : " + iterator.nextIndex());
                iterator.set("test");
                iterator.set("test1");

            }
        }

        System.out.println(list);
    }
}
