package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import settings.BaseSettings;

public class RegistrationPage extends BaseSettings {

    //имя
    private final By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");
    //email
    private final By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");
    //password
    private final By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");
    //button
    private final By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    private final By warningMessage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillName(String name) {
        driver.findElement(nameInput).sendKeys(name);
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

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText();
    }


}
