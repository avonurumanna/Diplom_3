package ui_tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import page_object.AccountProfilePage;
import page_object.LoginPage;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class LogOffTest extends BaseUISettings {

    public final String userTestLogin = "testemail456@gmail.com";
    public final String userTestPassword = "1234567";
    public final String loginHeaderText = "Вход";


    @Test
    @DisplayName("Check log off using exit button on account profile page")
    public void clickExitButtonOnAccountProfileExpectedUserLoggedOffTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        mainPage.clickAccountButton();
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        accountProfilePage.waitUnitPageLoaded(100);
        accountProfilePage.clickExitButton();
        loginPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(loginPage.getHeaderText(), containsString(loginHeaderText));
    }


}
