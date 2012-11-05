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

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;

public class LoginFunctionalTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldShowTheEmailInputBox() {
        webDriver.get("http://localhost:9130/twu/login");
        List<WebElement> emailItems = webDriver.findElements(By.name("email"));
        assertEquals(1, emailItems.size());
    }

    @Test
    public void shouldShowThePasswordInputBox() {
        webDriver.get("http://localhost:9130/twu/login");
        List<WebElement> passwordItems = webDriver.findElements(By.name("password"));
        assertEquals(1, passwordItems.size());
    }


    @Test
    public void shouldSendToDashBoardOnGoodCredentialsCheckerUponSubmit() {
        webDriver.get("http://localhost:9130/twu/login");

        webDriver.findElement(By.name("email")).sendKeys("sajacobs@thoughtworks.com");
        webDriver.findElement(By.name("password")).sendKeys("1234");

        webDriver.findElement(By.id("loginForm")).submit();

       assertTrue(webDriver.getCurrentUrl().contains("http://localhost:9130/twu/dashboard"));

    }

    @Test
    public void shouldSendToLoginOnMissingEmail() {
        webDriver.get("http://localhost:9130/twu/login");

        webDriver.findElement(By.name("email")).sendKeys("");
        webDriver.findElement(By.name("password")).sendKeys("password");

        webDriver.findElement(By.id("loginForm")).submit();

        assertThat(webDriver.getCurrentUrl(), is("http://localhost:9130/twu/login"));


    }

    @Test
    public void shouldSendToLoginOnMissingPassword() {
        webDriver.get("http://localhost:9130/twu/login");

        webDriver.findElement(By.name("email")).sendKeys("adsfsadfsadf");
        webDriver.findElement(By.name("password")).sendKeys("");

        webDriver.findElement(By.id("loginForm")).submit();

        assertThat(webDriver.getCurrentUrl(), is("http://localhost:9130/twu/login"));


    }


    @After
    public void tearDown() {
        webDriver.close();
    }


}

