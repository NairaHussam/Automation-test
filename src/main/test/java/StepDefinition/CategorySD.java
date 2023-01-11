package StepDefinition;

import io.cucumber.java.en.When;
import Pages.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static StepDefinition.Hooks.driver;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
public class CategorySD {


    Category hover = new Category();

    @When("user hover over three main categories and select one random sub category")
    public void hoverMethod() throws InterruptedException {

        Actions actions = new Actions(driver);


        int count = hover.mainCategoryP().size();
        System.out.println("count is " + count);
        int selectedCategory = new Random().nextInt(3);

        actions.moveToElement(hover.mainCategoryP().get(selectedCategory)).perform();
        String selectedCategoryText = hover.mainCategoryP().get(selectedCategory).getText();
        System.out.println("to know which category is selected:  " + selectedCategoryText);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        selectedCategory = selectedCategory + 1;

        List<WebElement> subCategory = driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[" + selectedCategory + "]/ul[@class=\"sublist first-level\"]/li"));
        int subRandom = new Random().nextInt(3);
        String subCat = subCategory.get(subRandom).getText();
        subCategory.get(subRandom).click();
        System.out.println("TO know which sub category is selected:  " + subCat);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        SoftAssert soft = new SoftAssert();
        String actualCategory = hover.categoryName().getText();
        String actualSubCategory = hover.pageTitle().getText();
        soft.assertEquals(actualCategory.toLowerCase().trim().contains(selectedCategoryText.toLowerCase().trim()), true, "Category is Equal true");
        soft.assertEquals(actualSubCategory.toLowerCase().trim().contains(subCat.toLowerCase().trim()), true, "SubCategory is Equal true");
        soft.assertAll();

    }


}


