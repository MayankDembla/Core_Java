package com.dembla.jvm.generics;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InferenceDemo<X> {


    // Generic Constructors are the rare
    <E extends X>InferenceDemo(E object){ }


    public static void main(String[] args) {

        //## 1. Type Inference using Method Argument.
        typeInferenceWithMethodArgument(22.0);
        typeInferenceWithMethodArgument("Mayank");

        //## 2. Type Inference using Target Type

        //# 2.1 Target is Nothing
        typeInferenceUsingTarget() ; // Target is nothing

        //# 2.2 Target is String put a type cast of String here
        //              by default Compile puts String Type Cast
        String string = /*(String)*/typeInferenceUsingTarget() ;

        //# 2.3 Target is Souble put a type cast of Double here
        //             by default Compile puts puts Double Type Cast
//        Double doublw = /*(Double)*/typeInferenceUsingTarget() ;

       // 3 - UseCase for using type inference by Method Parametr
        Integer[] ar = new  Integer[3] ;
        List<Integer> integer = new ArrayList<>() ;

        /* We Can Not Put the String as a Type Parameter here.
         *  Compile Time Safety -- Cool
         */
//        List<String> test = new ArrayList<>() ;

        usecaseforTypeInference(ar, integer) ;

         // 4 . Type Inference Using Method Context.

        // 4.1 : Type Inference Based on the Method Argument - List<String>
        methodOutside(methodArgumentInferenceInside()) ;

        // 4.2 Type Inference Based on Method Argument - List<Object>
        methodOutside( new ArrayList<>() );


        // 4.2 Outside method  returns the List<T>

        // Infer as List<Object>
         methodoutside2(methodArgumentInferenceInside()) ;

         // Infer as List<Integer>
         List<Integer> li = /*(List<String>)*/ methodoutside2(methodArgumentInferenceInside()) ;

        li.add(12) ;
        System.out.println( "Integer : " + li);

        // Inference most specific super-type
       Serializable ser = typeInfereceUsingMostSpecificType("Mayank",new ArrayList()) ;

       AbstractCollection c = typeInfereceUsingMostSpecificType(new ArrayList(), new HashSet<>()) ;

       // Not be used in the Client Code as it has a return type as void.
       InferenceDemo.<String>uselessGenericMethod();

       // Generic Constructor - Works like the generic methods
        new <Double>InferenceDemo<Number>(12.1) ; // Type Witness
        new <String>InferenceDemo<String>("String") ;/*Number - exception*/

        InferenceDemo<Number> demo = new InferenceDemo<>(12.0) ;

    }

    /**
     *  Method for Demonstrate Type Inference Using Method Parameter
     */
    private  static <T> void typeInferenceWithMethodArgument(T object) {
        System.out.println(object.getClass().getName());
    }

    /**
     *    Method for Demonstration od Type Inference Using Target Type
     * @param <T>
     * @return
     */
    private static  <T> T typeInferenceUsingTarget(){
        return (T)"abc";
    }

    /**
     *     Method for Demonstration of Using the Use Case of Type Inference Using Method Argument.
     * @param ar
     * @param list
     * @param <T>
     */
    private  static  <T> void usecaseforTypeInference(T[] ar, List<T> list ) {

        for (T l : list) {
            list.add(l) ;
        }
    }

    private static <T> List<T> methodArgumentInferenceInside(){

         List<String> list = new ArrayList<>() ;
         list.add("Mayank") ;
         return  (List<T>)list ;
    }

    private static <T> void methodOutside(List<T> get) {

        for (T t : get) {
            System.out.println(t);
        }
    }

    private static <T> List<T> methodoutside2(List<T> get){
        return  get ;
    }

    // ######### Inference the most specific type ######

    private static <T> T typeInfereceUsingMostSpecificType(T data1, T data2){

        System.out.println("Most specific type argument inferred: " + data2.getClass().getName());
        return data1 ;
    }

    // Useless Generic method
    static <T>  void uselessGenericMethod(){
        T t = (T)new Integer(2) ;
        System.out.println("Type Witness : " + t.getClass().getName());
    }

}
