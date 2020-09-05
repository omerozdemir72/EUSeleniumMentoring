package Mentoring_2_Select_Class;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectClass {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://form.jotform.com/202468401801346");
        JavascriptExecutor js =(JavascriptExecutor) driver;

//      isim
        WebElement Ad= driver.findElement(By.cssSelector("input[id='first_4']"));
        Ad.sendKeys("ömer");

        //soyisim
        WebElement soyad= driver.findElement(By.cssSelector("input[id='last_4']"));
        soyad.sendKeys("özdemir");

String firstUrl = driver.getCurrentUrl();


        System.out.println("İlk URL :  " + firstUrl);


        WebElement  element = driver.findElement(By.cssSelector("select#input_14"));


        Select slc = new Select(element);
        slc.selectByVisibleText(" Hukuk Fakültesi ");



        element=driver.findElement(By.xpath("//select[@id='input_20']"));
        slc = new Select(element);
        slc.selectByIndex(3);


        driver.findElement(By.cssSelector("#input_12_area")).sendKeys("+49");
        driver.findElement(By.cssSelector("#input_12_phone")).sendKeys("17661792412");


        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("omer@gmail.com");

        driver.findElement(By.xpath("//input[@id='input_3_addr_line1']")).sendKeys("Yildirim Sk.");


        driver.findElement(By.cssSelector("#input_3_addr_line2")).sendKeys("westpark");
        driver.findElement(By.cssSelector("#input_3_city")).sendKeys("duseldorf");
        driver.findElement(By.cssSelector("#input_3_state")).sendKeys("krefeld");
        driver.findElement(By.cssSelector("#input_3_postal")).sendKeys("47799");

        element=driver.findElement(By.cssSelector("#input_3_country"));
        slc=new Select(element);
        slc.selectByValue("Germany");

        js.executeScript("window.scrollBy(0,600)");

element = driver.findElement(By.cssSelector("#input_11"));

slc=new Select(element);
//todo    Select tag 'inin içerisindeki options lara ulaşmak için -- >>    getOptions();
        List<WebElement>burs=slc.getOptions();
  //todo     Kaç adet options varsa, int option Sayisina eşitlendi.
        int optionSayisi = burs.size();
        int random = (int)((Math.random()*optionSayisi)+1);
        slc.selectByIndex(random);



        element=driver.findElement(By.cssSelector("#input_19"));
        slc=new Select(element);
        slc.selectByValue("10");

        element =driver.findElement(By.cssSelector("#input_21"));
       slc = new Select(element);

        slc.selectByValue("Internet");


        driver.findElement(By.xpath("//input[@type='radio']")).click();



driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

Thread.sleep(1000);

String secondUrl = driver.getCurrentUrl();
        System.out.println("ikinci sayfanın URl'i :  " + secondUrl);

        // sayfanın Url ine göre test
        Assert.assertEquals("https://submit.jotformeu.com/submit/202468401801346/",driver.getCurrentUrl());


        String actualResult = driver.findElement(By.xpath("//div[@id='stage']//h1")).getText();
        Assert.assertTrue("Hata...", actualResult.contentEquals("Thank You!"));



        WebElement submission = driver.findElement(By.xpath("//*[@id=\"stage\"]/div/p"));
        Assert.assertEquals("Hata", "Your submission has been received.", submission.getText());

    }
}
