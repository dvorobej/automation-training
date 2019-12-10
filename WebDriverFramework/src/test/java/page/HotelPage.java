package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static util.StringUtils.SITE_HOTELPAGE_URL;

public class HotelPage extends AbstractPage
{
    @FindBy(xpath ="//*[@class='Hotels-Detailsv2-HotelDetailsRoomRatesTable']/div/div[1]/div[2]/div[2]/div[1]/div[3]/div/div[1]/span[1]")
    private WebElement standartPrice;

    @FindBy(xpath = "//*[@class='Hotels-Detailsv2-HotelDetailsRoomRatesTable']/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div[1]/span[1]")
    private WebElement deluxePrice;

    private final By editRoomButton = By.xpath("//*[@class=\"col col-guests \"]/a");

    private final By addRoom = By.xpath("//*[@id=\"Pod7\"]");
    private final By searchButton = By.xpath("//*[@class=\"col col-submitBtn \"]/div");

    public HotelPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
        logger.info("HotelPage class created");
    }

    @Override
    public HotelPage openPage()
    {
        driver.navigate().to(SITE_HOTELPAGE_URL);
        logger.info("Opening hotel page");
        return this;
    }

    public HotelPage addRoomSearch()
    {
        waitForTheElement(editRoomButton).click();
        waitForTheClickableElement(waitForTheElement(addRoom)).click();
        logger.info("Adding one room");
        waitForTheElement(searchButton).click();
        logger.info("Search new room");
        return new HotelPage(driver);
    }

    public Integer getStandartRoomPrice()
    {
        logger.info("Get price for standart room");
        return Integer.parseInt(standartPrice.getText().substring(1));
    }

    public Integer getDeluxeRoomPrice()
    {
        logger.info("Get price for deluxe room");
        return Integer.parseInt(deluxePrice.getText().substring(1));
    }


}
