package com.dembla.jvm.enums;



public enum EnumClassDemo {

    BIOGRAPHY,
    HORROR;

    public static void main(String[] args) {
        for (EnumClassDemo en : EnumClassDemo.values()) {
            System.out.println("Name : " + en.name());
            System.out.println("Ordinal : " + en.ordinal());
            System.out.println("Declaring Class : " + en.getDeclaringClass());
            System.out.println("Compare to  : " + en.compareTo(EnumClassDemo.BIOGRAPHY));
            System.out.println("Equals to  : " + en.equals(EnumClassDemo.BIOGRAPHY));
            System.out.println("-----------------------------");
        }
    }
}


