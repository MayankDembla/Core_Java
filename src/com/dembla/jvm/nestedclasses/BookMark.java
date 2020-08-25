package com.dembla.jvm.nestedclasses;

import java.io.Serializable;
import java.util.Comparator;

public class BookMark {

    private long id ;
    private String title ;
    private double rating ;

    public static final Comparator<BookMark> RATIO_COMPARATOR = new ComparatorList.RatioComparator() ;



     // Helper
    public static  class ComparatorList{

        private static class RatioComparator implements Comparator<BookMark>, Serializable {
            @Override
            public int compare(BookMark o1, BookMark o2) {
                return o1.getRating() > o2.getRating() ? 1 : -1 ;
            }
        }

        private static class StringLengthCompartaor implements Comparator<BookMark>, Serializable {

            @Override
            public int compare(BookMark o1, BookMark o2) {
                return o1.getTitle().length() - o2.getTitle().length();
            }
        }

        public static void testvar(){

            int x = 0 ;

            if(x == 0 ){
                int y = x ;
                 x = 0 ;
            }



        }

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "BookMark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                rating +
                '}';
    }
}
