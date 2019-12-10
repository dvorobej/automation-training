package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static util.StringUtils.SITE_RUSSIANPAGE_URL;

public class RussianPage extends AbstractPage
{
    private final By titleTickets = By.xpath("//*[@href='/flights']");

    public RussianPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
        logger.info("RussianPage class created");
    }

    @Override
    public RussianPage openPage()
    {
        driver.navigate().to(SITE_RUSSIANPAGE_URL);
        logger.info("Opening russian page");
        return this;
    }

    public String getTitleTickets()
    {
        logger.info("Get russian title");
        return waitForTheElement(titleTickets).getText();
    }
}
