package Mentoring_7_DataProvider_SoftHard_Test.DataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dataProvider1 {


/*    @DataProvider
    public Object[][] dataProviderMethod(){

        Object [] [] a= new Object[2][1];

        a[0][0] = "data 1";
        a[1][0] = "data 2";

        return a;
     } */



    @DataProvider(name = "myData")
    public Object [] dataProviderMethod(){

        Object [] a = {"data1","data2","data3"};

        return a;
    }



  /*   @Test(dataProvider = "dataProviderMethod")
    public void TestMethod(String data){

         System.out.println("Data:  " + data);
     } */

    @Test(dataProvider = "myData")
    public void Test2(String data){

        System.out.println("Data :  " + data);
    }

}
