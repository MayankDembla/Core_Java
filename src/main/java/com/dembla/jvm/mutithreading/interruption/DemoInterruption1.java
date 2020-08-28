package com.dembla.jvm.mutithreading.interruption;

import java.util.concurrent.TimeUnit;

public class DemoInterruption1 {

    public static void main(String[] args) {

        Task task = new Task();
        Thread thread = new Thread(task) ;
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(3);
            thread.interrupt();
        }catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        System.out.println("Inside Main Method");
    }

}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside Run ...");
        try {
            TimeUnit.SECONDS.sleep(19);
            System.out.println("Finishes 19 Second");
        }catch (InterruptedException exception) {
            System.out.println("Interrupted");
        }
        go();
    }

    private void go(){
        System.out.println("Inside go ...");
        more();
    }

    private void more(){
        System.out.println("Inside More...");
    }
}