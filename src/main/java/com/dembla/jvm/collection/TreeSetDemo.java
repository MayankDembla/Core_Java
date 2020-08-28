package com.dembla.jvm.collection;

import com.dembla.jvm.collection.model.Book;

import java.util.*;

public class TreeSetDemo {

    public static void main(String[] args) {
//        treeSetDemo() ;
        treesetDemo2();
    }

    private static void treeSetDemo() {

        Book book1 = new Book("harry Potter", "J.K.Rowling", 1997);
        Book book2 = new Book("harry Potter", "J.K.Rowling", 1967);
        Book book3 = new Book("walden", "Henry David", 1997);
        Book book4 = new Book("harry Potter", "J.K.Rowling", 1967);
        Book book5 = new Book("effective Java", "Joshua BLoch", 2020);

        Set<Book> books = new TreeSet<>(new TitleComparator());

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book b : books) {
            System.out.println(b);
        }
    }


    private static  void treesetDemo2(){

        NavigableSet<Integer> navi = new TreeSet<>() ;

        navi.add(5) ;
        navi.add(23) ;
        navi.add(74) ;
        navi.add(89) ;

        System.out.println("Lower is " + navi.lower(74));
        System.out.println("Floor is " + navi.floor(74));
        System.out.println("Ceiling is " + navi.ceiling(74));
        System.out.println("Higher is " + navi.higher(74));

        System.out.println("First is " + navi.first());
        System.out.println("First is " + navi.last());

        NavigableSet<Integer> navinew = navi.descendingSet() ;
        System.out.println("New is " + navinew) ;
        System.out.println("Old is " + navi) ;

        // Getting Head Set
        NavigableSet<Integer> headtest = navi.headSet(74,false) ;
        System.out.println("HaeadSet is " + headtest) ;

        //** Note Adding will reflect the original Set as well.

        System.out.println("Before adding to the HeadTest (Popluated from original Set) " + navi);
        headtest.add(6) ;
        System.out.println("HaeadSet After Adding 6 is` " + headtest) ;

        // this will reflect the original one
        System.out.println("After Addition of the Element in the headtest " + navi);

        //** Note Adding Element to the Original Set will reflect the Array which id populated from it

        System.out.println("Before Adding to the Original Set " + headtest);
        navi.add(17) ;
        System.out.println("Navi Set is " + navi);
        System.out.println("After Adding the 7 in the original Set : " + headtest );

        // Throws Exception if we add the Criteria we set intially is not  followed.

//        NavigableSet<Integer> headtest_ = navi.headSet(74,false) ;
//        headtest_.add(100) ;

       SortedSet<Integer> sorted = navi.subSet(5,74) ;




    }
}


class TitleComparator implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        return ((Book)o1).getName().compareTo(((Book)o2).getName());
    }
}