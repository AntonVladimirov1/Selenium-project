package com.cydeo.test.Day09_Javafaker_DriverUtil;

public class Singleton {

    private Singleton(){}

    private static String word;

    public static String getWord(){

        if (word == null){
            System.out.println("First time call. Word object is null.");
            System.out.println("Assigning value to it now.");
            word = "something";
        }else {
            System.out.println("Word already has a value");
        }
        return word;
    }

}
