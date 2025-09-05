package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String username = "standard_user";
        String url = "https://www.saucedemo.com/v1/index.html";


        //create driver object
        WebDriver myBrowser = new ChromeDriver();

        //Navigate to url
        myBrowser.get(url);

        // Maximize window
        myBrowser.manage().window().maximize();

        myBrowser.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        myBrowser.findElement(By.id("password")).sendKeys("secret_sauce");
        myBrowser.findElement(By.id("login-button")).click();


        //Thread.sleep Not recommended
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        //Waits in selenium java

        //1.Implicit wait
        //myBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //myBrowser.findElement(By.cssSelector("span[class=\"title\"]"));

        //explicit wait
         /*WebDriverWait explicitWait = new WebDriverWait(myBrowser,Duration.ofSeconds(5));
         explicitWait.until(ExpectedConditions.visibilityOf( myBrowser.findElement(By.className("title"))));
         explicitWait.until(ExpectedConditions.visibilityOf( myBrowser.findElement(By.className("app_logo-"))));*/


        //fluent wait
        FluentWait fluentWait = new FluentWait(myBrowser);
        fluentWait.withTimeout(Duration.ofSeconds(5));
        fluentWait.pollingEvery(Duration.ofSeconds(1));
        fluentWait.until(ExpectedConditions.visibilityOf(myBrowser.findElement(By.className("title"))));


        //click add to cart to any product
        //get text of remove button (system.out)
        //click product name
        //click on remove
        //get text of add to cart button (system.out)*/

        //close browser*/
        myBrowser.quit();
        //myBrowser.close();
    }
}