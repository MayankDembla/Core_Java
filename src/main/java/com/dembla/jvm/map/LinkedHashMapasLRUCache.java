package com.dembla.jvm.map;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LinkedHashMapasLRUCache {

    public static void main(String[] args) {

        lruCacheTest();
    }

    private static void lruCacheTest() {
        System.out.println("Inside Lru Cache test");

        // Not Act as the LRU Cache
        Map<String, String> linkedHashMap = new LRUCache<>(16, 0.75f, true);
        linkedHashMap.put("a", "A");
        linkedHashMap.put("b", "B");
        linkedHashMap.put("c", "C");
        System.out.println(linkedHashMap);
        linkedHashMap.get("a");
        linkedHashMap.get("a");
        linkedHashMap.get("a");
        System.out.println(linkedHashMap);
        linkedHashMap.get("b") ;
        System.out.println(linkedHashMap);
        linkedHashMap.put("d","D") ;
        System.out.println(linkedHashMap);
        linkedHashMap.put("e","E") ;
        System.out.println(linkedHashMap);
        linkedHashMap.put("f","F") ;
        System.out.println(linkedHashMap);

    }
}


class LRUCache<K,V> extends LinkedHashMap<K,V>
{

    private static  final int MAX_ENTRIES = 3 ;

    public LRUCache(int initialCapacity , float loadFactor , boolean accessOrder){
          super(initialCapacity,loadFactor,accessOrder);
    }

    // invoke by put and putall after inserting a new entry into the map
   @Override
    public boolean removeEldestEntry(Map.Entry eldest){
        return size() > MAX_ENTRIES ;
    }
}