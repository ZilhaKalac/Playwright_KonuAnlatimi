package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

            protected static Playwright playwright;
            protected static Browser browser;

            protected BrowserContext context;
            protected Page page;

           protected  final String BASE_URL = "https://www.saucedemo.com/";



           @BeforeTest
    public void beforeTest() {

           }

           @AfterTest
    public void afterTest(){

           }

           @BeforeMethod(alwaysRun = true)
    public void
}
