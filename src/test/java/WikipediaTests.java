import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by agustin on 21/03/2016.
 */
public class WikipediaTests {
    private DriverFactory driverFactory = new DriverFactory();
    private WebDriver driver;

    @Test
    public void myFirstTest(){
        driver = driverFactory.getDriver();
        driver.get("http://www.wikipedia.org");
        driver.close();
    }

}
