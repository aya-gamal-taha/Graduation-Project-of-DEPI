import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class CheckoutTests {
    WebDriver driver;
    InventoryPage inventoryPage;
    CheckoutPage checkoutPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String url = "https://www.saucedemo.com/v1/index.html";

    @BeforeClass
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        inventoryPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void testSuccessfulCheckout() {
        // Login and add item to cart
        driver.get(url);
        inventoryPage.login(username, password);
        inventoryPage.waitForInventory();
        inventoryPage.addFirstItem();

        // Go to cart and proceed to checkout
        inventoryPage.goToCart();
        checkoutPage.proceedToCheckout();

        // Fill checkout information
        checkoutPage.fillCheckoutInformation("Tony", "Stark", "3000");

        // Verify item total is displayed
        String total = checkoutPage.getItemTotal();
        Assert.assertTrue(total.contains("Item total"), "Item total not displayed");

        // Complete purchase
        checkoutPage.completePurchase();
        Assert.assertTrue(checkoutPage.isOrderComplete(), "Order completion not confirmed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}