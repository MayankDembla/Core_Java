package com.dembla.jvm.mutithreading;

public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        BankAccount task = new BankAccount() ;
        task.setBalance(100) ; 

        Thread john =new Thread(task) ;
        Thread anita = new Thread(task) ;

        john.setName("John");
        anita.setName("Anita");

        john.start();
        anita.start();


    }

}

class BankAccount implements Runnable {

    private int balance;

    public void setBalance(int i) {
        this.balance = i;
    }

    @Override
    public void run() {
        checkBalance() ;
        makeWithdrawl(75);
        if (balance < 0) {
            System.out.println("Money Over Withdrawl!!!");
        }
    }

    private int checkBalance(){


        System.out.println(Thread.currentThread().getName() + " Balance is  : " + balance);
        return balance ;
    }

        private synchronized void makeWithdrawl( int amount){
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is about to Withdraw ...");
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " has withdraw amount " + amount);
            } else {
                System.out.println("Sorry, Not Enough Balance for . " + Thread.currentThread().getName());
            }

        }
    }
