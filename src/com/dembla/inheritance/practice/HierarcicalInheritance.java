package com.dembla.inheritance.practice;

public class HierarcicalInheritance {

    public static void main(String[] args) {

        BaseOne b1 = new BaseOne("Mayank","Dembla") ;

        b1.print_top();
        b1.print_bone();

        BaseTwo b2 = new BaseTwo("Mayank","Dembla") ;

        b2.print_top();
        b2.print_bTwo();

        BaseThree b3 = new BaseThree("Mayank","Dembla") ;

        b3.print_top();
        b3.print_bThree();

    }

}


class TopClass{

    String topClass ;

    TopClass(String topClass){
      this.topClass= topClass ;
    }

    public void print_top(){
      System.out.println("Top " + topClass) ;
     }
}

class BaseOne extends  TopClass{

    String topClass ;

    BaseOne(String name, String baseOneName){
        super(name);
        this.topClass = baseOneName ;
    }

    public void print_bone(){
      System.out.println("B1 : " + topClass) ;
    }
}



class  BaseTwo extends  TopClass{

    String topClass ;

    BaseTwo(String topClass, String base){
        super(topClass);
        this.topClass = base ;
    }

    public  void print_bTwo(){
        System.out.println("B2: " + topClass) ;
    }
}


class  BaseThree extends  TopClass{

    String topClass ;

    BaseThree(String topClass, String base){
        super(topClass);
        this.topClass = base ;
    }

    public  void print_bThree(){
        System.out.println("B3: " + topClass) ;
    }
}
