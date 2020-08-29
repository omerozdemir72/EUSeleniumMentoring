package Locators_Css_Selector_Ders_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreTest {
    public static void main(String[] args) {



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

        listButton.click();








    }

}
