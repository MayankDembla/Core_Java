package com.dembla.jvm.collection.model;

import java.util.Objects;

public class Book { // implements Comparable{

    private String name ;
    private String author ;
    private int id ;

    public Book(String name, String author, int id) {
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode(){
        return name.hashCode() ;
     }

    @Override
    public boolean equals(Object obj) {
        return (id == ((Book)obj).getId()) && (name.equals(((Book)obj).getName()))
                                            && (author.equals(((Book)obj).getAuthor())) ; 
    }

//    @Override
//    public int compareTo(Object o) {
//        return getName().compareTo(((Book)o).getName()); // Utilizing the String Comparing
//    }
}
