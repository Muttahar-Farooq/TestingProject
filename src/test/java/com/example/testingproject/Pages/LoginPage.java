package com.example.testingproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button/span")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement emailFormControl;

    @FindBy(id = "pass")
    private WebElement passwordFormControl;

    @FindBy(xpath = "//div[contains(text(),'The account sign-in was incorrect or your account ')]")
    private WebElement loginFailedText;

    private WebDriver driver;
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void initElements() {
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String value) {
        emailFormControl.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordFormControl.sendKeys(value);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean checkLoginFailedText(){ return loginFailedText.isDisplayed();}
}
