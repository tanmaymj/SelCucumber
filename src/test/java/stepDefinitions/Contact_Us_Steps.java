package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Global_vars;

import static drivers.DriverFactory.getDriver;

public class Contact_Us_Steps {

    private WebDriver driver = getDriver();

    public Contact_Us_Steps() throws Exception {
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomAlpha(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    @Given("I access webdriver university contact us page")
    public void i_access_webdriver_university_contact_us_page() {
        driver.get(Global_vars.DEFAULT_UNIVERSITY_HOMEPAAGE + "/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[1]")).sendKeys("AutoFN" + generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[2]")).sendKeys("AutoLN" + generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[3]")).sendKeys(generateRandomAlpha(5) + generateRandomNumber(5) + "@gmail.com");
    }

    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/textarea[1]")).sendKeys(generateRandomAlpha(9));
    }

    @And("I click on submit button")
    public void i_click_on_submit_button() {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/div[1]/input[2]")).click();
    }

    @Then("I should be presented with a success message")
    public void i_should_be_presented_with_a_success_message() {
        WebElement successMsg = driver.findElement(By.xpath("//h1[contains(text(),'Thank You for your Message!')]"));
        String successText = successMsg.getText();
        Assert.assertEquals(successText, "Thank You for your Message!");
    }

    //    Scenario 2 : Validate successful submission - specific data
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
        System.out.println(firstName);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[1]")).sendKeys(firstName);

    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) {
        System.out.println(lastName);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[2]")).sendKeys(lastName);

    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_joe_blogs_gmail_com(String email) {
        System.out.println(email);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/input[3]")).sendKeys(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        System.out.println(string);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/section[1]/div[1]/div[2]/form[1]/textarea[1]")).sendKeys(string);

    }


}
