package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class AppManager {
    private WebDriver driver;
    public WebDriver getDriver(){ // getter для того чтобы использовать driver в классах который наследуют AppManager
        return driver;
    }
    @BeforeMethod
    public void setUp(){ //What we do before @Test. Here we are writing settings to our test.
                         // (initialisation of browser, open window to max etc)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    // (@BeforeMethod) setup --> (@Test) testName --> (@AfterMethod) tearDown

    @AfterMethod (enabled = true)
    public void tearDown(){ //What we do after tests?
        if(driver != null){
            driver.quit(); // close the window of Chrome.
        }
    }
}
