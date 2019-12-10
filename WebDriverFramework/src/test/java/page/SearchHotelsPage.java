package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static util.StringUtils.SITE_SEARCHHOTELSPAGE_URL;

public class SearchHotelsPage extends AbstractPage {



    private final By displaySortingListButton = By.xpath("//*[@class="sortBy Link chevrons _iaf _ix7 _mou _h-Y _imx"]");
    private final By sortByPriceHighToLowButton = By.xpath("//*[@aria-label=\"Price (high to low)\"]");
    private final By sortByPriceLowToHighButton = By.xpath("//*[@aria-label=\"Price (low to high)\"]");
    private final By firstHighPrice = By.xpath("//*[@id=\"4303920-booking-price\"]");
    private final By secondHighPrice = By.xpath("//*[@id=\"5657877-booking-price\"]");
    private final By firstLowPrice = By.xpath("//*[@id=\"174770-booking-price\"]");
    private final By secondLowPrice = By.xpath("//*[@id=\"5845452-booking-price\"]");


    public SearchHotelsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
        logger.info("SearchHotelsPage class created");
    }

    @Override
    public SearchHotelsPage openPage()
    {
        driver.navigate().to(SITE_SEARCHHOTELSPAGE_URL);
        logger.info("Opening search hotels page");
        return this;
    }

    public SearchHotelsPage sortHotelsByPriceFromHighToLow()
    {
        waitForTheElement(displaySortingListButton).click();
        waitForTheElement(sortByPriceHighToLowButton).click();
        logger.info("Sort hotels by price from high to low");
        return new SearchHotelsPage(driver);
    }

    public SearchHotelsPage sortHotelsByPriceFromLowToHigh()
    {
        waitForTheElement(displaySortingListButton).click();
        waitForTheElement(sortByPriceLowToHighButton).click();
        logger.info("Sort hotels by price from low to high");
        return new SearchHotelsPage(driver);
    }

    public Integer getFirstHighToLowHotelPrice()
    {
        logger.info("Get first price after high to low sorting");
        return Integer.parseInt(waitForTheElement(firstHighPrice).getText().substring(1));
    }
    public Integer getSecondHighToLowHotelPrice()
    {
        logger.info("Get second price after high to low sorting");
        return Integer.parseInt(waitForTheElement(secondHighPrice).getText().substring(1));
    }
    public Integer getFirstLowToHighHotelPrice()
    {
        logger.info("Get first price after low to high sorting");
        return Integer.parseInt(waitForTheElement(firstLowPrice).getText().substring(1));
    }
    public Integer getSecondLowToHighHotelPrice()
    {
        logger.info("Get second price after low to high sorting");
        return Integer.parseInt(waitForTheElement(secondLowPrice).getText().substring(1));
    }
}
