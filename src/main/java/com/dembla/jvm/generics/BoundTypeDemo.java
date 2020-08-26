package com.dembla.jvm.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BoundTypeDemo {

    public static void main(String[] args) {

        GenericDemo<ArrayList<String>,String> list1 = new GenericDemo<>() ;
//        list1.set();

//        GenericDemo<ArrayList> arrayList = new GenericDemo<>() ;

        // Error As Collection is not a SubType of the List
        // It is a Super type not a subType ...
//      GenericDemo<Collection> collection = new GenericDemo<>() ;




    }

}


class GenericDemo<T extends List<U> & Serializable, U> {

//    private T list ;
//
//    public void set(){
//        list.add(0,12) ;
//    }

}


enum Test{

}