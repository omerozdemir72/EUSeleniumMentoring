package Mentoring_1_Locators_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;


public class MyStoreTest {
    public static void main(String[] args) throws InterruptedException {



        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common/home");



//  css        Basit hali
        WebElement searchArea = driver.findElement(By.cssSelector("input[name=search]"));

        searchArea.sendKeys("Iphone");

//          Class aramak için "." (nokta) kullanıyoruz.                                               Tüm html kodlarında class ismi arama
        WebElement searchButton=driver.findElement(By.cssSelector(".btn-default.btn-lg"));

        searchButton.click();
        //      Tüm buttonların içerisindeki class ismini arama : >>>>    button.btn-default
        //child-parent          span.input-group-btn>button


        /* todo   ID
        button[id=list-view]
        button#list-view
         */

        WebElement listButton = driver.findElement(By.cssSelector("button#list-view"));
//.fa.fa-th-list
        listButton.click();



/*
todo  Contains   * işareti ile bulunur.

button[onclick*=cart]
 */
        driver.findElement(By.cssSelector("button[onclick*=cart]")).click();


/*
todo Starts with-- >    Başlangıçtaki karakter ile bulma  ^ ile buluruz.    ^=
html kodu : wishlist.add('40');

button[onclick^='w']
 */

        Thread.sleep(1000);
WebElement alert = driver.findElement(By.cssSelector("div.alert"));

//Alert 'ün text halini görmek için yazdırma işlemi
       // System.out.println(alert.getText());


String textAlert  = alert.getText();

//benim istediğim sonuç
        String myAlert ="Success: You have added iPhone to your shopping cart!";


        /*
        todo 2. kısım

              Assert.assertTrue(textAlert.contains(myAlert),"ürün eklenirken bir sorun olustu");
         */


Assert.assertEquals("Success: You have added iPhone to your shopping cart!\n" +
        "×",textAlert);
        System.out.println("Ürün başarıyla karta eklenmiştir..");




        /*
        nth of type
     ilkii bulmak için:     class ismi button-group olan div in içerisindeki, 1. buttonu ver  -------     div.button-group>button:first-of-type
     sonuncuyu bulmak için: div.button-group>button:last-of-type
     ortadakini veya herhngi bir tanesini bulmak için : div.button-group>button:nth-of-type(2)


     google arama kısmı için

     ul.erkvQe>li:nth-of-type(2)
         */


        driver.findElement(By.cssSelector("span#cart-total")).click();

        Thread.sleep(1000);


WebElement totalPrice = driver.findElement(By.cssSelector(".table-bordered>tbody>:last-of-type>:last-of-type"));

        System.out.println(totalPrice.getText());


        Assert.assertEquals("$123.20",totalPrice.getText());

        System.out.println("Fiyat carta işlenmiştir..");
    }

}
