package com.example.testingproject.StepDefinitions;

import com.example.testingproject.Pages.LoginPage;
import com.example.testingproject.Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractStepDef {

    private static final int WAIT_TIME = 30;

    static WebDriver driver;

    protected static HomePage homePage;
    protected static LoginPage loginPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C://ChromeDriver//chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mutta\\IdeaProjects\\TestingProject\\src\\test\\resources\\driver\\geckodriver.exe");
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
}
