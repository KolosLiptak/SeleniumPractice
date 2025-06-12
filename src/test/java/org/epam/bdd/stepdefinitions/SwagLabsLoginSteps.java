package org.epam.bdd.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.epam.bdd.stepdefinitions.hooks.SwagLabsLoginHooks;
import org.epam.ui.page.SwagLabsLoginPage;

import org.epam.ui.util.Util;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SwagLabsLoginSteps {

    private static final Logger logger = LogManager.getLogger(SwagLabsLoginSteps.class);
    SwagLabsLoginPage swagLabsLoginPage;
    private final WebDriver driver = SwagLabsLoginHooks.driver;

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Util.SWAGLABS_URL);
        swagLabsLoginPage = new SwagLabsLoginPage(driver);
        logger.info("Navigated to SwagLabs login page");
    }

    @When("^I log in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_log_in_with_username_and_password(String username, String password){
        swagLabsLoginPage.enterUsername(username);
        swagLabsLoginPage.enterPassword(password);
        swagLabsLoginPage.clickLoginButton();
        logger.info("Submitted username and password");
    }

    @Then("I should see my dashboard")
    public void i_should_see_my_dashboard(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        logger.info("Successful Login");
    }

    @Then("I should see error message")
    public void i_should_see_error_message() throws InterruptedException {
        String actualErrorMessage = swagLabsLoginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,
                "Epic sadface: Username and password do not match any user in this service");
        logger.info("Error message received successfully");
    }
}
