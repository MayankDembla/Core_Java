package com.dembla.jvm.mutithreading;

import java.util.concurrent.TimeUnit;

public class VolatileKeyword {

    private static volatile boolean stop ;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            int count = 0 ;
            @Override
            public void run() {
                while (!stop){
                    System.out.println("In While ... " + count++);
                }
            }
        }).start();


        System.out.println("In Main Method");
        TimeUnit.MICROSECONDS.sleep(1);
        System.out.println("Stop Thread . ");
         stop =true ;

    }
}
