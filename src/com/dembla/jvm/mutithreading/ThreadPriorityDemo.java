package com.dembla.jvm.mutithreading;

public class ThreadPriorityDemo {

    public static void main(String[] args) {
        // Get reference to the Current Thread - which is Main here
        System.out.println(Thread.currentThread());

        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataIntegrator());

        t1.setName("EmailCompaign");
        t2.setName("DataIntegrator");

        // Try to give more priority.
        // But its all upto Thread Scheduler
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

        try {
            // Suspend other threads until t2 is not completed/dies.
            //t2.join();

            // it says wait till 1 sec, if t2 not dies, pass the execution
             t2.join(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Inside main Method");

    }

}


class EmailCampaign implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());

            if (i == 5) {

                // Hint to the Scheduler that thread is willing to
                // yield its current use of the CPU.
                Thread.currentThread().yield();
            }
        }
    }
}

class DataIntegrator implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
        }

    }
}

