package Mentoring_5_Alert_Handle_Window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/omero/Selenium/ChromeDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.demo.guru99.com/test/delete_customer.php");


        WebElement id = driver.findElement(By.cssSelector("input[name='cusid']"));

        id.sendKeys("omer123");

        WebElement submitButton = driver.findElement(By.cssSelector("input[name='submit']"));

        submitButton.click();

        Thread.sleep(1500);

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();


        Thread.sleep(1500);

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.quit();

        driver.switchTo().alert().dismiss();


    }
    }


