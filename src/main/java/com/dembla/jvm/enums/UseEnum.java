package com.dembla.jvm.enums;

public class UseEnum {

    public static void main(String[] args) {

        purchase(BookGenre_EN.HORROR);
        purchase(BookGenre_EN.BIOGRAPHY);
    }

    public static void purchase(BookGenre_EN genre){
        System.out.println("You request to purchase with genre " + genre.name());
    }
}


enum BookGenre_EN{
    BIOGRAPHY , HORROR
}