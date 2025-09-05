import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class InventoryTests {
    WebDriver myBrowser;
    InventoryPage inventoryPage;
    String password = "secret_sauce";
    String url = "https://www.saucedemo.com/v1/index.html";

    @DataProvider(name = "userData")
    public Object[][] provideUserData() {
        return new Object[][] {
                {"standard_user"},
                {"performance_glitch_user"}
        };
    }

    @BeforeClass
    public void start() {
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
        myBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        inventoryPage = new InventoryPage(myBrowser);
    }

    @Test(dataProvider = "userData", priority = 1)
    public void additems(String username) {
        myBrowser.get(url);
        inventoryPage.login(username, password);

        if (inventoryPage.isLockedOut()) {
            return;
        }

        inventoryPage.waitForInventory();
        inventoryPage.addFirstItem();
        inventoryPage.goToCart();
        int itemCount = inventoryPage.getCartItemCount();
    }

    @Test(dataProvider = "userData", priority = 2)
    public void removeItem6FromCart(String username) {
        myBrowser.get(url);
        inventoryPage.login(username, password);

        if (inventoryPage.isLockedOut()) {
            return;
        }

        inventoryPage.waitForInventory();
        inventoryPage.addSixthItem();
        inventoryPage.goToCart();
        inventoryPage.removeItem();
        int itemCount = inventoryPage.getCartItemCount();
    }

    @AfterClass
    public void tearDown() {
        myBrowser.quit();
    }
}