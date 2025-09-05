import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By inventoryList = By.className("inventory_list");
    private final By addToCartButton = By.xpath("(//button[text()='ADD TO CART'])[1]");
    private final By addToCartButton6 = By.xpath("(//button[text()='ADD TO CART'])[6]");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By cartItems = By.className("cart_item");
    private final By removeButton = By.xpath("//button[text()='REMOVE']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Actions
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLockedOut() {
        return driver.findElements(errorMessage).size() > 0;
    }

    public void waitForInventory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryList));
    }

    public void addFirstItem() {
        driver.findElement(addToCartButton).click();
    }

    public void addSixthItem() {
        driver.findElement(addToCartButton6).click();
    }

    public void goToCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public int getCartItemCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }

    public void addItemToCart() {
    }

    public void addItemToCart(int i) {
    }
}