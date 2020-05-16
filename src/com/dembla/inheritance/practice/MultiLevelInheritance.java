package com.dembla.inheritance.practice;

public class MultiLevelInheritance extends SecondCLass {

    private int age ;
    MultiLevelInheritance(String fname, String lname, int age){
        super(fname,lname);
        this.age =age ;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {

        MultiLevelInheritance h = new MultiLevelInheritance("Mayank","Dembla", 25) ;
          h.print_firstName();
          h.print_sirname();
          System.out.println(h.getAge()) ;
    }
}



class FirstClass{

    private String name ;

    FirstClass(String name){
        this.name = name ;
    }

    public void print_firstName(){
        System.out.println("F : " + name) ;
    }
}

class SecondCLass extends FirstClass{

    String secondName ;

    SecondCLass(String name,String secondName){
        super(name);
        this.secondName = secondName ;
    }

    public void print_sirname(){
        System.out.println("L : " + secondName) ;
    }
}