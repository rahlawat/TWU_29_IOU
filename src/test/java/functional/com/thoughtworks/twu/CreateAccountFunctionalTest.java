package functional.com.thoughtworks.twu;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CreateAccountFunctionalTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void setUp()
    {
        webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_3_6);
        //webDriver.get("http://localhost:9130/twu/login");
        webDriver.get("http://localhost:9130/twu/createAccount");
    }

    @Test
    public void shouldCreateAccount()
    {
        //WebElement goToCreateAccountButton = webDriver.findElement(By.name("goToCreateAccountButton"));

        //goToCreateAccountButton.submit();

        //assertThat(webDriver.getCurrentUrl(),is("http://localhost:9130/twu/createAccount"));

        WebElement emailElement=webDriver.findElement(By.name("email"));
        emailElement.sendKeys("Yue@gmail.com");

        WebElement nameElement=webDriver.findElement(By.name("username"));
        nameElement.sendKeys("Yue");

        WebElement passwordElement=webDriver.findElement(By.name("password"));
        passwordElement.sendKeys("yue123");

        WebElement phoneNumberElement=webDriver.findElement(By.name("phoneNumber"));
        phoneNumberElement.sendKeys("");

        WebElement createAccountButton = webDriver.findElement(By.name("createAccountButton"));

        createAccountButton.submit();

        assertThat(webDriver.getCurrentUrl(),is("http://localhost:9130/twu/dashboard"));
    }

    @AfterClass
    public static void tearDown()
    {

        webDriver.close();

    }



}