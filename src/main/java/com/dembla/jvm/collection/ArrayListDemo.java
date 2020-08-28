package com.dembla.jvm.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {

        arrylistdemo();

    }

    private static  void arrylistdemo(){

        List<Integer> list1 = new ArrayList<>() ;

        // populate
        list1.add(1);
        list1.add(3);
        list1.add(3);
        list1.add(2);
        list1.add(null);
        System.out.println("List : " + list1);

        list1.remove(3) ;
        System.out.println("List : " + list1);

        // Add 9 to zero index
        list1.add(0, 9) ;
        System.out.println("List : " + list1);

        // Set value at Zero Index
        list1.set(0,9) ;
        System.out.println("List : " + list1);


        // #### bulk operation ###### list1 [9,1,3,3,null]//
        Collection<Integer> list2 = new ArrayList<>();
        list2.add(9);
        list2.add(3);

        // Remove all elements from list 1 having element
        // present in list2
        list1.removeAll(list2);
        System.out.println("list1: " + list1);

        list2.add(1);

        // Opposite to the remove all
        // Retain the methods present in list2
        list1.retainAll(list2);
        System.out.println("list1: " + list1);

        list1.addAll(list2);
        System.out.println("list1: " + list1);

        // this will return the previous element which is changed
        // i.e. at index 2
        System.out.println("list1.set(2, 2): " + list1.set(2, 2));


        // ##### Search ###### [1,9,2,1]//
        System.out.println("list1.contains(1): " + list1.contains(1)); // true
        System.out.println("list1.indexOf(1): " + list1.indexOf(1)); // 0
        System.out.println("list1.lastIndexOf(1): " + list1.lastIndexOf(1)); // 3

        // ###  Range-view: subList (new list is backed by original)
        // list 1 = [1,9,2,1]

        // Change the sublist will reflect changes to the original list //
        List<Integer> list3 = list1.subList(2, 3);
        System.out.println(list3); // [2]
        list3.set(0, 6); // [6]
        System.out.println("list1: " + list1); // [1,9,6,1]
        list3.add(0, 7);
        System.out.println("list 3" + list3); // [7,6]
        System.out.println("list1: " + list1); // [1,9,7,6,1]

        // Change the original list //
        list1.set(2, 8); // [1,9,8,6,1]
        System.out.println("list3: " + list3); // [8,6]

        // When we make the Structural Changes in the backed array
        // We get the Exception of Concurrent Modification.
        // list1.add(0, 8);
        // System.out.println("list3: " + list3);
        System.out.println("list1: " + list1);


        for (int element : list1) {
            System.out.println("element: " + element);

            // Generates ConcurrentModificationException
            if (element == 9) {
//                list1.remove(Integer.valueOf(element)); // valueOf is used due to its caching
                  list1.set(0,2) ; // works fine
//                  list1.add(0) ;  // ConcurrentModificationException (No structural change allowed)
            }
        }

    }

}
