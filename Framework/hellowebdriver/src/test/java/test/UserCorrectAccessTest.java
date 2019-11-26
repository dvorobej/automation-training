package test;

import model.User;
import org.testng.annotations.Test;
import page.MainPage;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserCorrectAccessTest extends CommonCondition {
    @Test
    public void oneCanLogin()
    {
        User testUser = UserCreator.loginWithCorrectData();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .inputLogin(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
    }
}
