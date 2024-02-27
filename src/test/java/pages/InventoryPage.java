package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.WebActions;

public class InventoryPage extends WebActions {
    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='app_logo' and contains(text(),'Swag Labs')]")
    private WebElement lblTitle;

    @FindBy(how = How.XPATH, using = "//*[@class='shopping_cart_link']")
    private WebElement btnShoppingCart;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement btnCheckout;

    @FindBy(how = How.ID, using = "first-name")
    private WebElement inputFirstName;

    @FindBy(how = How.ID, using = "last-name")
    private WebElement inputLastName;

    @FindBy(how = How.ID, using = "postal-code")
    private WebElement inputZipCode;

    @FindBy(how = How.ID, using = "continue")
    private WebElement btnContinue;

    @FindBy(how = How.NAME, using = "finish")
    private WebElement btnFinish;

    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Thank you for your order!')]")
    private WebElement lblMessage;

    /**
     * Validate that the Home page title loads correctly.
     *
     * @return true if shown, false if not shown
     */
    public boolean isTitleVisible() {
        return isVisible(driver, lblTitle);
    }

    /**
     * Add an item to the shopping cart
     *
     * @param item Item to add to cart
     */
    public void addItem(String item) {
        String xpath = String.format("//*[@class='btn btn_primary btn_small btn_inventory ' and contains(@id,'%s')]", item);
        click(driver, driver.findElement(By.xpath(xpath)));
    }

    /**
     * Click on the shopping cart and start the checkout process.
     */
    public void cartOptions() {
        click(driver, btnShoppingCart);
        click(driver, btnCheckout);
    }

    /**
     * Starts and ends the checkout process
     */
    public void checkoutProcess() {
        Faker faker = new Faker();
        sendText(driver, inputFirstName, faker.name().firstName());
        sendText(driver, inputLastName, faker.name().lastName());
        sendText(driver, inputZipCode, faker.address().zipCode());
        click(driver, btnContinue);
        click(driver, btnFinish);
    }

    /**
     * Validate display of completed order message
     *
     * @return true if shown, false if not shown
     */
    public boolean isMessageVisible() {
        return isVisible(driver, lblMessage);
    }


}
