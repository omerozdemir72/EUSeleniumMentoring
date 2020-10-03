package Mentoring_7_DataProvider_SoftHard_Test.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class facebookTest {
    WebDriver driver;


@DataProvider
public Object [][]myData(){
    //3 kullanıcı denenecek, içerisinde 2 adet bilgi olacak. email ve pass
    Object [][] facebookData= new Object[3][2];

    /*
    Object [][] facebookData={
                {"ahmet@gmail.com","abc"},
                {"ayse@gmail.com,"xyz"},
                {"mehmet@gmail.com","bcd"}
     */

    //1. kullanıcı
    facebookData[0][0]="omer@gmail.com";
    facebookData[0][1]="password1";
//2. kullanıcı
    facebookData[1][0]="huseyin@gmail.com";
    facebookData[1][1]="password2";

//3. kullanıcı
    facebookData[2][0]="volkan@gmail.com";
    facebookData[2][1]="password3";
    return facebookData;
}
@Test(dataProvider = "myData")
    public void Test1(String email,String password) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
String isim1 = "omer@gmail.com";
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("pass")).sendKeys(password);

    Thread.sleep(2000);

    driver.quit();


}

}
