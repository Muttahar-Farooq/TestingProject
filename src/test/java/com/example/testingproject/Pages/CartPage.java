package com.example.testingproject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public String getNoItemCartMessage(){
        return driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]")).getText();
    }

    public String getItemTitleInCart(){
        return driver.findElement(new By.ByXPath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[1]/div/strong/a")).getText();
    }

    public boolean checkIsCheckButtonDisplayed(){
        return driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button/span")).isDisplayed();
    }
}
