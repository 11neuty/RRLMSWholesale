package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.LMSPage;

public class Hooks {
    public static WebDriver driver;
    public static LMSPage lmsPage;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);

        String appUrl = "https://lmswhsappuat202.hq.bni.co.id/cls/";
        driver.get(appUrl);
        driver.manage().window().maximize();

        // inisialisasi PageObject
        lmsPage = new LMSPage(driver);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
