package org.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(@class,'js-message-load-more')]")
    private WebElement moreButton;

    @FindBy(xpath = "//div[contains(@class,'ns-view-messages-item-wrap')]")
    private WebElement message;

    private static int WAIT_TIMEOUT = 5;

    public MailBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isMoreButtonDisplay() {
        return moreButton.isDisplayed();
    }

    public void clickMoreButton() {
        moreButton.click();
        WebElement loader = driver.findElement(By.xpath("//span[contains(@class,'nb-loader')]"));
        (new WebDriverWait(driver, WAIT_TIMEOUT))
                .until(ExpectedConditions.stalenessOf(loader));
    }

    public int getMessageCount() {
        return driver.findElements(By.xpath("//div[contains(@class,'ns-view-messages-item-wrap')]")).size();
    }
}
