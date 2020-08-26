package com.dembla.jvm.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeystypeDemo {

    public static void main(String[] args) {
        immutableKeys() ; 
    }

    private static void immutableKeys() {
        System.out.println("Inside the Immuatable keys Function ");

        List<Integer> list = new ArrayList<>()  ;
        list.add(2) ;
        list.add(1) ;
        list.add(2) ;
        list.add(5) ;

        Map<List<Integer>, Integer> map = new HashMap<>() ;
        map.put(list,1) ; // apply hashcode on the key

        // Changing the state and mutating it
        list.add(4) ;  // HashCode of the object is changed as it depend on the state

        // Search using the key
        // Returns a null value as the state if key is being changed.
        System.out.println("Value after changing the state is " + map.get(list));

        // ########### //

        Student s = new Student(1,"Mayank" ) ;

        Map<Student,Integer> studentmap = new HashMap<>() ;

        studentmap.put(s,1) ;

        System.out.println("Before Changing the state we have value : " + studentmap.get(s));

        // Mutate it and changing the state of the object
        // It will work as we donot override any hashcode which is basically
        // the address of the object.
        s.setName("Dembla");

        System.out.println("After Changing the state search by key : " + studentmap.get(s));


    }

}


class Student {

    String name ;
    int id ;

    Student(int id ,String name){
        this.id = id ;
        this.name = name ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
