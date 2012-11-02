package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillFunctionalTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldRedirectToDashBoardOnSaveClick() {
        webDriver.get("http://localhost:9130/twu/add-bill");
        WebElement description = webDriver.findElement(By.name("descriptionItem"));
        description.sendKeys("Dinner");

        WebElement amount = webDriver.findElement(By.name("amountItem"));
        amount.sendKeys("2000");
        webDriver.findElement(By.name("backToDashboard")).click();
       String url =  webDriver.getCurrentUrl();
        assertThat(url, is("http://localhost:9130/twu/dashboard"));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
