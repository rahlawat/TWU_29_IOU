package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
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
    }

    @Test
    public void shouldRedirectToDashBoardOnSaveClick() {
        webDriver.get("http://localhost:8080/twu/add-bill");
        WebElement description = webDriver.findElement(By.name("description"));
        description.sendKeys("Dinner");

        WebElement amount = webDriver.findElement(By.name("amount"));
        amount.sendKeys("2000");
        webDriver.findElement(By.name("save")).click();
       String url =  webDriver.getCurrentUrl();
        assertThat(url, is("http://localhost:8080/twu/dashboard"));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
