package com.brainsterSetup;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SeleniumSetup {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static String email;
    private static String password;


    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    public static String NavigateToCargodomHomePage(){
        driver.get("http://138.201.81.153:9095/");
        return driver.getCurrentUrl();
    }

    private static void waitFor(int seconds) {
        try {
            Thread.sleep((long)seconds * 1000);
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void clickOn(String elementXpath){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).click();
    }
    private static void selectItem(String elementXpath, String visibleText){
        new Select(driver.findElement(By.xpath(elementXpath))).selectByVisibleText(visibleText);
    }
    private static void typeIn(String elementXpath, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).sendKeys(text);
    }
    private static String getText(String elementXpath){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))).getText();
        }


        public static String newRequest(){
        clickOn("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]");

        typeIn("//*[@id=\"newRequestForm\"]/div/div[2]/div[2]/input","Boxes with Ice Cream");

        selectItem("//*[@id=\"field_y\"]", "Комбе");

        WebElement fromAdressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[4]/div[2]/place-search-field/input"));
        fromAdressTxt.sendKeys("Croatia Poliklinika");
        waitFor(2);
        fromAdressTxt.sendKeys(Keys.ARROW_DOWN);
        fromAdressTxt.sendKeys(Keys.ENTER);

        WebElement toAdressTxt = driver.findElement(By.xpath("//*[@id=\"newRequestForm\"]/div/div[5]/div[2]/place-search-field/input"));
        toAdressTxt.sendKeys("narodni heroi123");
        waitFor(2);
        toAdressTxt.sendKeys(Keys.ARROW_DOWN);
        toAdressTxt.sendKeys(Keys.ENTER);

        clickOn("//*[@id=\"newRequestForm\"]/div/div[10]/div[1]/div[2]/select");
        waitFor(1);
        typeIn("//*[@id=\"newRequestForm\"]/div/div[10]/div[1]/div[2]/input", "5");
        clickOn("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/select");
        typeIn("//*[@id=\"newRequestForm\"]/div/div[10]/div[2]/div[2]/input", "3");
        typeIn("//*[@id=\"newRequestForm\"]/div/div[10]/div[3]/div[2]/textarea", "something");
        clickOn("//*[@id=\"combeTypeRefrigerator\"]");
        clickOn("//*[@id=\"cacheDelivery\"]");
        clickOn("//*[@id=\"newRequestForm\"]/div/div[14]/input");

        return getText("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/jhi-alert/div/div/div/div/pre");
        }

    public static String enduserLookingForTransporterRegistrationForm() {
           clickOn("/html/body/div[1]/nav/div[3]/ul/li[3]/a");
            waitFor(2);

            clickOn("/html/body/div[3]/div[1]/div/div/div[1]/button");
            selectItem("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[1]/div[2]/select", "Физичко лице");

            typeIn("//*[@id=\"firstName\"]", "Angela");

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[4]/div[2]/input", "Bozinovska");

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[1]/div[2]/input", "Address1");

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[3]/div[2]/input", "Struga");

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[5]/div[2]/input", "1000");

            clickOn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/div[1]/span");

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[7]/div[2]/country-selector/div/input[1]", "Macedonia" + Keys.ENTER);

            typeIn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[6]/div[9]/div[2]/input", "123456");
            email = "AB_" + System.currentTimeMillis() + "@yopmail.com";
            typeIn("//*[@id=\"email\"]", email);

            password = new Random().nextInt(100000)+"";
            typeIn("//*[@id=\"password\"]", password);

           typeIn("//*[@id=\"confirmPassword\"]", password);
           clickOn("//*[@id=\"acceptTerms\"]");
           clickOn("/html/body/div[3]/div[1]/div/div/div/div[2]/form/div[15]/input");
           return getText("/html/body/div[3]/div[1]/div/div/h3");
        }
        public static String endUserTransporter(){
        clickOn("/html/body/div[1]/nav/div[3]/ul/li[3]/a");
        waitFor(4);

        clickOn("/html/body/div[3]/div[1]/div/div/div[2]/button");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[1]/div[2]/input", "Angela");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[3]/div[2]/input", "Bozinovska");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[5]/div[2]/input", "Skopska pivara");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[7]/div[2]/input", "Makedonija 123");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[9]/div[2]/input", "Struga");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[11]/div[2]/input", "4000");

        clickOn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/div[1]/span");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[13]/div[2]/country-selector/div/input[1]", "Macedonia" + Keys.ENTER);

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[15]/div[2]/input", "543210");

        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[1]/div[16]/div[2]/input", "078123456");

        email = "AB_" + System.currentTimeMillis() + "@yopmail.com";
        typeIn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[2]/div[2]/input", email);

        password = new Random().nextInt(999999) + "";
        typeIn("//*[@id=\"password\"]", password);

        typeIn("//*[@id=\"confirmPassword\"]", password);

        clickOn("//*[@id=\"acceptTerms\"]");

        clickOn("/html/body/div[3]/div[1]/div/div/div[2]/form/div[10]/input");
        return getText("/html/body/div[3]/div[1]/div/div/h3");
        }

        public static String clientSupport(){
        clickOn("/html/body/div[3]/div[1]/div[1]/ul/li[8]/a/span[2]");
        typeIn("/html/body/div[3]/div[1]/div[2]/div/div[3]/div[1]/input", "What Do You Want to Be When You Grow Up?");
        typeIn("/html/body/div[3]/div[1]/div[2]/div/div[3]/div[2]/textarea", "Want to become successful automation software tester");
        waitFor(1);
        clickOn("/html/body/div[3]/div[1]/div[2]/div/div[3]/button");
        waitFor(1);
        return getText("/html/body/div[3]/div[1]/div[2]/div/div[1]/strong");
        }

    public static String logMeIn() {
        //WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]"));
      clickOn("//*[@id=\"login\"]");

      typeIn("//*[@id=\"username\"]", email);

      typeIn("//*[@id=\"password\"]", password);

      clickOn("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button");
        waitFor(2);
        return getText("/html/body/div[3]/div[1]/div[1]/div/div/h3");
    }

    public static String logMeInAsTransporter(){
        clickOn("//*[@id=\"login\"]/span[2]");

        typeIn("//*[@id=\"username\"]", email);

        typeIn("//*[@id=\"password\"]", password);

        clickOn("/html/body/div[1]/div/div/div[2]/div/div[2]/form/button");
        waitFor(2);
        return getText("/html/body/div[3]/div[1]/div[2]/request-search-list/h2");
    }

    public static String findRequest() {
      //  clickOn("/html/body/div[3]/div[1]/div[1]/ul/li[1]/a/span[2]");

        clickOn("/html/body/div[3]/div[1]/div[2]/request-search-list/div[2]/request-list/div[2]/div[2]/table/tbody/tr[1]/td[1]/a");

        clickOn("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/button");
        selectItem("/html/body/div[3]/div[1]/div[2]/form/div/div[1]/select", "MKD");

        typeIn("/html/body/div[3]/div[1]/div[2]/form/div/div[2]/div[2]/table/tbody/tr/td[5]/input", "1");

        typeIn("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[1]/input", "08.04.2021 13:00");

        typeIn("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[2]/input", "10.05.2021 14:00");

        typeIn("/html/body/div[3]/div[1]/div[2]/form/div/div[4]/div/div[1]/div[3]/input", "09.05.2021 00:00");

        clickOn("/html/body/div[3]/div[1]/div[2]/form/div/div[5]/button");
        waitFor(2);

        clickOn("/html/body/div[1]/div/div/div[3]/button[1]");

        return getText("/html/body/div[3]/div[1]/div[2]/div[1]/div[6]/div[1]/div/h2");
    }

    public static WebElement ScrollToTop(String path){
        WebElement element = driver.findElement(By.xpath(path));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        waitFor(2);
        return element;
    }

    public static String navigateToMyOffers(){
        WebElement element = ScrollToTop("/html/body/div[3]/div[1]/div[1]/ul/li[3]/a/span[2]");
        element.click();
        clickOn("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/request-list/div[2]/div[2]/table/tbody/tr/td[1]/a");

        clickOn("/html/body/div[3]/div[1]/div[2]/div[1]/div[5]/div/div[2]/div/button[2]");
        waitFor(1);
        clickOn("/html/body/div[1]/div/div/form/div[3]/button[2]");
        waitFor(2);
        return getText("/html/body/div[3]/div[1]/div[2]/div/request-list-pagination/jhi-alert/div/div/div/div/pre");
    }

    public static String logMeOut() throws InterruptedException {
        WebElement logOutBtn = driver.findElement(By.xpath("//*[@id=\"logout2\"]/span"));
        logOutBtn.click();
        Thread.sleep(5000);
        return driver.getCurrentUrl();
    }
    public static void end() {driver.quit();}
}
