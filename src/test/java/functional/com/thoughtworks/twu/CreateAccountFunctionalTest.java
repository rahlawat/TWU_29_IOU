package functional.com.thoughtworks.twu;


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
        webDriver=new HtmlUnitDriver();
        webDriver.get("http://localhost:9130/twu/createAccount");

    }

    @Test
    public void shouldSubmit()
    {
        WebElement submitButton = webDriver.findElement(By.name("create_account_button"));
        WebElement nameElement=webDriver.findElement(By.name("name_text"));
        nameElement.sendKeys("Yue");
        WebElement emailElement=webDriver.findElement(By.name("email_text"));
        emailElement.sendKeys("Yue@gmail.com");
        WebElement passwordElement=webDriver.findElement(By.name("password_text"));
        passwordElement.sendKeys("Yue");
        WebElement phoneNumberElement=webDriver.findElement(By.name("phone_number_text"));
        phoneNumberElement.sendKeys("1111");




        submitButton.submit();

        assertThat(webDriver.getCurrentUrl(),is("http://localhost:9130/twu/dashboard"));
    }

    @AfterClass
    public static void tearDown()
    {

        webDriver.close();

    }



}