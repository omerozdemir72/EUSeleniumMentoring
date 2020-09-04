package Selenium_Odev1_Cozum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class a_practiceForm {
    public static void main(String[] args) throws InterruptedException {
/*
Ödev:
            https://demoqa.com/automation-practice-form   bu siteye gidin.
todo        SADECE aşağıda bahsedilen kısımları doldurunuz !
1.  Name
2.    LastName
3.      Email
4.      Gender:
5.      Hobbies
6.      Current adress
7.      submit butona tıkla
8.      Ekrandaki mesajı dogrula
9.      2 Saniye bekledikten sonra close butonuna bas
10.   2 saniye bekleyip sistemi kapat.

            name,id, classname ve kendinizi geliştirmek için daha çok CSS SELECTOR ile aramalar yapın.
            Buraları kendinize göre doldurun.
            Submit butonuna bastırın.

             yeni bir bilgi çerçevesi açılacaktır.
             Bilgi çerçevesinin başlığının ekranda gözüküp gözükmediğini check edin. (Eğer gözüktüyse formda zorunlu olan kısımları doldurmuşsunuz demektir,yani sorun yok demektir.)

             Bilgi mesajı : Thanks for submitting the form
            Onu görünce de close butonuna bastırın ve bekleyip sistemi tamamen kapatın.

            Test başarıyla tamamlandıysa konsolda "Formu doldurdugunuz için teşekkür ederiz..." mesajı yazsın.

        todo   NOT: CSS SELECTOR ile arama yaparken input, button, label gibi tag leri de iyi inceleyin.
            Bu test ısınma içindir. CSS selector pazartesi günü daha detaylı görülecektir.

 */

        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();



driver.findElement(By.cssSelector("input#firstName")).sendKeys("Ömer");


        driver.findElement(By.cssSelector("#lastName.mr-sm-2")).sendKeys("Özdemir");


driver.findElement(By.cssSelector("div>input#userEmail")).sendKeys("omer@gmail.com");


driver.findElement(By.cssSelector("label[for=gender-radio-1]")).click();


driver.findElement(By.cssSelector("#userNumber")).sendKeys("0535123123");


        driver.findElement(By.cssSelector("label[for=hobbies-checkbox-3]")).click();


        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("Germany");



        driver.findElement(By.cssSelector("button.btn-primary")).click();


        WebElement gerceklesecekOlanMesaj = driver.findElement(By.cssSelector(".modal-title"));

        String beklenenMesaj="Thanks for submitting the form";


        Assert.assertEquals(beklenenMesaj,gerceklesecekOlanMesaj.getText());

        System.out.println("Formu doldurduğunuz için teşekkür ederiz....");


        Thread.sleep(2000);

        driver.findElement(By.cssSelector("div>button#closeLargeModal")).click();

        Thread.sleep(2000);

        driver.quit();

    }
}
