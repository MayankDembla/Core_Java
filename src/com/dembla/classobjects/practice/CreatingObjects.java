package com.dembla.classobjects.practice;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreatingObjects {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, IOException {

        // 1. using New Keyword
        Employee employeeOne  = new Employee(1,"Mayank") ;

        System.out.println("Using New Keyword we have Object Created" + employeeOne) ;

        // 2. Using Class.forName
        Class cls = Class.forName("com.dembla.classobjects.practice.Employee") ;
        Constructor<?> ctor = cls.getConstructor(Integer.class,String.class) ;
        Employee employee2 = (Employee) ctor.newInstance(new Object[] {4,"Mayank"}) ;

        System.out.println("Employee Created using the Class Forname : " + employee2) ;

        // 3. Using the Clone Method
        Employee emp3 = new Employee(4,"Mayank") ;

        try {
            Employee  emp4 = (Employee) emp3.clone();
            System.out.println("Cloning Object : " + emp4) ;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 4. Using Deserialization of Object

        // First we have serialize object in a file name file.txt
        FileOutputStream f = new FileOutputStream("file.txt");
        ObjectOutputStream oos = new ObjectOutputStream(f);
        oos.writeObject(emp3);
        oos.close();
        f.close();

        // Now when we deserilize the Object we get a new Object !
        FileInputStream fe = new FileInputStream("file.txt") ;
         ObjectInputStream oose = new ObjectInputStream(fe) ;
         Employee emp5 = (Employee)oose.readObject() ;
         System.out.println("Deserialize will return a new Object : " + emp5) ;
         fe.close();
         oose.close();

    }
}
