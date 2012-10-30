package functional.com.thoughtworks.twu;

import com.google.common.cache.CacheBuilderSpec;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LoginFunctionalTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Test
    public void shouldShowTheEmailInputBox() {
        webDriver.get("http://localhost:8080/twu/login");
       List<WebElement> emailItems =  webDriver.findElements(By.name("email"));
        assertEquals(1,emailItems.size());
    }

    @Test
    public void shouldShowThePasswordInputBox() {
        webDriver.get("http://localhost:8080/twu/login");
        List<WebElement> passwordItems =  webDriver.findElements(By.name("password"));
        assertEquals(1, passwordItems.size());
    }












    @After
    public void tearDown() {
        webDriver.close();
    }


}
