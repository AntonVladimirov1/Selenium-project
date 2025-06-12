package UI_Testing.test.Day09_Javafaker_DriverUtil;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test
    public void singleton_understanding(){

        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
    }

}
