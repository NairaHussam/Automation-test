package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static StepDefinition.Hooks.driver;

public class Login {


    public WebElement loginLink()
    {
        return driver.findElement(By.className("ico-login"));

    }

    public WebElement emailPOM()
    {
        By email = By.id("Email");
        return driver.findElement(email);
    }

    public WebElement passwordPOM()
    {
        By password = By.id("Password");
        return driver.findElement(password);
    }
    public void LoginSteps(String email, String password)

    {

        emailPOM().sendKeys(email);


        passwordPOM().sendKeys(password);
    }

    public WebElement loginButtonPOM()
    {
        By loginButton = By.cssSelector("div > button[type=\"submit\"]");
        return driver.findElement(loginButton);
    }

    public WebElement failMessagePOM()
    {
        By failMessage = By.className("message-error");
        return driver.findElement(failMessage);
    }

    public WebElement myAccountPOM()
    {
        By myAccount = By.className("ico-account");
        return driver.findElement(myAccount);
    }



}

