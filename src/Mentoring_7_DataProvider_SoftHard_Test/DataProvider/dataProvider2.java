package Mentoring_7_DataProvider_SoftHard_Test.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider2 {
    @DataProvider
    public Object[][] getData(){

        Object [][] data= new Object[3][2];


        //2.   Yol
 /*       Object [][] data1= {
                {"omer12","password1"},
                {"cigdem12,","password2"},
                {"huseyin12","password3"}
        }; */
        //Ömer kullanıcı bilgileri


        data[0][0] = "omeroz12";
        data[0][1] = "password1";
        //Çiğdem kullanıcı bilgileri
        data[1][0] = "cigdem12";
        data[1][1] = "password2";
        //Hüseyin kullanıcı bilgileri
        data[2][0] = "huseyin12";
        data[2][1] = "password3";

return data;

    }

    @Test(dataProvider = "getData")
    public void infoTest(String username,String password){

        System.out.println("username:  " + username);
        System.out.println("password  " + password);
    }
}
