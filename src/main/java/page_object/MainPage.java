package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.BaseSettings;

import java.time.Duration;

public class MainPage extends BaseSettings {

    //login
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");
    private final By accountButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a");
    private final By bunSectionButton = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[1]");
    private final By sauceSectionButton = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[2]");
    private final By fillingSectionButton = By.xpath("/html/body/div[1]/div/main/section[1]/div[1]/div[3]");
    private final By burgerConstructorHeader = By.xpath(".//*[text() = 'Соберите бургер']");


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getTextLoginButton() {
        return driver.findElement(loginButton).getText();
    }

    public String getTextHeader() {
        return driver.findElement(burgerConstructorHeader).getText();
    }

    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    public void clickBunSectionButton() {
        driver.findElement(bunSectionButton).click();
    }

    public void clickSauceSectionButton() {
        driver.findElement(sauceSectionButton).click();
    }

    public void clickFillingSectionButton() {
        driver.findElement(fillingSectionButton).click();
    }

    public String getBunSectionClass() {
        WebElement element = driver.findElement(bunSectionButton);
        return element.getAttribute("class");
    }

    public String getSauceSectionClass() {
        WebElement element = driver.findElement(sauceSectionButton);
        return element.getAttribute("class");
    }

    public String getFillingSectionClass() {
        WebElement element = driver.findElement(fillingSectionButton);
        return element.getAttribute("class");
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(burgerConstructorHeader));
    }

}
