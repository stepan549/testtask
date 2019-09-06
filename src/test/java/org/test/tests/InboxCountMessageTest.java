package org.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.pages.MailBoxPage;
import org.test.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InboxCountMessageTest {
    private WebDriver driver;
    private static String KEY_BROWSER_PARAM = "webdriver.chrome.driver";
    private static int WAIT_PARAM = 10;

    @BeforeMethod
    @Parameters({"browserPath", "mainPage"})
    public void setUp(String browserPath, String mainPage) {
        System.setProperty(KEY_BROWSER_PARAM, browserPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_PARAM, TimeUnit.SECONDS);
        driver.get(mainPage);
    }


    @Test
    @Parameters({"login", "password"})
    public void test(String login, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickAuthLink();
        mainPage.enterLogin(login).enterPassword(password).singIn();
        mainPage.clickLogedLink();
        mainPage.clickMailBox();
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        MailBoxPage mailBoxPage = new MailBoxPage(driver);
        while (mailBoxPage.isMoreButtonDisplay()) {
            mailBoxPage.clickMoreButton();
        }
        System.out.println("Count of messages: " + mailBoxPage.getMessageCount());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
