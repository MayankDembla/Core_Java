package com.dembla.jvm.enums;

public enum EnumStateBehaviour {

    BIOGRAPHY(10),
    HORROR(18) ;
    // Private Constructor by default.
    EnumStateBehaviour(int minagetoRead){
       this.minagetoRead = minagetoRead ;
    }
    // have instance variable
    public final int minagetoRead ;
    // have instance methods
    public int getMinagetoRead(){
         return this.minagetoRead ;
    }
    // Have static method
    public static void getStatus(){
        System.out.println("Getting Status");
    }
}

class Demo {
    public static void main(String[] args) {
        EnumStateBehaviour.getStatus();
        EnumStateBehaviour.BIOGRAPHY.getMinagetoRead() ;
        int val = EnumStateBehaviour.HORROR.minagetoRead;
        System.out.println(val);
    }
}
