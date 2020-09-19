package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class Testler_assert {


    @BeforeClass
    public void BeforeClass(){


        System.out.println("SİSTEM BAŞLATILIYOR .......................................................................");

    }




    @Test(priority = 2)
    public void Test1(){

        Random random = new Random();

        int a = random.nextInt(10);
        int b = random.nextInt(10);

        int c = a+b;
        System.out.println("c:  " + c );

        Assert.assertTrue(c<12);

    }
    @AfterClass
    public void AfterClass(){

        System.out.println("SİSTEM KAPATILIYOR .............................");
    }

    @Test(priority = 1)
    public void Test2(){

        int a = 5;
        int b = 10;

        //ilk önce actual, yani sistemin bize verecegi sonuç   ,,,,    bizim istedigimiz expected kısmı
        Assert.assertEquals(a+b,15);
        //Junit
      //  Assert.assertEquals(15,a+b);

        System.out.println("Sonuç 15 tir.");


    }

}
