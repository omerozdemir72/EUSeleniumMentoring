package a_Selenium_Odev1_Cozum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Odev_Xpath {

    public static void main(String[] args) throws InterruptedException {

/*
https://form.jotform.com/202426526543351   bu websitesine git

2. isim soyisimi doldur.

3.iletişim no yu doldur.

4.emaili doldur.

5.Ne zaman çalışabilirsin kısmındaki seçeneklere 1'er saniye bekleme ile sırayla tıklat. (Liste oluştur ve döngü ile tıklat)
en son other kısmına geldiginde kutucuk açılacak. oraya   "5-9 "   yazdır.


6.İlgi alanı kısmında sırasıyla,
Mentoring dinlemek , Java , Selenium,   Ömer hocanın mentoringleri     kısımlarına tıkla.

Ve bunları konsola yazdır. Tıkladıgımız kısımları konsola yazdırın.
todo  (lütfen tek tek kodlarını bulup tıklatmayın. List oluşturup döngü ile tıklatın. Oradaki matematiği size bırakıyorum :)


7. Özel bir yetenegin var mı ? kısmı için,
Her Run yaptıgınızda, her yeni testte farklı bir checkbox a tıklasın. Random oluşturun ve oradaki seçeneklerden birisine random tıklasın.
ve tıkladığı şeyi konsola yazdırsın.


8.Yorumunuz:

"Geri dönüşünüzü sabırsızlıkla bekliyorum. "  Yazsın.

9.Formu gönder ' e tıkla.


10. Thank you yazısını check et. Eger thank you yazıyorsa form başarı ile doldurulmus demektir.

Thank You !         mesajını test edin.

todo        Konsoldaki görüntü şöyle olmalı:
İlgi alanlarım :
İsmet hocanın dersleri
Java
Selenium
Ömer hocanın mentoringleri
Özel yeteneğim :  Javada çok iyiyim
Form başarıyla gönderilmiştir..





todo NOT :    JavascriptExecutor js =(JavascriptExecutor) driver;

 Bu kodu        driver.get() methodunun altındaki satıra yapıştırın.  ScrollDown kodudur.



 todo  2:       js.executeScript("window.scrollBy(0,600)");
 bu kodu ise sizlere verdiğim ödevdeki 5. aşamadan (other kısmına 5-9 yazdırın kısmından) sonraki satıra yapıştırın. 5-9 yazdıktan sonra   sayfayı aşağıya scrollayacak. Şimdilik bunu dedigim gibi yapıştırın.
 ileride detayını göreceğiz...          Bu iki kodu direkt copy paste yapın.


 */





















        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://form.jotform.com/202426526543351");

        JavascriptExecutor js =(JavascriptExecutor) driver;





        driver.findElement(By.cssSelector("#first_3")).sendKeys("Ömer");


        driver.findElement(By.cssSelector("#last_3")).sendKeys("Özdemir");



        driver.findElement(By.xpath("(//input[@type='tel'])[1]")).sendKeys("157");

        driver.findElement(By.xpath("(//input[@type='tel'])[2]")).sendKeys("39471072");

        driver.findElement(By.xpath("//input[@placeholder='ex: myname@example.com']")).sendKeys("omerozdemir72@gmail.com");



List<WebElement> calismaSaatleri = driver.findElements(By.cssSelector("#id_11>div>div>span"));


        for (int i = 0; i <calismaSaatleri.size() ; i++) {

            calismaSaatleri.get(i).click();
            Thread.sleep(1000);

        }

        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#input_21")).sendKeys("5-9");



        js.executeScript("window.scrollBy(0,600)");
 List<WebElement> ilgiAlani = driver.findElements(By.xpath("(//div[@class='form-single-column'])[2]//span[@class='form-checkbox-item']"));

 System.out.println("İlgi alanlarım : ");
        for (int i = 0; i <ilgiAlani.size() ; i+=2) {
            ilgiAlani.get(i).click();
            System.out.println(ilgiAlani.get(i).getText()  + "     ");
            Thread.sleep(1000);
        }




        List<WebElement> OzelYetenek= driver.findElements(By.xpath("(//div[@class='form-single-column'])[3]//span[@class='form-checkbox-item']"));
       int random = (int) (Math.random()*OzelYetenek.size());
        System.out.println("Özel yeteneğim :  "   +   OzelYetenek.get(random).getText());
       OzelYetenek.get(random).click();



       driver.findElement(By.xpath("//textarea[@id='input_16']")).sendKeys("Geri dönüşünüzü sabırsızlıkla bekliyorum...");

       driver.findElement(By.xpath("//button[contains(text(),'Formu')]")).click();

       Thread.sleep(1000);


        Assert.assertEquals("Thank You",driver.getTitle());

        System.out.println("Form başarıyla gönderilmiştir..");

//        Thread.sleep(2000);
//        driver.quit();
        }
        }



