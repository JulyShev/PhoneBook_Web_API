package ui_tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends AppManager {
    @Test
    public void logInPositiveTest(){
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

    @Test
    public void negativeLoginTestEmailWithoutDomen(){
        User user = new User("family@.ru", "Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(),"Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailWithoutCharAfterDomen(){
        User user = new User("family@mail.", "Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(),"Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailWithoutCharBeforeAt(){
        User user = new User("@mail.ru","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(),"Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailEmptyField(){
        User user = new User("","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailOnlySpaces(){
        User user = new User("   ","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailStartFromSpace(){
        User user = new User(" family@mail.ru","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailStartFromChar(){
        User user = new User("*family@mail.ru","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestEmailWithDoubleAt(){
        User user = new User("family@@mail.ru","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
    @Test
    public void negativeLoginTestEmailRussianLetters(){
        User user = new User("фэмили@mail.ru","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
    @Test
    public void negativeLoginTestEmailUpperCase(){
        User user = new User("FAMILY@MAIL.RU","Family123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordEmptyField(){
        User user = new User("family@mail.ru","");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordOnlySpaces(){
        User user = new User("family@mail.ru","        ");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
    @Test
    public void negativeLoginTestPasswordStartFromSpace(){
        User user = new User("family@mail.ru"," Qwerty!123");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordLessThenEightSym(){
        User user = new User("family@mail.ru","Qrty!12");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordMoreThenFifteenSym(){
        User user = new User("family@mail.ru","Qwerrty12233!!!9");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordWithoutReqChars(){
        User user = new User("family@mail.ru","Qwerty123");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordWithNotReqChars(){
        User user = new User("family@mail.ru","Qwerty123{");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordOnlyUppercase(){
        User user = new User("family@mail.ru","QWERT123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
    @Test
    public void negativeLoginTestPasswordOnlyLowcase(){
        User user = new User("family@mail.ru","qwerty123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
    @Test
    public void negativeLoginTestPasswordWithoutNumber(){
        User user = new User("family@mail.ru","Qwerty!@!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }

    @Test
    public void negativeLoginTestPasswordFromRussianLetters(){
        User user = new User("family@mail.ru","Йцуке123!");
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLoginRegFormWithUser(user);
        loginPage.clickBtnLoginForm();
        Assert.assertEquals(loginPage.closeAlertReturnText(), "Wrong email or password");
    }
}
