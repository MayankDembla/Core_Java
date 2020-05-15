package com.dembla.classobjects.practice;

public class WrapperClass {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Mayank") ;
        Employee emp2 = new Employee(2,"Dembla") ;

        EmployeeWrapper emp1w = new EmployeeWrapper(emp1) ;
        EmployeeWrapper emp2w = new EmployeeWrapper(emp2) ;

        swap(emp1w,emp2w);

        System.out.println("Employee 1 : " + emp1w.employee) ;
        System.out.println("Employee 2 : " + emp2w.employee) ;

        System.out.println("Employee 1 : " + emp1) ;
        System.out.println("Employee 2 : " + emp2) ;
    }

    public static void swap(EmployeeWrapper emp1, EmployeeWrapper emp2){
        Employee emp = emp1.employee ;
        emp1.employee = emp2.employee ;
        emp2.employee = emp ;
    }

}



