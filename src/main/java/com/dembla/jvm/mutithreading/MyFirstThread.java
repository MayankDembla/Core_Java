package com.dembla.jvm.mutithreading;

public class MyFirstThread {

    // First Thread is the Main thread. - Non Deamon
    public static void main(String[] args) {

        Task task = new Task() ;

        // Second thread is this we are creating. - Non Deamon
        // Thread is a Worker and task is the Work
        Thread thread = new Thread(task) ;  // NEW
        thread.start();  // Start

        System.out.println("Inside Main .... ");

    }
}


class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Run ... ");
        go() ;
        more() ; 
    }

    private void more() {
        System.out.println("Inside More ... ");
    }

    private void go() {
        System.out.println("Inside Go ... ");
    }
    
    
}