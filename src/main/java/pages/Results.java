package pages;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agust on 4/14/2016.
 */
public class Results {

    private WebElement getLinks() {
        return driver.findElement(By.xpath("//div[@id='p-interaction']//div[@class='body']//ul//li//a"));
    }


    private WebDriver driver = new DriverFactory().getDriver();

    public String getResultsURL() {
        return driver.getCurrentUrl();
    }

    public void clickAllLinks() {
        final String locator = "//div[@id='p-interaction']//div[@class='body']//ul//li//a";
        List<WebElement> listaLinks = driver.findElements(By.xpath(locator));
        int size = listaLinks.size();
        for (int i = 0; i < size; i++) {
            //This is a trick to avoid StateElementReferenceException because later we navigate out and back to the
            // same page and the references to the elements to the list are updated.
            WebElement thisElement = driver.findElements(By.xpath(locator)).get(i);
            thisElement.click();
            driver.navigate().back();

        }
    }

    public void goToSelectedLink() {
        //this method is the same that above, but is faster because navigates to the url instead of click in the link.
        final String locator = "//div[@id='p-interaction']//div[@class='body']//ul//li//a";
        List<WebElement> listaLinks = driver.findElements(By.xpath(locator));
        List<String> linksRef = new ArrayList<String>();
        for (WebElement link : listaLinks) {
            linksRef.add(link.getAttribute("href"));
        }
        for (String link : linksRef) {
            driver.get(link);
            driver.navigate().back();
        }

    }


}
