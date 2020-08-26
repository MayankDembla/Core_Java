package com.dembla.jvm.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        demoClassObjectAccess() ;
        demoCoreReflection(Class.forName("com.dembla.jvm.reflection.User")) ;
    }

    // instance creation and method invocation
    private static void demoCoreReflection(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("\nIn demoCoreReflection ...") ;

        Object object = null ;
        try {
             object = clazz.newInstance() ; // must have default no args constructor.
        }catch(InstantiationException e){
            System.out.println("Can not instantiate") ;
        }catch(IllegalAccessException exp){
            System.out.println("Can't Access") ;
        }

        // get name of class
        System.out.println("object.getclass(): " + object.getClass().getName()) ;

        // Accessing methods
        for(Method m : clazz.getDeclaredMethods()){
            System.out.println("Method name: " + m.getName()) ;
            if(m.getReturnType() == void.class){
                System.out.println("Method's return type is void") ;
            }
        }

        // Accessing Constructor
        for(Constructor c : clazz.getDeclaredConstructors()){
            System.out.println("Constructor : " + c.getName() + ", # parameters: " + c.getParameters()) ;
        }

        // Fetch Constructor and invoke it.
        Constructor<User> userConstructor = clazz.getDeclaredConstructor(int.class,String.class,String.class,String.class,String.class) ;
        User user =userConstructor.newInstance(101,"mayank","email@gmail.com","male","donno") ;

        // Fetch Methods


        Method m = clazz.getDeclaredMethod("saveWebLink",String.class,String.class) ;
        Object result = m.invoke(user,"http.google.com","Google") ;
        System.out.println("Result of invoking saveWebLinks: " + ((Boolean)result).booleanValue()) ;

    }


    private static void demoClassObjectAccess() {

        System.out.println("\n In DemoClassObjectAccess ... ") ;

    // Using Object Reference
        String[] strArray = {"a","b","c"} ;
        System.out.println("\nstrArray.getClass().getName() : " + strArray.getClass().getName()) ;

    // Using for Class.forName
        Class clazz = null ;
        try {
            clazz = Class.forName("com.dembla.jvm.reflection.User");
        }catch (ClassNotFoundException ex){
            System.out.println("\n Can't find class ... ") ;
        }

        System.out.println("\nclazz.getName(): " + clazz.getName()) ;
        System.out.println("clazz.isInterface(): " + clazz.isInterface()) ;
        System.out.println("clazz.getInterface(): " + clazz.getInterfaces().length) ;
        System.out.println("clazz.getSuperClass().getName(): " + clazz.getSuperclass().getName()) ;

        // Exception is thrown as Class.forName cannot be used on primitives
        try{
            System.out.println("\nClass.forName(\"boolean\").getName(): " + Class.forName("boolean").getName()) ;
        } catch(ClassNotFoundException ex){
            System.out.println("\n Class Not Found Exception due to Class.forName(\"boolean\").getName()") ;
        }

        // Using .class (Class Literal)
        System.out.println("\ninit.class.getName(): " + int.class.getName());
    }
}




