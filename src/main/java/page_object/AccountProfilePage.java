package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.BaseSettings;

import java.time.Duration;

public class AccountProfilePage extends BaseSettings {
    private final By profileLink = By.xpath(".//*[text() = 'Профиль']");
    private final By nameField = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[1]/div/div/input");
    private final By emailField = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[2]/div/div/input");
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/main/div/div/div/ul/li[3]/div/div/input");
    private final By exitButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");

    private final By logoLink = By.xpath("//*[@id=\"root\"]/div/header/nav/div/a");

    private final By constructorLink = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");

    public AccountProfilePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileText() {
        return driver.findElement(profileLink).getText();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }

    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(profileLink));
    }
}
