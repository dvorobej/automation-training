package test;

import org.testng.annotations.Test;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.LOGIN_WITHOUT_DATA_ALLERT_MESSAGE;

public class UserEmptyAccessTest extends CommonCondition {
    @Test
    public void oneCantLoginWithNoInputData()
    {
        String allertMessage = new MainPage(driver)
                .openPage()
                .loginWithoutData()
                .getLoginWithoutDataErrorMessage();
        assertThat(allertMessage, is(equalTo(LOGIN_WITHOUT_DATA_ALLERT_MESSAGE)));
    }
}
