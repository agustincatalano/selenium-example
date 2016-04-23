package pages;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agust on 4/13/2016.
 */
public class HomePage {
    private WebDriver driver;
    DriverFactory driverFactory;
    public static final String HOME_PAGE_URL = "http://www.wikipedia.org";

    public DriverFactory driverFactory() {
        if (driverFactory == null)
            driverFactory = new DriverFactory();
        return driverFactory;
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("searchInput"));
    }

    public String getHomePageUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement getTitle() {
        return driver.findElement(By.xpath("//body/h1[@title='Wikipedia']"));
    }

    public WebElement getFindButton() {
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }


    public void goToPage(String url) {
        if (driver == null)
            driver = driverFactory().getDriver();
        driver.get(url);
    }


}
