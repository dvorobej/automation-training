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



    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[4]/div[1]/div/div/div[2]/ul/div[1]/li[1]/ul/li[1]/a/span[2]")
    private WebElement priceOfHotel;

    @FindBy(xpath = "//*[@data-cur='EUR']")
    private WebElement euroCurrencySign;

    @FindBy(xpath = "//*[@data-locale='ru-RU']")
    private WebElement russianLanguage;

    private final By buttonMinusAdult = By.xpath("//*[@role='list']/div[1]/div/div[2]/div/div/div[1]/button");

    private final By buttonChangeCurrency = By.xpath("//*[@aria-label='Select your currency. Current currency: USD']");

    private final By zeroAdultErrorMessage = By.xpath("//*[@class=\"_idG _h-2 _keg _ibb _ibc _kQ0 _ihD _id7 _icW _ial _igm _iek _iir _iaj\"]");

    private final By loginErrorMessage = By.xpath("/html/body/div[37]/div/div/div/div/div[2]/div[1]/div[5]/div[2]/b");

    private final By userName = By.xpath("/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/div/div/div[2]/div/div/span");

    private final By changeCurrencyThisVisit = By.xpath("//*[@class='Common-Widgets-Button-ButtonDeprecated Common-Widgets-Button-Button  size-m visitOnly']");

    private final By listOfNewYorkFlights = By.xpath("//*[@aria-label=\"Expand New York links\"]");

    private final By buttonChangeCountry = By.xpath("//*[@aria-label='Select your country and language. Current country: United States']");

    private final By loginWithoutDataErrorMessage = By.xpath("//*[@role=\"alert\"]/div[2]");


    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
        logger.info("MainPage class created");
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(SITE_HOMEPAGE_URL);
        logger.info("Opening main page");
        return this;
    }

    public void login(User user)
    {
        titleSignIn.click();
        inputLogin.click();
        inputLogin.sendKeys(user.getUsername());
        logger.info("Input login data");
        inputPassword.click();
        inputPassword.sendKeys(user.getPassword());
        logger.info("Input password data");
        buttonSubmit.click();
        logger.info("Submit login");
    }

    public MainPage loginWithoutData()
    {
        titleSignIn.click();
        buttonSubmit.click();
        logger.info("Pressed button submit without input login data");
        return new MainPage(driver);
    }

    public MainPage changeCurrencyToEuro()
    {
        waitForTheVisibleElement(waitForTheElement(buttonChangeCurrency)).click();
        waitForTheVisibleElement(euroCurrencySign).click();
        waitForTheVisibleElement(waitForTheElement(changeCurrencyThisVisit)).click();
        logger.info("Change currency to euro");
        return new MainPage(driver);
    }

    public RussianPage changeLanguageToRussian()
    {
        waitForTheElement(buttonChangeCountry).click();
        waitForTheVisibleElement(russianLanguage).click();
        logger.info("Go to Russian page");
        return new RussianPage(driver);
    }

    public MainPage inputLogin(User user)
    {
        login(user);
        logger.info("Sign in");
        return new MainPage(driver);
    }

    public MainPage setMinusAdultInSearch()
    {
        buttonNumberOfAdults.click();
        waitForTheClickableElement(waitForTheElement(buttonMinusAdult)).click();
        logger.info("Set minus one adult in search");
        return new MainPage(driver);
    }


    public String getLoginErrorMessage()
    {
        logger.info("Get error message about incorrect login data");
        return waitForTheElement(loginErrorMessage).getText();
    }

    public String getLoginWithoutDataErrorMessage()
    {
        logger.info("Get error message about login with no data");
        return waitForTheElement(loginWithoutDataErrorMessage).getText();
    }

    public String getLoggedInUserName()
    {
        logger.info("Get username");
        return waitForTheElement(userName).getText();
    }

    public String getZeroAdultsErrorMessage()
    {
        logger.info("Get error message about zero adult search");
        return waitForTheElement(zeroAdultErrorMessage).getText();
    }

    public String getCurrentCurrency()
    {
        waitForTheClickableElement(waitForTheElement(listOfNewYorkFlights)).click();
        logger.info("Get current currency");
        return priceOfHotel.getText().substring(0,1);
    }



}
