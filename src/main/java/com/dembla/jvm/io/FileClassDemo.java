package com.dembla.jvm.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileClassDemo {

    public static void main(String[] args) {
//        fileMethodsDemo();
        directoryFilter(true) ;
    }

    public static void directoryFilter(boolean applyFilter) {
        System.out.println("\n inside the Directory Filter");

        File path = new File(".\\res");
        String list[] = new String[0];

        if (!applyFilter) {
           list =   path.list() ;
        }
        else
            list = path.list(new DirFilter()) ;

        for(String dirItem : list){
            System.out.println(dirItem);
        }

    }


    public static void fileMethodsDemo() {

        System.out.println("\n Inside fileMethodName ...");

        // Relative Path
        File f = new File("res\\test.txt");

        System.out.println("Get Absolute Path : " + f.getAbsolutePath());

        try {
            System.out.println("Get Canonical Path : " + f.getCanonicalPath());
            System.out.println("get New File : " + f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Parent " + f.getParent());
        System.out.println("Last Modified " + f.lastModified());
        System.out.println("Is Exist " + f.exists());
        System.out.println("Is File " + f.isFile());
        System.out.println("Is Directory " + f.isDirectory());
        System.out.println("Length " + f.length());


        System.out.println("My Working or User Direcrtory is : " + System.getProperty("user.dir"));
        System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());
        System.out.println("" + new File("testdir\\test").mkdir());

        // if there is no content then only it will succeed.
        System.out.println("" + new File("testdir").delete());

        try {
            File file = new File("testdir\\temp.txt");
            System.out.println("f2.createNewFile " + file.createNewFile());
            System.out.println("f2.renameTo(...):  " + file.renameTo(new File("testdir\\temp2.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


class DirFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".jpg") || name.endsWith(".JPG");
    }
}