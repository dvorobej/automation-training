package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{

    protected WebDriver driver;

    protected abstract AbstractPage openPage();
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        logger.info("AbstractPage class created");
    }

    protected WebElement waitForTheElement(By elementPath)
    {
        WebElement existingElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(elementPath));
        logger.info("Wait for the presence of element");
        return existingElement;
    }

    protected WebElement waitForTheClickableElement(WebElement element)
    {
        WebElement clickableElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
        logger.info("Wait until element become clickable");
        return clickableElement;
    }

    protected WebElement waitForTheVisibleElement(WebElement element)
    {
        WebElement visibleElement = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(element));
        logger.info("Wait until element become visible");
        return visibleElement;
    }


}
