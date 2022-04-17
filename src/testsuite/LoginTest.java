package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.name("user-name"));
        UserNameElement.sendKeys("standard_user");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("secret_sauce");
        //click on loging button using elements
        WebElement login = driver.findElement(By.cssSelector(".submit-button"));
        login.click();
        //this os form requirement
        String expectedLogInText = "PRODUCTS";
        //find the welcome text element and get the text
        WebElement actualLogInTextElements = driver.findElement(By.xpath("//span[@class='title']"));
        String actualLogInText = actualLogInTextElements.getText();
        System.out.println(actualLogInText);
        //Verify the text error message with assert
        Assert.assertEquals(expectedLogInText,actualLogInText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //find the element of username and send the username key
        WebElement UserNameElement = driver.findElement(By.name("user-name"));
        UserNameElement.sendKeys("standard_user");
        //find the element of password and send the password key
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("secret_sauce");
        //click on loging button using elements
        WebElement login = driver.findElement(By.cssSelector(".submit-button"));
        login.click();
        //this os form requirement
        int expectedProductList = 6;
        // Class name locator ---To find multiple elements
        List<WebElement> actualProductsListElements = driver.findElements(By.className("inventory_item_name"));
        int actualProductList = actualProductsListElements.size();;
        //Verify the text error message with assert
        Assert.assertEquals(expectedProductList,actualProductList);
    }


    @After
    public void tearDown(){
        //close the browser
        closeBrowser();
    }

}
