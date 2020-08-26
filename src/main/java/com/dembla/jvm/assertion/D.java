package com.dembla.jvm.assertion;

public class D {

    public static void test(int val){
        assert  val > 0 : "invalid i in D.test" ;

        B b = new B() ;
        b.test(-1);
    }
}
