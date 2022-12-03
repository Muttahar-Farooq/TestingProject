package com.example.testingproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected static final String PAGE_URL = "https://magento.softwaretestingboard.com/";

    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/ul[1]/li[1]/span[1]")
    public WebElement myAccountText;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginSuccessfulTxt(){
        return myAccountText.getText();
    }
}
