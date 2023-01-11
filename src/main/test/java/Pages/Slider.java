package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static StepDefinition.Hooks.driver;

public class Slider {


    public WebElement slider(){
        By slider = By.id("nivo-slider");
        return driver.findElement(slider);
    }
    public WebElement slider1Button(){
        By slider1B = By.cssSelector("a[rel=\"1\"]");
        return driver.findElement(slider1B);
    }
    public WebElement slider2Button(){
        By slider2B = By.cssSelector("a[rel=\"0\"]");
        return driver.findElement(slider2B);
    }

}
