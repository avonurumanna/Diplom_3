package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.MainPage;

public class BaseUISettings {


    private final String url = "https://stellarburgers.nomoreparties.site/";
    private final String chromeBrowser = "Chrome";
    private final String yandexBrowser = "Yandex";
    protected WebDriver driver;
    protected MainPage mainPage;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        selectBrowser(chromeBrowser);
        mainPage = new MainPage(driver);
        driver.get(url);
        driver.manage().window().maximize();

    }

    public void selectBrowser(String browser) {
        if (browser.equals(chromeBrowser)) {
            driver = new ChromeDriver();
        } else if (browser.equals(yandexBrowser)) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandex_browser\\yandexdriver.exe");
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
