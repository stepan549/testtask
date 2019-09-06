package org.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='auth-navigation__li']/a[contains(text(),'Почта')]")
    private WebElement mailBoxLink;

    @FindBy(xpath = "//a[contains(@class,'logedin')]")
    private WebElement logedLink;

    @FindBy(xpath = "//a[@class='enter']")
    private WebElement authorizeLink;

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='b-hold']/input[@type='submit']")
    private WebElement singInButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAuthLink() {
        authorizeLink.click();
    }

    public MainPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
        return this;
    }

    public void singIn() {
        singInButton.click();
    }

    public void clickLogedLink() {
        logedLink.click();
    }

    public void clickMailBox() {
        mailBoxLink.click();
    }
}
