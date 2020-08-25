package com.dembla.jvm.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        demoHashMap() ;
        testcomplex() ;
    }

    private static void demoHashMap() {

        System.out.println("\n Inside the HashMap Demo !! ");

        Map<String, Integer> map1 = new HashMap<>() ;

        map1.put("John", 1) ;
        map1.put("Raj", 1) ;
        map1.put("Ankita", null) ;

        // This will update the value of the John key
        // as this is already exist.
        map1.put("Ankita", 23) ;
        System.out.println(map1);

        System.out.println("Jonh Contains " + map1.containsKey("John"));
        System.out.println("1 have value ? " + map1.containsValue(2));

        // Iterating using the keySet

        System.out.println("\n Iterating using the KeySet ... ");
        Set<String> names = map1.keySet() ;

        for(String nam : names) {
            System.out.println("Key : " + nam + " Value : " + map1.get(nam));
        }

        System.out.println("Using Collection View method keyset() ");

        Set<Map.Entry<String, Integer>> entries = map1.entrySet();

        for(Map.Entry<String,Integer> e : entries ) {
            System.out.println("Key : " + e.getKey() + " Value : " + e.getValue() ) ;
        }

        map1.remove("Ankita") ;
        System.out.println(map1);
    }

    private static void testcomplex(){

        Map<String, Map<String,Object>> userprofile = new HashMap<>() ;

       Map<String, Object> profile = new HashMap<>() ;
       profile.put("age",25) ;
       profile.put("dept","CS") ;
       profile.put("city","Bhopal") ;

       userprofile.put("John",profile) ;

        Map<String, Object> profile1 = new HashMap<>() ;
        profile1.put("age",23) ;
        profile1.put("dept","IT") ;
        profile1.put("city","Palwal") ;

        userprofile.put("Raj", profile1) ;

        System.out.println("USerProfile  : " + userprofile );


        Map<String,Object> profilejohn = userprofile.get("John") ;
        System.out.println(profilejohn.get("age"));

    }

}
