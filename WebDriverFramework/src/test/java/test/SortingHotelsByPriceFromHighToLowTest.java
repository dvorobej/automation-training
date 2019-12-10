package test;

import org.testng.annotations.Test;
import page.SearchHotelsPage;

import static org.testng.AssertJUnit.assertTrue;

public class SortingHotelsByPriceFromHighToLowTest extends CommonCondition{
    @Test
    public void seeWorkOfSortingHotelsByPriceFromHighToLow()
    {
        SearchHotelsPage hotelsPage = new SearchHotelsPage(driver)
                .openPage()
                .sortHotelsByPriceFromHighToLow();
        assertTrue(hotelsPage.getFirstHighToLowHotelPrice() >= hotelsPage.getSecondHighToLowHotelPrice());

    }
}
