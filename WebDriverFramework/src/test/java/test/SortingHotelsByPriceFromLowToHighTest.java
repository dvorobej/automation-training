package test;

import org.testng.annotations.Test;
import page.SearchHotelsPage;

import static org.testng.AssertJUnit.assertTrue;

public class SortingHotelsByPriceFromLowToHighTest extends CommonCondition{
    @Test
    public void seeWorkOfSortingHotelsByPriceFromHighToLow()
    {
        SearchHotelsPage hotelsPage = new SearchHotelsPage(driver)
                .openPage()
                .sortHotelsByPriceFromLowToHigh();
        assertTrue(hotelsPage.getFirstLowToHighHotelPrice() <= hotelsPage.getSecondLowToHighHotelPrice());
    }
}
