package com.dembla.jvm.enums;

public class Resolution {

    public static void main(String[] args) {
        purchase(BookGenre.BIOGRAPHY);
        purchase(BookGenre.HORROR);

        // No we have type safety as we can not pass any other thing.
    }

    private static  void purchase(BookGenre genre){
        System.out.println("You have requested to purchase " + genre.getOrdinal());
    }
}


final class BookGenre {

    public static final BookGenre BIOGRAPHY = new BookGenre("BIOGRAPHY", 0) ;
    public static  final BookGenre HORROR = new BookGenre("HORROR",1) ;

    private BookGenre(String name , int ordinal ){
          this.name = name ;
          this.ordinal = ordinal ;
    }

    private String name ;
    private int ordinal ;

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }
}
