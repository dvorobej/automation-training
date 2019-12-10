package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static util.StringUtils.SITE_HOMEPAGE_URL;


public class MainPage extends AbstractPage
{

    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/button")
    private WebElement titleSignIn;

    @FindBy(name = "username")
    private WebElement inputLogin;

    @FindBy(name = "passwd")
    private WebElement inputPassword;

    @FindBy(css = "button.submit[aria-label='Sign in']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div/section[2]/div/div/div[1]/div[2]/div/button")
    private WebElement buttonNumberOfAdults;

    @FindBy(id = "ieZZ")
    private WebElement buttonMinusAdult;

    private final By zeroAdultErrorMessage = By.id("djRz-travelersAboveForm-errorMessageText");

    private final By loginErrorMessage = By.xpath("/html/body/div[37]/div/div/div/div/div[2]/div[1]/div[5]/div[2]/b");

    private final By userName = By.xpath(""/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/span"");

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(SITE_HOMEPAGE_URL);
        return this;
    }

    public void login(User user)
    {
        titleSignIn.click();
        inputLogin.click();
        inputLogin.sendKeys(user.getUsername());
        inputPassword.click();
        inputPassword.sendKeys(user.getPassword());
        buttonSubmit.click();
    }

    public MainPage inputLogin(User user)
    {
        login(user);
        return new MainPage(driver);
    }

    public MainPage setMinusAdultInSearch()
    {
        buttonNumberOfAdults.click();
        buttonMinusAdult.click();
        return new MainPage(driver);
    }


    public String getLoginErrorMessage()
    {
        WebElement linkLoginErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(loginErrorMessage));
        return linkLoginErrorMessage.getText();
    }

    public String getLoggedInUserName()
    {
        WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(userName));
        return linkLoggedInUser.getText();
    }

    public String getZeroAdultsErrorMessage()
    {
        WebElement linkZeroAdultsErrorMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(zeroAdultErrorMessage));
        return linkZeroAdultsErrorMessage.getText();
    }





}
