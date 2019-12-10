//package test;
//
//import org.testng.annotations.Test;
//import page.HotelPage;
//
//import static org.testng.AssertJUnit.assertTrue;
//
//public class oneAndTwoRoomsPriceDifferenceTest extends CommonCondition{
//    @Test
//    public void seeOneRoomPriceIsNotHigherThanTwo()
//    {
//        HotelPage hotelPage = new HotelPage(driver)
//                .openPage();
//        Integer oneRoomPrice = hotelPage.getStandartRoomPrice();
//        Integer twoRoomPrice = hotelPage
//                .addRoomSearch()
//                .getStandartRoomPrice();
//        assertTrue(oneRoomPrice <= twoRoomPrice);
//
//    }
//}
