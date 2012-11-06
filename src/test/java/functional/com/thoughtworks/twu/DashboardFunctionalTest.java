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

public class DashboardFunctionalTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldRedirectToBillPageOnAddBillClick() {
        webDriver.get("http://localhost:9130/twu/dashboard");
        WebElement link = webDriver.findElement(By.tagName("a"));
        assertThat(link.getAttribute("href"),is("http://localhost:9130/twu/add-bill"));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
