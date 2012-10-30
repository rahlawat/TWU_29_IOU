package functional.com.thoughtworks.twu;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreateAccountFunctionalTest {

    private static WebDriver webDriver;

    @BeforeClass
    public static void setUp()
    {
        webDriver=new FirefoxDriver();
        webDriver.get("localhost:8080/twu/createAccount");

    }

    @Test
    public void shouldHave4TextBoxes()
    {
        List<WebElement> textBoxes=webDriver.findElements(By.xpath("//input[@type='text']"));
        assertThat(textBoxes.size(), is(3));

    }

    @Test
    public void shouldHave1PasswordFiels()
    {
        List<WebElement> passwordBox=webDriver.findElements(By.xpath("//input[@type='password']"));
        assertThat(passwordBox.size(), is(1));

    }
    @Test
    public void shouldHaveLabelForName()
    {
       WebElement nameLabel = webDriver.findElement(By.id("name_label"));
        assertThat(nameLabel.getText(),is("Name *:"));
    }

    @Test
    public void shouldHaveLabelForEmail()
    {
        WebElement emailLabel = webDriver.findElement(By.id("email_label"));
        assertThat(emailLabel.getText(),is("E-mail Address *:"));
    }

    @Test
    public void shouldHaveLabelForPassword()
    {
        WebElement passwordLabel = webDriver.findElement(By.id("password_label"));
        assertThat(passwordLabel.getText(),is("Password *:"));
    }
    @Test
    public void shouldHaveLabelForPhoneNumber()
    {
        WebElement phoneNumberLabel = webDriver.findElement(By.id("phone_number_label"));
        assertThat(phoneNumberLabel.getText(),is("Phone Number:"));
    }

    @Test
    public void shouldHaveSubmitButton()
    {
        WebElement submitButton = webDriver.findElement(By.xpath("//input[@type='submit']"));
        assertThat(submitButton.getAttribute("value"),is("Create Account"));
    }

    @Test
    public void shouldSubmit()
    {
        WebElement submitButton = webDriver.findElement(By.xpath("//input[@type='submit']"));
        WebElement nameElement=webDriver.findElement(By.id("name_text"));
        nameElement.sendKeys("Yue");
        WebElement emailElement=webDriver.findElement(By.id("email_text"));
        emailElement.sendKeys("Yue@gmail.com");
        WebElement passwordElement=webDriver.findElement(By.id("password_text"));
        passwordElement.sendKeys("Yue");
        WebElement phoneNumberElement=webDriver.findElement(By.id("phone_number_text"));
        phoneNumberElement.sendKeys("1111");




        submitButton.submit();

        assertThat(webDriver.getCurrentUrl(),is("http://localhost:8080/twu/dashboard"));
    }

    @AfterClass
    public static void tearDown()
    {

        webDriver.close();

    }



}
