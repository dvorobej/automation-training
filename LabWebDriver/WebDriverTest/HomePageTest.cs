using System;
using LabWebDriver;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;

namespace WebDriverTest
{
    [TestClass]
    public class HomePageTest
    {
        public const string EMAIL = "example@gmail.com";
        public const string PASSWORD = "example12345678";

        public IWebDriver Driver { get; set; }
        public WebDriverWait Wait { get; set; }


        [TestInitialize]
        public void SetupTest()
        {
            this.Driver = new ChromeDriver();
            this.Driver.Manage().Window.Maximize();
            this.Wait = new WebDriverWait(this.Driver, TimeSpan.FromSeconds(30));

        }

        [TestCleanup]
        public void TeardownTest()
        {
            this.Driver.Quit();
        }

        [TestMethod]
        public void SignInTest()
        {
            HomePage homePage = new HomePage(this.Driver);
            homePage.goToPage();
            homePage.SignIn();
            homePage.EntryEmail(EMAIL);
            homePage.EntryPassword(PASSWORD);
        }

      [TestMethod]
        public void Search()
        {
            HomePage homePage = new HomePage(this.Driver);
            homePage.goToPage();
            homePage.ChooseLanguage();
        }
    }
}
