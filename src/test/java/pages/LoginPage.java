package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WebActions;

public class LoginPage extends WebActions{

    private final WebDriver driver;

    /**
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    private WebElement inputUsername;

    @FindBy(how = How.ID, using = "password")
    private WebElement inputPassword;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement btnLogin;

    /**
     * Login into application
     */
    public void login(String userName, String password) {
        sendText(driver, inputUsername, userName);
        sendText(driver, inputPassword, password);
        click(driver, btnLogin);
    }

}
