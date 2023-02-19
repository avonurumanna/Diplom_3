package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.BaseSettings;

import java.time.Duration;

public class LoginPage extends BaseSettings {

    //заголовок
    private final By header = By.xpath(".//*[text() = 'Вход']");


    //email
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //password
    private final By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //login
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");
    //registration
    private final By registrationLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[1]/a");
    //forgot password
    private final By forgotPasswordLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p[2]/a");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void waitUnitPageLoaded(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.visibilityOfElementLocated(header));
    }


}
