package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Global_vars;

import static drivers.DriverFactory.getDriver;


public class Login_steps {

    private WebDriver driver = getDriver();

    public Login_steps() throws Exception {
    }

    @Given("I am on the login portal")
    public void i_am_on_the_login_portal() {
        driver.get(Global_vars.DEFAULT_UNIVERSITY_HOMEPAAGE + "/Login-Portal/index.html?");
    }

    @When("I enter a username {word}")
    public void i_enter_a_username_hello(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password_hello123(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("click on Login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }

    @Then("I should be presented with login validation message {}")
    public void iShouldBePresentedWithLoginValidationMessageValidationMessage(String validationmessage) {
        String loginValidationMessageActual = driver.switchTo().alert().getText();
        Assert.assertEquals(loginValidationMessageActual, validationmessage);
    }

}
