package com.dembla.jvm.enums;

public class WhyEnums {

    public static void main(String[] args) {

        // Here we have put the constant
        purchase(Genre.MOVIE_GENRE_HORROR);

        // By mistake user can enter a book type
        purchase(Genre.BOOK_GENRE_HORROR) ;

        // Hence .. No Type Safety.
    }

    public static void purchase(int movie){
        System.out.println("You want to purchase the movie with genre  type " + movie);
    }

}


/**
 * This class is for Compile time Constants ..
 * This class is called a int enum pattern.
 */
class Genre {

    // Movie Genre Constants
    public static final int MOVIE_GENRE_HORROR = 0 ;
    public static final int MOVIE_GENRE_DRAMA = 1 ;

    // Book Genre Constants
    public static final int BOOK_GENRE_HORROR = 101 ;
    public static final int BOOK_GENRE_BIOGRAPHY = 102 ;

    private Genre(){
        // Do not Instantiate
    }
}
