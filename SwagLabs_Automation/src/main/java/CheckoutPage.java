import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    final By checkoutButton = By.cssSelector(".checkout_button");
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipCodeField = By.id("postal-code");
    private final By continueButton = By.cssSelector(".cart_button");
    private final By finishButton = By.cssSelector(".cart_button");
    private final By completeHeader = By.className("complete-header");
    private final By itemTotal = By.className("summary_subtotal_label");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Actions
    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipCodeField).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }

    public void completePurchase() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        driver.findElement(finishButton).click();
    }

    public boolean isOrderComplete() {
        return driver.findElements(completeHeader).size() > 0;
    }

    public String getItemTotal() {
        return driver.findElement(itemTotal).getText();
    }
}