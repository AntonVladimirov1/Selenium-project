package com.cydeo.test.Day09_Javafaker_DriverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice  {

    @Test
    public void test1(){

        Faker faker = new Faker();

        System.out.println("firstName() = " + faker.name().firstName());
        System.out.println("lastName() = " + faker.name().lastName());
        System.out.println("fullName() = " + faker.name().fullName());
        System.out.println("birthday() = " + faker.date().birthday());
        System.out.println("fullAddress() = " + faker.address().fullAddress());
        System.out.println("phone = " + faker.numerify("###-###-####")); // phone number generator
        System.out.println("username() = " + faker.name().username());
        System.out.println("password() = " + faker.internet().password());
        System.out.println("letterify = " + faker.letterify("???-??-?????-??")); // generate letters
        System.out.println("Pupka facts = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Pupka"));

    }

}
