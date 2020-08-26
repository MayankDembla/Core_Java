package com.dembla.jvm.lifetimeoftype;

public class ClassInitializationDemo {

    {
        System.out.println("\n CLass Initlaization Demo : instance  initializer") ;
    }

    static {
        System.out.println("\n Class Initialization Demo : static initalizer ") ; //1
    }

    static int getInt(){
        System.out.println("\n Class Initlaization Demo: getInt()" ) ;
        return 3 ;
    }

    static int getInt5(){
        System.out.println("\n Class Initialization Demo : getInt5()") ;
        return 5 ;
    }

    public static void main(String[] args) {
        System.out.println("\n JVM invoke the main method " ) ; // 2
        System.out.println("Invoking Subclass.STATIC_FINAL " + SubClass.STATIC_FINAL) ; // 3 but subclass is not loaded yet.
//        System.out.println("Invoking Subclass.STATIC_FINAL2 " + SubClass.STATIC_FINAL2) ;
//        System.out.println("Instantiating SubClass ") ;
//        new SubClass() ;
//        SuperInterface.staticMethod();
    }

}

class SuperClass
{
      static {
          System.out.println("Static Intializer  :  SuperCLass" ) ;
      }

    {
        System.out.println("Instance Intilaizer : superclass ") ;
    }

        SuperClass(){
        System.out.println("SuperClass: Constructor") ;  // 5
        }
}

interface  SuperInterface {

    int STATIC_FINAL3 = new ClassInitializationDemo().getInt() ;

    static void staticMethod(){
        System.out.println("superinterface : staticMethod") ;
    }

}


class SubClass extends SuperClass implements SuperInterface {

    static final int STATIC_FINAL = 47 ;  // Compile Time Constant
    static final int STATIC_FINAL2 = (int) (Math.random()*5) ;

    ObjectReference object = new ObjectReference() ;
    static {
        System.out.println("SubClass:static initializer") ;   // 3
    }

    {
        System.out.println("SubClass: instance intilaizer") ;
    }

    SubClass(){
        System.out.println("SubCLass: constructor") ; // 6
    }
}

class ObjectReference{
    ObjectReference(){
        System.out.println("Object Reference Constructor is invoked !") ;
    }
}
