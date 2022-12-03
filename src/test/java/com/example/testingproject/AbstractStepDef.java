package com.example.testingproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class AbstractStepDef {

    private static final Duration WAIT_TIME = Duration.ofSeconds(10);

    static WebDriver driver;

    protected static HomePage homePage;
    protected static LoginPage loginPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
}
