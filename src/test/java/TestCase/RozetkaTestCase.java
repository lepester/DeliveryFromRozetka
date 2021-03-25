package TestCase;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import java.lang.reflect.InvocationHandler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RozetkaTestCase {


    @Test(invocationCount = 6)
    public void secondTCase() {

        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement searchElement = driver.findElement(By.xpath("//button[@id='fat-menu']"));
        searchElement.click();


        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/alkoholnie-napitki-i-produkty/c4626923/']"));
        actions.moveToElement(target).perform();


        WebElement goToBeer = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/pivo/c4626589/']"));
        goToBeer.click();

        WebDriverWait waitAccept = new WebDriverWait(driver, 10);
        waitAccept.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn-link-i exponea-close']")));
        WebElement yesAccept = driver.findElement(By.xpath("//a[@class='btn-link-i exponea-close']"));
        yesAccept.click();


        WebElement redirectToBeer = driver.findElement(By.xpath("//a[@title='Упаковка пива Corona Extra светлое пастеризованное 4.5% 0.33 л х 6 шт (7501064199851)']"));
        redirectToBeer.click();


        WebElement acceptBuy = driver.findElement(By.xpath("//span[@class='buy-button__label']"));
        acceptBuy.click();


        String preloaderXpath = "//div[contains(@class,'modal__preloader')]";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preloaderXpath)));

        for (int i = 0; i < 2; i++) {
            WebElement plusButton = driver.findElement(By.xpath("//button[@aria-label='Добавить ещё один товар']"));
            plusButton.click();
        }


        WebDriverWait additionalProducts = new WebDriverWait(driver, 10);
        additionalProducts.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(preloaderXpath)));

        WebElement acceptYes = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']"));
        acceptYes.click();


        WebElement enterSurname = driver.findElement(By.xpath("//input[@formcontrolname='surname']"));
        enterSurname.sendKeys("Гордон");

        WebElement enterName = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
        enterName.sendKeys("Дмитрий");

        WebElement enterPhone = driver.findElement(By.xpath("//input[@formcontrolname='phone']"));
        enterPhone.sendKeys("0505218042");

        WebElement deliveryAdress = driver.findElement(By.xpath("//button[@aria-label='Выбрать адрес доставки']"));
        deliveryAdress.click();

        WebElement chooseAdress = driver.findElement(By.xpath("//input[@id='searchPickupDelivery']"));
        chooseAdress.sendKeys("№5, ул. Ярослава Мудрого, 30/32");

        WebDriverWait waitAdress = new WebDriverWait(driver, 10);
        waitAdress.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='autocomplete__item']")));

        WebElement clickAdress = driver.findElement(By.xpath("//div[@class='autocomplete__item']"));
        clickAdress.click();


        WebElement enterPatronymic = driver.findElement(By.xpath("//input[@id='recipientPatronymic']"));
        enterPatronymic.sendKeys("Ильич");

        driver.quit();
    }

}
