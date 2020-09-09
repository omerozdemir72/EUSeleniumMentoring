package Mentoring_3_Actions_Class_Slider;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class hotels {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverWait wait;
        JavascriptExecutor js;


        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.hotels.com/");

        driver.findElement(By.cssSelector(".sprite-flags ")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".widget-overlay-bd>:nth-child(2)>:nth-of-type(86)")).click();



        WebElement sehir = driver.findElement(By.cssSelector("#qf-0q-destination"));

        sehir.sendKeys("Frankfurt");
        sehir.sendKeys(Keys.ENTER);


        /*
        Todo    Slider için adımlar:

        1. Minimum için en sol taraftaki slider'ın kodunu bulun.
        2.Maximum için en sağ taraftaki slider'ın kodunu bulun.
        3.Çubuğun kodunu bulun ve daha sonra çubuğun en uzun halinin uzunluğunu bulun. (    int genisligi = kaydiriciCubugu.getSize().getWidth();  )
        4.Sitedeki default max ve min değerleri belirleyin.
        5.Kendi istediginiz max ve min değerleri belirleyin. (max değeri eksili belirleyin. Çünkü çubugu x ekseninin tersi yönünde hareket ettirmemiz gerekiyor!)
        6. Nereden, ne kadar kaydırma yapacagınızı belirleyin. İçler dışlar formülünü uygulayın:    int kaydirmaOrani1 = (altFiyatim * genisligi) / (genelMaxFiyat-genelMinFiyat);
       todo işlem:

         500 te 153 birim uzunlugu var ise,   kendi belirledigim fiyatta cubuk uzunlugu kaç olur ?
kendi fiyatim ile 153 ü çarpıyorum ve 500 e bölüyorum. Yeni uzunlugu buluyorum

   500                         153
    kendifiyatim         ?

    7.Actions methodu içerisine, önce hangi slideri hareket ettireceginizi, X ekseninde ne kadar hareket ettireceginizi, varsa Y ekseninde ne kadar hareket ettireceginizi(yoksa 0 ) yazın ve .perform(); diyin:

     actions.dragAndDropBy(solKaydirici,kaydirmaOrani1,0).perform();


         */

        WebElement solKaydirici = driver.findElement(By.cssSelector("div[aria-controls='f-price-min']"));
        WebElement sagKaydirici = driver.findElement(By.cssSelector("div[aria-controls='f-price-max']"));

        WebElement kaydiriciCubugu = driver.findElement(By.xpath("(//div[@class='widget-slider-highlight'])[1]"));

        int genisligi = kaydiriciCubugu.getSize().getWidth();

        System.out.println("Fiyat çubuğu genişliği :   " + genisligi);

//          Sitenin en geniş fiyat aralığı
        int genelMaxFiyat = 500;
        int genelMinFiyat = 0;

//      Fiyat aralığımı 100-400 $ arası yapmak istiyorum.
        int altFiyatim= 100;

   //               eksili bir değer kullanacağımız için 100 birim geri gelmemiz gerekiyor..
        int ustFiyatim=-100;

        Actions actions = new Actions(driver);
/*

500 te 153 birim uzunlugu var ise,   kendi belirledigim fiyatta cubuk uzunlugu kaç olur ?
kendi fiyatim ile 153 ü çarpıyorum ve 500 e bölüyorum. Yeni uzunlugu buluyorum

    500                         153
    kendifiyatim         ?


 */
//                                                                                                        500   - 0
        int kaydirmaOrani1 = (altFiyatim * genisligi) / (genelMaxFiyat-genelMinFiyat);
        int kaydirmaOrani2 = (ustFiyatim* genisligi) / (genelMaxFiyat-genelMinFiyat);


            actions.dragAndDropBy(solKaydirici,kaydirmaOrani1,0).perform();
        actions.dragAndDropBy(sagKaydirici,kaydirmaOrani2,0).perform();

        Thread.sleep(3000);


        WebElement puanSolslider = driver.findElement(By.xpath("//div[@aria-labelledby='f-guest-rating-min-label']"));
        WebElement puanSagSlider = driver.findElement(By.xpath("//div[@aria-labelledby='f-guest-rating-max-label']"));
        WebElement puanSlideCubugu = driver.findElement(By.xpath("(//div[@class='widget-slider-cont'])[2]"));

        int puanGenislik = puanSlideCubugu.getSize().getWidth();

        System.out.println("Puan çubuğu genişliği:  " + puanGenislik);

        int puanAltSinir = 0;
        int puanUstSinir =10;

        int  istedigimAltSinir= 2;
        double istedigimUstSinir= 3.5;

        int kaydirmaOrani3=  (istedigimAltSinir *puanGenislik / (puanUstSinir - puanAltSinir));
        double kaydirmaOrani4=  (istedigimUstSinir *puanGenislik / (puanUstSinir - puanAltSinir));

        actions.dragAndDropBy(puanSolslider,kaydirmaOrani3,0).perform();
        actions.dragAndDropBy(puanSagSlider, (int) -kaydirmaOrani4,0).perform();



















    }
}
