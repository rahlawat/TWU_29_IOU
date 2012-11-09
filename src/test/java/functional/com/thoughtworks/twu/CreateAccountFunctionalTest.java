package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.domain.User;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class CreateAccountFunctionalTest {

    private static WebDriver webDriver;
    private static User user;

    @BeforeClass
    public static void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("http://localhost:9130/twu/login");


        user = new User(RandomStringUtils.randomAscii(10), "Yue", "yue123", "");

    }

    @Test
    public void shouldCreateAccount() {
        WebElement goToCreateAccountButton = webDriver.findElement(By.name("goToCreateAccountButton"));

        goToCreateAccountButton.click();

        assertThat(webDriver.getCurrentUrl(), is("http://localhost:9130/twu/createAccount"));

        WebElement emailElement = webDriver.findElement(By.id("email"));
        emailElement.sendKeys(user.getEmail());

        WebElement nameElement = webDriver.findElement(By.id("username"));
        nameElement.sendKeys(user.getUsername());

        WebElement passwordElement = webDriver.findElement(By.id("password"));
        passwordElement.sendKeys(user.getPassword());

        WebElement phoneNumberElement = webDriver.findElement(By.id("phoneNumber"));
        phoneNumberElement.sendKeys(user.getPhoneNumber());

        WebElement createAccountButton = webDriver.findElement(By.id("createAccountButton"));
        createAccountButton.submit();

        assertThat(webDriver.getCurrentUrl(), is("http://localhost:9130/twu/login"));
    }

    @AfterClass
    public static void tearDown() {

        webDriver.close();

    }


}