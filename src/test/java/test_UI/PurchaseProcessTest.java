package test_UI;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.AssertionManager;
import utilities.ConfigProperties;
import utilities.ReportManager;
import utilities.enums.ItemOptions;

public class PurchaseProcessTest {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeAll
    static void setupReport() {
        ReportManager.initializeReport();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void cleanup() {
        driver.close();
        ReportManager.flushReport();
    }

    @Test
    void purchaseTest() {
        ExtentTest report = ReportManager.createTest("Test case for a purchase");
        AssertionManager assertionManager = new AssertionManager(report);
        driver.get(ConfigProperties.getProperty("FRONT.URL"));
        report.info("Page loaded correctly");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigProperties.getProperty("FRONT.USER_NAME"),
                ConfigProperties.getProperty("FRONT.PASSWORD"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertionManager.hardAssertTrue(inventoryPage.isTitleVisible());
        report.info("You have successfully logged in to the application");
        //inventoryPage.isTitleVisible();
        inventoryPage.addItem(ItemOptions.JACKET.getOptions());
        report.info("Item has been added");
        inventoryPage.addItem(ItemOptions.BIKE_LIGHT.getOptions());
        report.info("Item has been added");
        inventoryPage.cartOptions();
        report.info("Shopping cart is started");
        inventoryPage.checkoutProcess();
        report.info("The order is being completed");
        assertionManager.hardAssertTrue(inventoryPage.isMessageVisible());
    }

}
