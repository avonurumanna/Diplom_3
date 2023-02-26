package ui_tests;

import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import page_object.ForgotPasswordPage;
import page_object.LoginPage;
import page_object.RegistrationPage;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class LoginTest extends BaseUISettings {

    public final String createOrderButtonText = "Оформить заказ";
    public final String userTestLogin = "testemail456@gmail.com";
    public final String userTestPassword = "1234567";

    @Test
    @DisplayName("Check login using Account Profile button")
    public void checkLoginUsingAccountProfileButtonExpectedUserLoggedTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check login using button on registration page")
    public void checkLoginUsingButtonOnRegistrationPageExpectedUserLoggedTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginButton();
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }

    @Test
    @DisplayName("Check login using button on forgot password page")
    public void checkLoginUsingButtonOnForgotPasswordPageExpectedUserLoggedTest() {
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLink();
        loginPage.fillEmail(userTestLogin);
        loginPage.fillPassword(userTestPassword);
        loginPage.clickLoginButton();
        mainPage.waitUnitPageLoaded(8);
        MatcherAssert.assertThat(mainPage.getTextCreateOrderButton(), containsString(createOrderButtonText));
    }


}
