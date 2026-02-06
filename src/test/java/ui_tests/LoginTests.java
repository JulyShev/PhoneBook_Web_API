package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {
    @Test
    public void logInPositiveTest(){
      //  System.out.println("first test");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegForm("family@mail.ru",
                "Family123!");
        loginPage.clickBtnLoginForm();
        Assert.assertTrue(new ContactPage(getDriver()).isTextInBtnAddPresent("ADD"));
    }

    @Test
    public void loginPositiveTestWithUser(){
        User user = new User("family@mail.ru",
                "Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertTrue(new ContactPage(getDriver()).isTextInBtnSingOutPresent("Sing Out"));
    }

    @Test
    public void negativeLoginTestInvalidEmail(){
        User user = new User("familymail.ru",
                "Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(),"Wrong email or password");

    }
}
