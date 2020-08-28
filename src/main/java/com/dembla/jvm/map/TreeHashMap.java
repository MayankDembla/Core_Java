package com.dembla.jvm.map;

import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class TreeHashMap {

    public static void main(String[] args) {
        treeHashMapDemo();
    }

    private static void treeHashMapDemo() {
        System.out.println("Inside the Tree Hash Map ");

        NavigableMap<String, Integer> treemap = new TreeMap<>();

        treemap.put("John",25) ;
        treemap.put("Raj",29) ;
        treemap.put("Anita",23) ;

        System.out.println(treemap);

        System.out.println("Iterating using the entrySet ... ");

        Set<Map.Entry<String,Integer>> data = treemap.entrySet() ;
        for(Map.Entry dat : data) {
            System.out.println("Name : " + dat.getKey() + " Value : " + dat.getValue());

            if(dat.getKey().equals("John")){
                dat.setValue(37) ;
            }
        }

        System.out.println(treemap);

        // We can not invoke the set Value will give Unsupported Operation Exception
        treemap.floorEntry("Raj").setValue(22) ;
        System.out.println(treemap);

    }
}
