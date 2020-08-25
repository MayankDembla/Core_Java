package com.dembla.jvm.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionsDemo {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\n Inside main method");
        share()  ;
        System.out.println("\n End of main method");
    }

    public static void share() throws FileNotFoundException {
        System.out.println("\nInside Share method");

        try {
            String response = HttpConnect.send(0,"hello","http://www.goodsnips.com");
            System.out.println("After Invoking the Send");
            APIParser.parsesendResponseCode(response,"hello","http//www.goodsnips.com") ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e ;
        } catch (IOException e){
            System.out.println("Connecting to the Different Server");
        }catch (APIFormatChangeException ex){
            ex.printStackTrace();
        }
        finally {
            System.out.println("Finally is Executed ... ");
        }

        System.out.println("\nEnd of Share method");
    }


    public static void test() throws IOException{

        try {
            HttpConnect.send(1, "hello", "test");
        } finally {
            // Do clean up.
        }
    }

}
