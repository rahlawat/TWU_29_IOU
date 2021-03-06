package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillFunctionalTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
        webDriver.get("http://localhost:9130/IOU/login");

        webDriver.findElement(By.id("email")).sendKeys("sajacobs@thoughtworks.com");
        webDriver.findElement(By.id("password")).sendKeys("1234");

        webDriver.findElement(By.id("loginForm")).submit();

    }

    @Test
    public void shouldRedirectToDashBoardOnBackToDashBoardClick() {
        webDriver.get("http://localhost:9130/IOU/add-bill");
        WebElement button = webDriver.findElement(By.id("backToDashboardButton"));

        button.click();

        assertThat(webDriver.getCurrentUrl(), is("http://localhost:9130/IOU/dashboard"));

    }

    @Test
    @Ignore
    public void shouldChooseFriendsAndSaveThemToDBOnSaveClick() throws Exception {
        webDriver.get("http://localhost:9130/IOU/add-bill");
        String currentUrl = webDriver.getCurrentUrl();

        assertThat(currentUrl, is("http://localhost:9130/IOU/add-bill"));

        String friendsList = webDriver.findElement(By.name("MengqiuCheckBox")).getText();

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

