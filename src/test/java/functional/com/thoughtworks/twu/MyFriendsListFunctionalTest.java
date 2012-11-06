package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MyFriendsListFunctionalTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldDirectToFriendsListPageFromDashboard() throws Exception {
        webDriver.get("http://localhost:9130/twu/dashboard");
        webDriver.findElement(By.id("friendsListButton")).click();
        List<WebElement> elements = webDriver.findElements(By.id("title"));


       // String currentUrl = webDriver.getCurrentUrl();

       // assertThat(currentUrl, is("http://localhost:9130/twu/my-friends-list"));
       assertTrue(elements.size()==1);


    }

    @After
    public void tearDown(){
        webDriver.close();
    }
}
