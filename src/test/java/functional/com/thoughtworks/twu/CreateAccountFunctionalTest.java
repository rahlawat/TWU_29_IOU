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

        String email = RandomStringUtils.randomAscii(10) + "@thoughtworks.com";

        user = new User(email, "Mengqiu", "mq1234", "");
    }

    @Test
    public void shouldCreateAccount() {
        webDriver.get("http://localhost:9130/twu/login");

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

    @Test
    public void shouldNotSubmitWhenHaveBlankFields(){
        webDriver.get("http://localhost:9130/twu/createAccount");

        WebElement emailElement=webDriver.findElement(By.name("email"));
        emailElement.sendKeys("");

        WebElement nameElement=webDriver.findElement(By.name("username"));
        nameElement.sendKeys("");

        WebElement passwordElement=webDriver.findElement(By.name("password"));
        passwordElement.sendKeys("");

        WebElement phoneNumberElement=webDriver.findElement(By.name("phoneNumber"));
        phoneNumberElement.sendKeys("");

        WebElement createAccountButton = webDriver.findElement(By.name("createAccountButton"));
        createAccountButton.click();

        assertThat(webDriver.getCurrentUrl(),containsString("http://localhost:9130/twu/createAccount"));
    }

    @AfterClass
    public static void tearDown() {

        webDriver.close();

    }



}