package com.example.testingproject.StepDefinitions;

import com.example.testingproject.Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.ro.Si;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractStepDef {

    private static final int WAIT_TIME = 30;

    static WebDriver driver;

    protected static HomePage homePage;
    protected static LoginPage loginPage;
    protected static CartPage cartPage;
    protected static SearchPage searchPage;
    protected static SingleItemPage singleItemPage;
    protected static CheckoutPage checkoutPage;

//    static {
//        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(
//                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
//        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
//
//        homePage = new HomePage(driver);
//        loginPage = new LoginPage(driver);
//        cartPage = new CartPage(driver);
//        searchPage = new SearchPage(driver);
//        singleItemPage = new SingleItemPage(driver);
//        checkoutPage = new CheckoutPage(driver);
//
//    }

    public static void setDriver(){
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        searchPage = new SearchPage(driver);
        singleItemPage = new SingleItemPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }
}
