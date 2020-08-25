package com.dembla.jvm.exceptions;

import java.awt.image.ImagingOpException;
import java.io.*;
import java.nio.BufferUnderflowException;
import java.sql.SQLOutput;

public class TrywithResourcesDemo {

    public static void main(String[] args) {

        try{
//            fileCopyWithArm() ;
            fileCopyWithoutArm();
        }catch ( IOException e){
            e.printStackTrace();

//            Throwable[] throwables = e.getSuppressed() ;
//            System.out.println(throwables[0].getMessage());
//            System.out.println(throwables[1].getMessage());

        }
    }

    public static void fileCopyWithArm() throws IOException {

        String inFileStr = "res\\abc.jpg";
        String outFileStr = "res\\xyz.jpg";

        System.out.println("Inside Copy File method ");

        try (Test t = new Test() ; Test2  t2 = new Test2();  BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr)
              )
        ) {

            byte[] byteBuf = new byte[4000];
            int numBytesread;

            while ((numBytesread = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesread);
            }

            throw new IOException("Important Exception !") ;
        }

    }


    public static void fileCopyWithoutArm() throws IOException {

        String inFileStr = "res\\abc.jpg";
        String outFileStr = "res\\xyz.jpg";

        System.out.println("Inside Copy File method ");

        Test t = null ;
        Test2 t2 = null  ;
        BufferedInputStream in = null  ;
        BufferedOutputStream out = null ;

        try {

             t = new Test() ;
             t2 = new Test2();
             in = new BufferedInputStream(new FileInputStream(inFileStr));
             out = new BufferedOutputStream(new FileOutputStream(outFileStr) );

            byte[] byteBuf = new byte[4000];
            int numBytesread;

            while ((numBytesread = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesread);
            }

            throw new IOException("Important Exception !") ;
        }finally {
            if(in != null)
                in.close();
            if(out != null)
                out.close();
            if(t2 != null)
                t2.close();
            if(t != null)
                t.close();
        }

    }
}


class Test implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw  new IOException("Trivial Exception") ;
    }
}

class Test2 implements AutoCloseable {

    @Override
    public void close() throws IOException {
        throw  new IOException("Trivial Exception 2") ;
    }
}