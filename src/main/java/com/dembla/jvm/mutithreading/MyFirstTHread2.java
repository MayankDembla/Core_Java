package com.dembla.jvm.mutithreading;

import java.util.concurrent.TimeUnit;

public class MyFirstTHread2 extends Thread{

    @Override
    public void run(){
        System.out.println("Inside Run method ... ");
        go();
    }

    private void go(){
        System.out.println("Inside Go ...");
        more();
    }

    private void more() {
        System.out.println("Inside More ... ");
    }

    public static void main(String[] args) throws InterruptedException {

        MyFirstTHread2 th = new MyFirstTHread2() ;
        th.start();
        th.start();

        // Current Thread would Stop its Execution for this much of milliseconds
        Thread.sleep(3000);

        TimeUnit.HOURS.sleep(3);

        System.out.println("Inside Main Thread ... ");
    }
}
