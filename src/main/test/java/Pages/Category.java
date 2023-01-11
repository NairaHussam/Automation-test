package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;



import static StepDefinition.Hooks.driver;
;

public class Category{




    public List<WebElement> mainCategoryP() {

        List<WebElement> main = driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
        return main;
    }

    public WebElement pageTitle(){
        By title = By.cssSelector("div[class=\"page-title\"]");
        return driver.findElement(title);
    }
    public WebElement categoryName(){
        By name = By.cssSelector("[itemprop=\"itemListElement\"]");
        WebElement categoryNameEle = driver.findElement(name);
        return categoryNameEle;
    }


}

