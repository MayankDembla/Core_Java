package com.dembla.jvm.enums;

public class NestedEnums {

    public static void main(String[] args) {
       Test.BIO.code  = 4 ;
        tes();
        System.out.println(Test.BIO.code);
    }

    public static void tes(){
        Test.BIO.code = 9 ;
    }

   enum Test {
       BIO(23),
       CHEMISTRY(45) ;

       Test( int code){
           this.code = code ;
       }

       public int code ;
       public static int code2 = 5 ;
   }

}


class DemoNew{

    public static void main(String[] args) {
        NestedEnums.tes();
        System.out.println( NestedEnums.Test.BIO.code) ;
    }

}