package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;

public class BillFunctionalTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("http://localhost:9130/twu/login");

        webDriver.findElement(By.id("email")).sendKeys("sajacobs@thoughtworks.com");
        webDriver.findElement(By.id("password")).sendKeys("1234");

        webDriver.findElement(By.id("loginForm")).submit();

    }

    @Test
    public void shouldRedirectToDashBoardOnBackToDashBoardClick() {
        webDriver.get("http://localhost:9130/twu/add-bill");
        WebElement link = webDriver.findElement(By.tagName("a"));
        assertThat(link.getAttribute("href"), is("http://localhost:9130/twu/dashboard"));

    }

    @Test
    public void shouldChooseFriendsAndSaveThemToDBOnSaveClick() throws Exception {
        webDriver.get("http://localhost:9130/twu/add-bill");
        String currentUrl = webDriver.getCurrentUrl();

        assertThat(currentUrl, is("http://localhost:9130/twu/add-bill"));

        String friendsList = webDriver.findElement(By.id("friendsCheckList")).getText();

        assertThat(friendsList, is("Abc@gmail.com"));

        webDriver.findElement(By.id("friendsCheckList")).click();

        webDriver.findElement(By.id("saveBill")).click();

        String savedMsg = webDriver.findElement(By.id("savedSuccessfullyMsg")).getText();

        assertThat(savedMsg, is("Saved Successfully"));

    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}

