package com.dembla.jvm.mutithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.dembla.jvm.mutithreading.AtomicVariableDemo.MeetUpEvent.sleep;

public class AtomicVariableDemo {

    public static class MeetUpEvent {

        private String name;
        private AtomicInteger count = new AtomicInteger(1);
        
        public MeetUpEvent(String name) {
            this.name = name;
        }

        public void attending(int guestCount) {
            if (guestCount == 1) {
                count.incrementAndGet(); // increment one
            } else {
                count.addAndGet(guestCount); // increment number
            }
        }

        public void notAttending(int guestCount) {
            if (guestCount == 1) {
                count.decrementAndGet(); // decrement 1
            } else {
                boolean updated = false;

                while (!updated) {
                    int currentCount = count.get();
                    int newCount = currentCount - guestCount;
                    // Uses Compare and Swap
                    updated = count.compareAndSet(currentCount, newCount); }
            }
        }

        public int getCount() {
            return count.get();
        }

        public static void sleep(int i) {
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MeetUpEvent jugBoston = new MeetUpEvent("The Boston Java Group ");

        Thread user1 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugBoston.attending(4);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });

        user1.setName("User One");

        Thread user2 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugBoston.attending(4);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());

                jugBoston.notAttending(3);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });

        user2.setName("User Two");

        Thread user3 = new Thread(new Runnable() {
            @Override
            public void run() {
                jugBoston.attending(3);
                System.out.println(Thread.currentThread().getName() + " : " + jugBoston.getCount());
            }
        });

        user3.setName("User Three ");

        user1.start();
        sleep(1);
        user2.start();
        sleep(2);
        user3.start();
        sleep(2);
        System.out.println("Total Number of Attendeed " + jugBoston.getCount());
    }


}
