package com.dembla.jvm.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethods {

    public static void main(String[] args) {
       GenericMethods gm = new GenericMethods() ;
        genericMethodsDemo(); 

    }


    /**
     * Demonstrate :
     * a. Type Argument inference via method arguments and target type
     * b. Explicit type argument specifications
     * c. Generic Constructors
     * d. aggregate method fix from wildcard demo
     */
    static void genericMethodsDemo(){
        System.out.println("\n Inside Generic Methods ");

        typeArgInference(22.0) ;
        typeArgInference("Mayank");

        // Using Return type as Type Argument
        // Now we have the Compile time type safety.
        Double d = typeArgumentReturn(22.0) ;
//        Double invalid = typeArgumentReturn("MayankS") ;

        // Compile Time Safety benefit in generic method - wrong arguments
        Integer[] ar = new Integer[100] ;
        Collection<Number> cs = new ArrayList<>() ;
        arrayToCollection(ar, cs ); // Inferred from the arguments here

        // Type Argument inference via target type
        String val1 = typeArgumentTargetinference1() ;

        // Run time Exception - Internally it is type casting it to Double.
       // Double val2 = typeArgumentTargetinference1() ;


        // Type Argument inference in method invocation context - works from java 8
        System.out.println(typeArgumentTargetinference2().getClass());
        GenericMethods.targetTypeinvoker1(typeArgumentTargetinference2()) ;
        GenericMethods.targetTypeinvoker1(new ArrayList<>()) ;

        GenericMethods.targetTypeInvoker2(typeArgumentTargetinference2()) ;

        // Generic Constructor 


    }


    private static <T> List<T> typeArgumentTargetinference2() {

        List<Integer> list  = new ArrayList<>() ;
      //  list.add("Mayank") ;
//        list.add(23) ;

        return (List<T>) list ;

    }

    private static void targetTypeinvoker1(List<String> typeArgumentTargetinference1) {
             for(String s : typeArgumentTargetinference1){
                 System.out.println(s);
             }
    }

    static  <T> List<T> targetTypeInvoker2(List<T> list){
        return  list ;
    }


    // Type argument inference via target type
    private static <T> T typeArgumentTargetinference1() {
            return (T)"abc" ;
    }

    private static <T> void arrayToCollection(T[] ar , Collection<T> c) {

         for(T o : ar ){
             c.add(o);
         }
    }

    // Target Type <T>        (Method Argument)
    private static <T> void typeArgInference(T value) {

        System.out.println("Type Argument: " + value.getClass().getName());
    }

    private static  <T> T typeArgumentReturn(T value){
        return value ;
    }


}


class GenericConstructor<T> {

    // Generic Cobsgtructors are very rare !!
    <E extends  T>GenericConstructor(E object){
    }

}
