import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class SearchDemo extends WebPageDriver{

    public SearchDemo (WebDriver driver){
        this.driver = driver;
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void userEnterKeywords(String searchKeywords,String textBoxId)
    {
        driver.findElement(By.id(textBoxId)).sendKeys(searchKeywords);
    }

    public static void clickOnSearchButton(String searchButtonId) {
        driver.findElement(By.id(searchButtonId)).click();
    }

    public static void userShouldSee(String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        if (!expectedResult.contains("remain")) {
            wait.until(ExpectedConditions.titleContains("_百度搜索"));
            searchResultPageVerify(driver.getPageSource(), expectedResult);
        } else {
            wait.until(ExpectedConditions.titleIs("百度一下，你就知道"));
            searchResultPageVerify(driver.getPageSource(), driver.getTitle());
        }
       // driver.close();
    }

    private static void searchResultPageVerify(String pageSource, String expectedKeywords) {
        assertTrue("testing pass", pageSource.contains(expectedKeywords));
    }
}
