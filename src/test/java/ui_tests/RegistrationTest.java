package ui_tests;

import generate_user_data.User;
import generate_user_data.UserGenerator;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import page_object.LoginPage;
import page_object.RegistrationPage;
import settings.BaseUISettings;

import static org.hamcrest.CoreMatchers.containsString;

public class RegistrationTest extends BaseUISettings {

    public final String warningMessage = "Некорректный пароль";
    public final String loginHeaderText = "Вход";

    public User user;

    @Before
    public void setUp() {
        user = UserGenerator.getValidUser();
    }


    @Test
    @DisplayName("Check user registration")
    public void registerUserExpectedUserRegistered() {
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail(user.getEmail());
        registrationPage.fillName(user.getName());
        registrationPage.fillPassword(user.getPassword());
        registrationPage.clickRegistrationButton();
        loginPage.waitUnitPageLoaded(100);
        MatcherAssert.assertThat(loginPage.getHeaderText(), containsString(loginHeaderText));


    }

    @Test
    @DisplayName("Check warning message appeared if input password which contains 5 characters ")
    public void passwordContainsFiveCharactersExpectedWarningMessageAppeared() {
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillEmail("testemail456@gmail.com");
        registrationPage.fillName("test");
        registrationPage.fillPassword("12345");
        registrationPage.clickRegistrationButton();
        MatcherAssert.assertThat(registrationPage.getWarningMessage(), containsString(warningMessage));

    }


}
