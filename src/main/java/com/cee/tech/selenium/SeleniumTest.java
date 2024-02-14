package com.cee.tech.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Driver;
import java.time.Duration;


public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:5173/login");
        WebElement usernameInput = driver.findElement(By.id("username"));

        // Find password input by ID
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("userButton"));


        usernameInput.sendKeys("admin@gmail.com");
        passwordInput.sendKeys("123");
        Thread.sleep(300);

        loginButton.click();


       addEvent(driver);




        driver.getTitle();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        //    wait if the title is not available
        //    read data of the booking page
    }

    public  static  void addEvent(WebDriver driver){
        driver.get("http://localhost:5173/admin/ticketmanagement");

        WebElement addHouse= driver.findElement(By.id("createEvent"));
        addHouse.click();

        WebElement fixtureType= driver.findElement(By.id("fixtureType"));
        WebElement totalTickets= driver.findElement(By.id("totalTickets"));
        WebElement totalVip= driver.findElement(By.id("totalVip"));
        WebElement vipAmount= driver.findElement(By.id("vipAmount"));
        WebElement totalNormal= driver.findElement(By.id("totalNormal"));
        WebElement normalAmount= driver.findElement(By.id("normalAmount"));
        WebElement addEventButton= driver.findElement(By.id("submitButton"));

        fixtureType.sendKeys("Kenya Premier League");
        totalTickets.sendKeys("1000");
        totalVip.sendKeys("100");
        vipAmount.sendKeys("100,000");
        totalNormal.sendKeys("900");
        normalAmount.sendKeys("10,0000");


        addEventButton.click();
    }
}
