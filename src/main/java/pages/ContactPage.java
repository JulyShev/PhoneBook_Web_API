package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import javax.xml.xpath.XPath;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(xpath = "//button[text()='Sing Out]'")
    WebElement btnSingOut;
    @FindBy(xpath = "//*[text()='ADD']")
    WebElement btnAdd;
    @FindBy(xpath = "//h1[text()=' No Contacts here!']")
    WebElement contactPageMessage;

    public boolean isTextInContactPageMessagePresent(String text){
        return isTextInElementPresent(contactPageMessage, text);
    }
    public boolean isTextInBtnSingOutPresent(String text) {
        return isTextInElementPresent(btnSingOut, text);
    }

    public boolean isTextInBtnAddPresent(String text){
        return isTextInElementPresent(btnAdd, text);
    }
}
