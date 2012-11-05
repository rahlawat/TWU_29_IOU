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
    public void shouldHaveLabelForName()
    {
       WebElement nameLabel = webDriver.findElement(By.name("name_label"));
        assertThat(nameLabel.getText(),is("Name *:"));
    }
    @Test
    public void shouldHave1NameField()
    {
        List<WebElement> nameBox=webDriver.findElements(By.name("name_text"));
        assertThat(nameBox.size(), is(1));

    }
    @Test
    public void shouldHaveLabelForEmail()
    {
        WebElement emailLabel = webDriver.findElement(By.name("email_label"));
        assertThat(emailLabel.getText(),is("E-mail Address *:"));
    }
    @Test
    public void shouldHave1EmailField()
    {
        List<WebElement> emailBox=webDriver.findElements(By.name("email_text"));
        assertThat(emailBox.size(), is(1));

    }
    @Test
    public void shouldHaveLabelForPassword()
    {
        WebElement passwordLabel = webDriver.findElement(By.name("password_label"));
        assertThat(passwordLabel.getText(),is("Password *:"));
    }
    @Test
    public void shouldHave1PasswordField()
    {
        List<WebElement> passwordBox=webDriver.findElements(By.name("password_text"));
        assertThat(passwordBox.size(), is(1));

    }
    @Test
    public void shouldHaveLabelForPhoneNumber()
    {
        WebElement phoneNumberLabel = webDriver.findElement(By.name("phone_number_label"));
        assertThat(phoneNumberLabel.getText(),is("Phone Number:"));
    }
    @Test
    public void shouldHave1PhoneNumberField()
    {
        List<WebElement> passwordBox=webDriver.findElements(By.name("phone_number_text"));
        assertThat(passwordBox.size(), is(1));

    }
    @Test
    public void shouldHaveSubmitButton()
    {
        WebElement submitButton = webDriver.findElement(By.name("create_account_button"));
        assertThat(submitButton.getAttribute("value"),is("Create Account"));
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