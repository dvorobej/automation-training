package test;

import org.testng.annotations.Test;
import page.MainPage;
import page.RussianPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.RUSSIAN_TITLE;

public class ChangeLanguageTest extends CommonCondition{
    @Test
    public void chooseRussianLanguage()
    {
        String russianTitle = new MainPage(driver)
                .openPage()
                .changeLanguageToRussian()
                .getTitleTickets();
        assertThat(russianTitle, is(equalTo(RUSSIAN_TITLE)));
        System.out.println(russianTitle);

    }
}
