package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyFriendsListFunctionalTest {

    private WebDriver webDriver;
    
    @Before
    public void setUp() {
        webDriver = new HtmlUnitDriver();
    }

    @Test
    public void shouldDirectToFriendsListPageAndAddAFriendToTheList() throws Exception {
        webDriver.get("http://localhost:9130/twu/dashboard");
        webDriver.findElement(By.name("myFriendList")).click();
        String currentUrl = webDriver.getCurrentUrl();

        assertThat(currentUrl, is("http://localhost:9130/twu/my-friends-list.ftl"));

        final String addedEmail = "abc@gmail.com";

        webDriver.findElement(By.name("E-mail")).sendKeys(addedEmail);
        webDriver.findElement(By.name("addToList")).click();

        WebElement friendsTable = webDriver.findElement(By.tagName("table"));
        String friendsAdded = friendsTable.getText();

        assertThat(friendsAdded.contains(addedEmail), is(true));

        webDriver.findElement(By.name("Save")).click();
        String emptyTable = friendsTable.getText();

        assertThat(emptyTable.isEmpty(), is(true));

    }

    @After
    public void tearDown(){
        webDriver.close();
    }
}
