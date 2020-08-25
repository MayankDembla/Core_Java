package com.dembla.jvm.io;

import java.io.*;

public class ByteStream {

    static  String inputFile = "res\\abc.jpg" ;
    static  String outputFileName = "res\\copy.jpg" ;

    public  static void main(String[] str)  {

        System.out.println("Without Using Buffer TIme Elapse is ");

        try {
            fileCopyNoBuffer() ;
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("With using the Buffer Time Elapse is ");

        try {
            filecopyWithBufferAndByteArray() ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filecopyWithBufferAndByteArray() throws IOException {

        System.out.println("\n Inside File Copy with Buffer");

        long startTime, elapsedTime;  // for speed benchmarking

        // Printing File length
        File fileIn = new File(inputFile);
        System.out.println("File Size is " + fileIn.length() + " bytes");

        // Try with Resources
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inputFile));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFileName))) {

            startTime = System.nanoTime();

            byte[] byteref = new byte[4000] ;
            int byteread;

            // Read one byte and putting the value in the integer
            // And Read till not equals to -1
            while ((byteread = in.read(byteref)) != -1) {
                // Write the least significant bytes and drop the upper 3 bytes
                out.write(byteref,0,byteread);
            }

            elapsedTime = System.nanoTime() - startTime;

            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + "msec");
        }
    }

    public static void fileCopyNoBuffer() throws IOException {

        System.out.println("\n Inside File Copy No Buffer");

        long startTime, elapsedTime;  // for spped benchmarking

        // Printing File length
        File fileIn = new File(inputFile);
        System.out.println("File Size is " + fileIn.length() + " bytes");

        // Try with Resources
        try (FileInputStream in = new FileInputStream(inputFile);
             FileOutputStream out = new FileOutputStream(outputFileName)) {

            startTime = System.nanoTime();
            int byteread;

            // Read one byte and putting the value in the integer
            // And Reaad till not equals to -1
            while ((byteread = in.read()) != -1) {
                // Write the least significant bytes and drop the upper 3 bytes
                out.write(byteread);
            }

            elapsedTime = System.nanoTime() - startTime;

            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + "msec");
        }
    }

}
