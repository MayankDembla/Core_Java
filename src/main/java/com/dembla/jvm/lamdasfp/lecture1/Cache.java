package com.dembla.jvm.lamdasfp.lecture1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Cache {

    private Bookmark[] items ;
    private int next = 0 ;

    public Cache(int size){
        items = new Bookmark[size] ;
    }

    public void add(Bookmark bookmark){
        if(next < items.length){
            items[next++] = bookmark ;
        }
    }

    public CacheIterator iterator(){
        return new MyCacheIterator() ;
    }

    public class MyCacheIterator implements CacheIterator{
        private int i = 0 ;

        @Override
        public boolean hasNext() {
            return i < items.length;
        }

        @Override
        public Bookmark next() {
            return items[i++];
        }
    }

    public static void main(String[] args) {
        Cache recommendedItems = new Cache(5);

        Bookmark item1 = new Bookmark();
        item1.setId(2000);
        item1.setTitle("Use Final Liberally");
        item1.setRating(1.0);

        Bookmark item2 = new Bookmark();
        item2.setId(2001);
        item2.setTitle("How do I import a pre-existing Java project into Eclipse and get up and running?");
        item2.setRating(2.0);

        Bookmark item3 = new Bookmark();
        item3.setId(2002);
        item3.setTitle("Interface vs Abstract Class");
        item3.setRating(3.0);

        Bookmark item4 = new Bookmark();
        item4.setId(2003);
        item4.setTitle("NIO tutorial by Greg Travis");
        item4.setRating(4.0);

        Bookmark item5 = new Bookmark();
        item5.setId(2004);
        item5.setTitle("Virtual Hosting and Tomcat");
        item5.setRating(5.0);

        recommendedItems.add(item1);
        recommendedItems.add(item2);
        recommendedItems.add(item3);
        recommendedItems.add(item4);
        recommendedItems.add(item5);

        CacheIterator iterator = recommendedItems.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        Arrays.sort(recommendedItems.items, new Comparator<Bookmark>() {

            @Override
            public int compare(Bookmark o1, Bookmark o2) {
                // TODO Auto-generated method stub
                return o1.getRating() < o2.getRating() ? 1 : -1;
            }

        });

        System.out.println("\nSorted by rating (using Anonymous class) ...");
        iterator = recommendedItems.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

        // Lambdas
        Arrays.sort(recommendedItems.items, (o1, o2) ->   new Integer(o1.getTitle().length()).compareTo(new Integer(o2.getTitle().length())));
        System.out.println("\nSorted by length (using Lambda) ...");
        iterator = recommendedItems.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

      // new Cache(5).go(()-> System.out.println("test"));

    }

    int gcount = 0 ;

    public void go(TestNow test){ //(Test test){
        test.apply();

        int count = 0 ;

        // Here also cannot do that if using in lambda
        // must be effectively final ....
        // count++ ;

        // Just like anonymous class we can not change the local variable count to count++
        // this is effectively final -also known as closures.
        new Thread(() -> System.out.println(count)).start();

        // even we can not do this after as well.
       // count++ ;

        // this is a compile time error...
       // new Thread(() -> System.out.println(count++)).start();

        // this is fine
        new Thread(() -> System.out.println(gcount++)).start();

        gcount++;

        // -------------- trick ---------

        int countn = 0 ;

        List<Integer> trick = new ArrayList<>() ;

        new Thread(()->{

            // we can not shadow the local variable as well
            // int countn = 0 ;

            trick.add(countn) ;
            int temp = trick.get(0) ;
            trick.set(0,temp++) ;
        }).start();

        // Can do this in anonymous or local class ...
        new Thread(new Runnable() {
            @Override
            public void run() {
                int countn = 0 ;

            }
        }).start();

    }

}

interface CacheIterator{
    public boolean hasNext() ;

    public Bookmark next();
}

abstract class Test{
    abstract void apply() ;
}


@FunctionalInterface
interface TestNow{
    void apply() ;
    default void apply1(){}

    // Still  Qualify for the functional Interface
    // toString method is a part of object class
    // so every class implicitly inherits from object class.
    String toString() ;
    public int hashCode();
}
