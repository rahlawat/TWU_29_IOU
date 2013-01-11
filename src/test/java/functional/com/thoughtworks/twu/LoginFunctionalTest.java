package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class LoginFunctionalTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldShowTheEmailInputBox() {
        webDriver.get("http://localhost:9130/IOU/login");
        List<WebElement> emailItems = webDriver.findElements(By.id("email"));
        assertEquals(1, emailItems.size());
    }

    @Test
    public void shouldShowThePasswordInputBox() {
        webDriver.get("http://localhost:9130/IOU/login");
        List<WebElement> passwordItems = webDriver.findElements(By.id("password"));
        assertEquals(1, passwordItems.size());
    }


    @Test
    public void shouldSendToDashBoardOnGoodCredentialsCheckerUponSubmit() {
        webDriver.get("http://localhost:9130/IOU/login");

        webDriver.findElement(By.id("email")).sendKeys("sajacobs@thoughtworks.com");
        webDriver.findElement(By.id("password")).sendKeys("1234");

        webDriver.findElement(By.id("loginForm")).submit();

       Assert.assertThat(webDriver.getCurrentUrl(),containsString("http://localhost:9130/IOU/dashboard"));

    }

    @Test
    public void shouldSendToLoginOnMissingEmail() {
        webDriver.get("http://localhost:9130/IOU/login");

        webDriver.findElement(By.id("email")).sendKeys("");
        webDriver.findElement(By.id("password")).sendKeys("password");

        webDriver.findElement(By.id("loginForm")).submit();

        assertThat(webDriver.getCurrentUrl(),containsString("http://localhost:9130/IOU/login"));


    }

    @Test
    public void shouldRedirectToLoginPageIfNotLoggedIn()
    {
        webDriver.get("http://localhost:9130/IOU/dashboard");
        String redirectedUrl = webDriver.getCurrentUrl();
        assertThat(redirectedUrl, containsString("http://localhost:9130/IOU/login"));

    }

    @Test
    public void shouldSendToLoginOnMissingPassword() {
        webDriver.get("http://localhost:9130/IOU/login");

        webDriver.findElement(By.id("email")).sendKeys("adsfsadfsadf");
        webDriver.findElement(By.id("password")).sendKeys("");

        webDriver.findElement(By.id("loginForm")).submit();

        assertThat(webDriver.getCurrentUrl(),containsString("http://localhost:9130/IOU/login"));
        webDriver.getCurrentUrl();
       WebElement label =  webDriver.findElement(By.id("errorLabel")) ;
        assertNotNull(label);
    }




    @After
    public void tearDown() {
        webDriver.close();
    }


}

