package test;


import org.testng.annotations.Test;
import page.MainPage;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.ZERO_ADULT_ALLERT_MESSAGE;


public class ZeroAdultSearchTest extends CommonCondition{
    @Test
    public void zeroAdultsCantFly()
    {
        String numberOfAdultsAllertMessage = new MainPage(driver)
                .openPage()
                .setMinusAdultInSearch()
                .getZeroAdultsErrorMessage();
        assertThat(numberOfAdultsAllertMessage, is(equalTo(ZERO_ADULT_ALLERT_MESSAGE)));

    }

}
