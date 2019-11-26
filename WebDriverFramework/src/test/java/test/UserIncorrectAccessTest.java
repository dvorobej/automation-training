package test;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.LOGIN_ALLERT_MESSAGE;

public class UserIncorrectAccessTest extends CommonCondition {
    @Test
    public void oneCantLogin()
    {
        User testUser = UserCreator.loginWithIncorrectData();
        String allertMessage = new MainPage(driver)
                .openPage()
                .inputLogin(testUser)
                .getLoginErrorMessage();
        assertThat(allertMessage, is(equalTo(LOGIN_ALLERT_MESSAGE)));

    }
}
