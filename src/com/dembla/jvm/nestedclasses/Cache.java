package com.dembla.jvm.nestedclasses;

import com.dembla.jvm.collection.model.Book;

import java.util.Arrays;
import java.util.Comparator;

public class Cache {

    private BookMark[] items ;
    private  int next  = 0 ;

    private Cache(int size) {
        items = new BookMark[size] ;
    }

    public void add(BookMark item) {
        if(next < items.length)
            items[next++] = item ;
    }

    // Or We can add the private static fields
 /*   private static  final Comparator<BookMark> RATING_COMPARATOR = new Comparator<BookMark>() {
        @Override
        public int compare(BookMark o1, BookMark o2) {
            return o1.getRating() > o2.getRating() ? 1 : -1 ;
        }
    } ;*/

    public static void main(String[] args) {

        Cache recommand = new Cache(3) ; // Creates the Instance of the Inner class.

        // Adding the data to array
        BookMark item1 = new BookMark() ;
        item1.setId(2000);
        item1.setTitle("Mayank");
        item1.setRating(14.4);

        BookMark item2 = new BookMark() ;
        item2.setId(3000);
        item2.setTitle("Dembla");
        item2.setRating(24.4);

        BookMark item3 = new BookMark() ;
        item3.setId(4000);
        item3.setTitle("Mappy");
        item3.setRating(34.4);

        BookMark item4 = new BookMark() ;
        item4.setId(5000);
        item4.setTitle("Manny");
        item4.setRating(44.4);

        BookMark item5 = new BookMark() ;
        item5.setId(6000);
        item5.setTitle("Auppy");
        item5.setRating(54.4);

        recommand.add(item4);
        recommand.add(item5);
        recommand.add(item1);
        recommand.add(item2);
        recommand.add(item3);



        // Anonymous Class
        Arrays.sort(recommand.items, new Comparator<BookMark>() {
            @Override
            public int compare(BookMark o1, BookMark o2) {
                return o1.getRating() < o2.getRating() ? 1 : -1 ;
            }
        });
        Arrays.sort(recommand.items, BookMark.RATIO_COMPARATOR) ;

        // So we have the Containing Class Object now
        //CacheInterface iterator = recommand.iterator();
        CacheInterface iterator = recommand.new MyCacheIterator() ;

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Using Anonymous Class FooBar Here

        new FooBar(5) {
            void  go(){
                 // Note Y is the protected memeber in the Foobar Class
                System.out.println("Printing Y in the FooBar method " + y );
            }
        }.go();




    }

    // Using the Anonymous claass to access itemsa via hidden references.
    /// But local variable count will be copied as a class instance variable
    public CacheInterface iterator(){

           int count = 2 ;
         //  count++ ;  - can not change here as well.
//        return new MyCacheIterator() ;
        return  new CacheInterface() {
            private int i = 0 ;

            @Override
            public boolean hasNext() {
                System.out.println("Count :  " + count);
             //   count = 3 ;  - Effectively FInal - Can not change it.
                return i < items.length ;
                // Access Instance Member of the Containing Class
            }

            @Override
            public BookMark next() {
                // Access outer Class Add Method
                Cache.this.add(new BookMark());

                // Access inner class add method
                return items[i++] ;
            }
        } ;
    }
/*
    public CacheInterface iterator(){
        // Compiler is doing like Cache$MyCacheIterator(this)
        return new MyCacheIterator() ;
    }
*/

    // By default it has a Constructor where this is passed to get the state
    private class MyCacheIterator implements CacheInterface{

        private int i = 0 ;

        // Can not have Static Members - Limitation
        // private static  int y = 0 ;

        @Override
        public boolean hasNext() {
            return i < items.length ; // Access Instance Member of the Containing Class
        }

        @Override
        public BookMark next() {
            // Access outer Class Add Method
            Cache.this.add(new BookMark());

            // Access inner class add method
            this.add(new BookMark());
            return items[i++] ;
        }

        public void add(BookMark item) {
            if(next < items.length)
                items[next++] = item ;
        }
    }

}


interface CacheInterface{
    boolean hasNext() ;
    BookMark next() ;
}

class FooBar{
    protected  int y = 0 ;

    FooBar(int x) {
        y = x ;
    }
}