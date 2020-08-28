package com.dembla.jvm.collection;

import com.dembla.jvm.collection.model.Book;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
    
        hashsetDemo(); 
    }

    private static void hashsetDemo() {
        System.out.println("\n Inside HashSet Demo ");

        Set<String> set = new HashSet<>() ;
        set.add("a") ;
        set.add("b") ;
        set.add("a") ;

        // Elements must be a Unique
        System.out.println("Set is " + set);

        Book book = new Book("Walden","Henry Throu",1434) ;
        Book bookduplicate = new Book("Walden","Henry Throu",1434) ;
        Set<Book> bookset = new HashSet<>() ;

        bookset.add(book) ;
        bookset.add(bookduplicate) ;

        System.out.println("Book Set is : " + bookset);
    }


}
