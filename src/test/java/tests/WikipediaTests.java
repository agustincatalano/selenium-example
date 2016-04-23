package tests;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.Results;

import static org.junit.Assert.assertEquals;

/**
 * Created by agustin on 21/03/2016.
 */
public class WikipediaTests {
    private HomePage homePage = new HomePage();
    private Results results = new Results();

    @Before
    public void createDriver() {
        homePage.goToPage("http://www.wikipedia.org");
    }

    @Test
    public void myFirstTest() {
        assertEquals("Wikipedia", homePage.getTitle().getAttribute("title"));
        assertEquals("https://www.wikipedia.org/", homePage.getHomePageUrl());
    }

    @Test
    public void firstResult() {
        homePage.getSearchInput().sendKeys("Argentina");
        homePage.getFindButton().click();
        assertEquals("https://en.wikipedia.org/wiki/Argentina", results.getResultsURL());
    }

    @Test
    public void clickAllLinks() {
        homePage.getSearchInput().sendKeys("Argentina");
        homePage.getFindButton().click();
        assertEquals("https://en.wikipedia.org/wiki/Argentina", results.getResultsURL());
        results.clickAllLinks();
        results.goToSelectedLink();
    }

}
