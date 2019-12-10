package test;

import org.testng.annotations.Test;
import page.MainPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static util.StringUtils.EURO_SIGN;

public class ChangeCurrencyTest extends CommonCondition{
    @Test
    public void currencyCanBeChanged()
    {
        String singOfCurrency = new MainPage(driver)
                .openPage()
                .changeCurrencyToEuro()
                .getCurrentCurrency();
        assertThat(singOfCurrency, is(equalTo(EURO_SIGN)));
    }
}
