package com.dembla.classobjects.practice;

public class SwappingObjects {

    public static void main(String[] args) {

        Employee emp1 = new Employee(2,"Mayank") ;
        Employee emp2 = new Employee(1,"Dembla") ;

        System.out.println("HashCode before Passing") ;
        System.out.println("Employee 1 : " + emp1.hashCode() );
        System.out.println("Employee 2 : " + emp2.hashCode() ) ;

        // While Passing Java creates a copy of the references passed inside the method...
        // Remember but they still points to same memory reference.
        trypassing(emp1,emp2) ;

        System.out.println("Empployee 1 " + emp1) ;
        System.out.println("Employee 2 " + emp2) ;

        swapObjects(emp1,emp2) ;

        System.out.println("After Swapping : ") ; // will not change
        System.out.println("Empployee 1 " + emp1) ;
        System.out.println("Employee 2 " + emp2) ;

    }


    public static void trypassing(Employee emp1 , Employee emp2){

        // points to same reference as the original points
        // But References are different, but points to the same thing.
           System.out.println("Method passed HashCodes ") ;
           System.out.println("Employee 1 : " + emp1.hashCode() );
           System.out.println("Employee 2 : " + emp2.hashCode() ) ;

        // try to change value of emp1 Hash Code will Not change.
          emp1.setEmployeeName("Tapan");
          System.out.println("Employee 1 Hash Code " + emp1.hashCode()) ;
          emp2.setEmployeeName("Sabu");

        // It will not impact the Original Object as we are changing the references
        emp2 = null ;
        emp1 = new Employee(56,"New Employee") ;
    }

    // this also will nat swap the values as we have change the referece
    // Play with state and Behavious but not with Reference while passing.
    public static void swapObjects(Employee emp1 , Employee emp2 ){
        Employee temp  = emp2 ;
        emp2 = emp1 ;
        emp1 = temp ;
    }


}
