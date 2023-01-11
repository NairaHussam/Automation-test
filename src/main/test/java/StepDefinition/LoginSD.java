package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.asserts.SoftAssert;

import org.junit.Test;

import Pages.Login;


import static StepDefinition.Hooks.driver;
public class LoginSD {

    Login login = new Login();

    @Given("user go to login page")
    public void loginPage(){login.loginLink().click();}

    @When("user login with {string} and {string}")
    public void loginData(String email, String password){
        login.LoginSteps( email, password);
    }

    @Then("user press on login button")
    public void loginButton(){ login.loginButtonPOM().click();}

    @And("user login to the system successfully")
    public void loginSuccess() {
        SoftAssert soft = new SoftAssert();

        String actualUrl = driver.getCurrentUrl();
        String expectedResult = "https://demo.nopcommerce.com/";
        soft.assertEquals(actualUrl,expectedResult);
        System.out.println("The web page is : "+ actualUrl);

        soft.assertTrue(login.myAccountPOM().isDisplayed(),"Second Assertion True");

        soft.assertAll();
    }

    @And("user could not login to the system")
    public void loginNotSuccess(){
        SoftAssert soft = new SoftAssert();
        String actualResult = login.failMessagePOM().getText();
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
        soft.assertTrue(actualResult.contains(expectedResult));
        System.out.println("The error message :" + actualResult);

        String actualColor = login.failMessagePOM().getCssValue("color");
        String expectedColor = "rgba(228, 67, 75, 1)";

        soft.assertTrue(actualColor.contains(expectedColor));
        System.out.println("The color of this message is red " + actualColor);

        soft.assertAll();
    }


}
