using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LabWebDriver
{
    public class HomePage
    {
        private IWebDriver driver;

        [FindsBy(How = How.XPath, Using = "/html/body/div[1]/div[1]/header/div/div/div/div[3]/div/div[1]/button")]
        public IWebElement TitleSignIn { get; set; }
           
        [FindsBy(How = How.Name, Using = "username")]
        public IWebElement Email { get; set; }

        [FindsBy(How = How.Name, Using = "passwd")]
        public IWebElement Password { get; set; }

        [FindsBy(How = How.CssSelector, Using = "button.submit[aria-label='Sign in']")]
        public IWebElement ButtonSignIn { get; set; }

        [FindsBy(How = How.XPath, Using = "//*[@aria-label='Select your country and language. Current country: United States']")]
        public IWebElement Language { get; set; }
       
        [FindsBy(How = How.XPath, Using = "//*[@data-locale='ru-RU']")]
        public IWebElement TitleLanguage { get; set; }

        public HomePage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(driver, this);
        }

        public void goToPage()
        {
            driver.Navigate().GoToUrl("https://www.kayak.com/flights");
        }

        public void SignIn()
        {
            TitleSignIn.Click();
        }

        public void EntryEmail(string textToType)
        {
            Email.Click();
            Email.SendKeys(textToType);
        }

        public void EntryPassword(string textToType)
        {
            Password.Click();
            Password.SendKeys(textToType);
            ButtonSignIn.Click();
        }

        public void ChooseLanguage()
        {
            Language.Click();
            TitleLanguage.Click();
            
        }


    }
}
