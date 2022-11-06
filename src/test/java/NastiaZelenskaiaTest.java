import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NastiaZelenskaiaTest {

    //TC_1_1  - Тест кейс:
    //1. Открыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголовок изменился на "Paris, FR"

//    @Test
//    public void testH2TagText_WhenSearchingCityCountry () throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
//        WebDriver driver = new ChromeDriver();

//       //arrange
//        String url = "https://openweathermap.org/";
//        String cityName = "Paris";
//        String expectedResult = "Paris, FR";
//
//        //act
//        driver.get(url);
//        Thread.sleep(5000);
//
//        WebElement searchCityField  = driver.findElement(
//                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
//        );
//        searchCityField.click();
//        searchCityField.sendKeys(cityName);
//
//
//        WebElement searchButton = driver.findElement(
//                By.xpath("//div[@id ='weather-widget']//button[@type = 'submit']")
//        );
//        searchButton.click();
//
//        Thread.sleep(5000);
//
//        WebElement parisFrChoiceInDropdownMenu = driver.findElement(
//                By.xpath("//ul[@class='search-dropdown-menu']//li//span[text() = 'Paris, FR ']")
//        );
//        parisFrChoiceInDropdownMenu.click();
//
//
//        WebElement h2CityCountryHeader = driver.findElement(
//                By.xpath("//div[@id='weather-widget']//h2")
//        );
//        Thread.sleep(2000);
//
//        String actualResult = h2CityCountryHeader.getText();
//
//        Assert.assertEquals(actualResult,expectedResult);
//
//       driver.quit();

//        TC_11_01
//        1.  Открыть базовую ссылку
//        2.  Нажать на пункт меню Guide
//        3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
//        и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testH2TagText_WhenClickGuide() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        //arrange
        String url = "https://openweathermap.org/";
        String refGuide = "https://openweathermap.org/guide";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        //act
        driver.get(url);
        Thread.sleep(5000);


        WebElement RefGuide1 = driver.findElement(
                By.xpath("//a[@href='/guide']"));
        RefGuide1.click();

        String refGuide2 = driver.getCurrentUrl();
        Assert.assertEquals(refGuide2, refGuide);


        WebElement titlePageGuide = driver.findElement(
                By.xpath("//head//title")
        );

        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);


    }

//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах


    @Test
    public void test_WhenChooseFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//arrange
        String url = "https://openweathermap.org/";
        String expectedResult = "F";


//act
        driver.get(url);
        Thread.sleep(5000);

        WebElement UnitsOfMeasureFields = driver.findElement(
                By.xpath("//div[@class= 'option'][2]")
        );
        UnitsOfMeasureFields.click();

        Thread.sleep(2000);

        WebElement unitsOfMeasureElement = driver.findElement(
                By.xpath("//span[@class= 'heading']")
        );

        Assert.assertTrue(unitsOfMeasureElement.getText().endsWith(expectedResult));

        driver.quit();
    }

//        TC_11_03
//        1.  Открыть базовую ссылку
//        2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site
//        to work. We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
//        You can allow all cookies or manage them individually.”
//        3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”


    @Test
    public void test_PopupCookieConsentBanner() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//arrange
        String url = "https://openweathermap.org/";
        String expectedCookieConsentBanner = "We use cookies which are essential for the site to work. "
                + "We also use non-essential cookies to help us improve our services. "
                + "Any data collected is anonymised. "
                + "You can allow all cookies or manage them individually.";
        String expectedButtonAllowAll = "Allow all";
        String expectedButtonManageCookies = "Manage cookies";


        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCookieConsentBanner = driver.findElement(
                By.xpath("//div[@class= 'stick-footer-panel__container']//p")
        );

        String actualResult = searchCookieConsentBanner.getText();
        Assert.assertEquals(actualResult, expectedCookieConsentBanner);

        WebElement searchButtonAllowAll = driver.findElement(
                By.xpath("//button[text() = 'Allow all']")
        );

        String actualResult2 = searchButtonAllowAll.getText();
        Assert.assertEquals(actualResult2, expectedButtonAllowAll);

        WebElement searchButtonManageCookies = driver.findElement(
                By.xpath("//a[@href='/cookies-settings']")
        );

        String actualResult3 = searchButtonManageCookies.getText();
        Assert.assertEquals(actualResult3, expectedButtonManageCookies);

        driver.quit();
    }

//          TC_11_04
//          1.  Открыть базовую ссылку
//          2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testTexSubMenu_WhenClickButtonSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//arrange
        String url = "https://openweathermap.org/";
        String supportDropdown = "Support";
        String expectedFAQ = "FAQ";
        String expectedHowToStart = "How to start";
        String expectedAskAQuestion = "Ask a question";

        driver.get(url);
        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebElement searchSupportDropdown = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']"));
        searchSupportDropdown.click();

        WebElement searchFAQ = driver.findElement(By.xpath("//a[@href= '/faq']"));

        String actualFAQ = searchFAQ.getText();
        Assert.assertEquals(actualFAQ, expectedFAQ);

        WebElement searchHowToStart = driver.findElement(By.xpath("//a[@href= '/appid']"));

        String actualHowToStart = searchHowToStart.getText();
        Assert.assertEquals(actualHowToStart, expectedHowToStart);

        WebElement searchAskAQuestion = driver.findElement(
                By.xpath("//a[@href= 'https://home.openweathermap.org/questions']"));

        String actualAskAQuestion = searchAskAQuestion.getText();
        Assert.assertEquals(actualAskAQuestion, expectedAskAQuestion);

        driver.quit();

    }

//            driver.quit();


//    TC_11_05
//1. Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testSubMenu_WhenClickButtonSupport() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//arrange
        String url = "https://openweathermap.org/";
        String email = "olga@gmail.com";
        String message = "Do you like rainy weather?";
        String tryAgain = "reCAPTCHA verification failed, please try again";



        driver.get(url);
        Thread.sleep(5000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement searchSupportDropdown = driver.findElement(
                By.xpath("//div[@id= 'support-dropdown']"));
        searchSupportDropdown.click();


        WebElement searchAskAQuestion = driver.findElement(
                By.xpath("//a[@href= 'https://home.openweathermap.org/questions']"));
        searchAskAQuestion.click();
        Thread.sleep(2000);


        String originalWindow = driver.getWindowHandle();
        
        Thread.sleep(5000);
        //Loop through until we find a new window handlefor (String windowHandle : driver.getWindowHandles()) {
        for (String windowHandle : driver.getWindowHandles())
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }


        WebElement searchEmailField = driver.findElement(
                        By.xpath("//input[@class= 'form-control string email required']")
                );
        searchEmailField.sendKeys(email);

        WebElement searchSubjectField = driver.findElement(
                By.xpath("//select[@id=\"question_form_subject\"]/option[7]")
        );
        searchSubjectField.click();

        Thread.sleep(2000);

        WebElement searchMessageField = driver.findElement(
                By.xpath("//textarea[@class='form-control text required']"));
        searchMessageField.click();
        searchMessageField.sendKeys(message);
        Thread.sleep(5000);

//        WebElement captchaField = (WebElement) driver.findElement(
//                By.className("rc-anchor-center-item rc-anchor-checkbox-label"));
//        captchaField.click();

        String window2 = driver.getWindowHandle();
        driver.switchTo().window(window2);

        WebElement buttonSubmit = driver.findElement(By.xpath(
                "//input[@data-disable-with='Create Question form']"));
        buttonSubmit.click();


//        String window2 = driver.getWindowHandle();
//
//        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='reCAPTCHA']")));




            }

    }

