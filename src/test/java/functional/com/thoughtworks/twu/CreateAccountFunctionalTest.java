package functional.com.thoughtworks.twu;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.thoughtworks.twu.domain.User;
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
    private static User user;
    @BeforeClass
    public static void setUp()
    {
        webDriver = new FirefoxDriver();
        webDriver.get("http://localhost:9130/twu/login");

        user = new User("yding@thoughtworks.com","Yue","yue123","");
    }

    @Test
    public void shouldCreateAccount()
    {
        WebElement goToCreateAccountButton = webDriver.findElement(By.name("goToCreateAccountButton"));

        goToCreateAccountButton.click();

        assertThat(webDriver.getCurrentUrl(),is("http://localhost:9130/twu/createAccount"));

        WebElement emailElement=webDriver.findElement(By.name("email"));
        emailElement.sendKeys(user.getEmail());

        WebElement nameElement=webDriver.findElement(By.name("username"));
        nameElement.sendKeys(user.getUsername());

        WebElement passwordElement=webDriver.findElement(By.name("password"));
        passwordElement.sendKeys(user.getPassword());

        WebElement phoneNumberElement=webDriver.findElement(By.name("phoneNumber"));
        phoneNumberElement.sendKeys(user.getPhoneNumber());

        WebElement createAccountButton = webDriver.findElement(By.name("createAccountButton"));
        createAccountButton.submit();

        assertThat(webDriver.getCurrentUrl(),is("http://localhost:9130/twu/login"));

//        WebElement welcomeMessage = webDriver.findElement(By.name("welcomeMessage"));
//        assertThat(welcomeMessage.getText(), is("Hi " + user.getUsername()));
    }

    @AfterClass
    public static void tearDown()
    {

        webDriver.close();

    }



}