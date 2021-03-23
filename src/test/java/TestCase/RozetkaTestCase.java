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


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RozetkaTestCase {


    @Test
    public void secondTCase() {

        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://rozetka.com.ua/");
        driver.manage().window().maximize();


        WebElement searchElement = driver.findElement(By.xpath("//button[@id='fat-menu']"));
        searchElement.click();


        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/alkoholnie-napitki-i-produkty/c4626923/']"));
        actions.moveToElement(target).perform();


        WebElement goToBeer = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/pivo/c4626589/']"));
        goToBeer.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement yesAccept = driver.findElement(By.xpath("//a[@class='btn-link-i exponea-close']"));
        yesAccept.click();


        WebElement redirectToBeer = driver.findElement(By.xpath("//a[@title='Упаковка пива Corona Extra светлое пастеризованное 4.5% 0.33 л х 6 шт (7501064199851)']"));
        redirectToBeer.click();


        WebElement acceptBuy = driver.findElement(By.xpath("//span[@class='buy-button__label']"));
        acceptBuy.click();

            //Добавление еще двух товаров в корзину
            //Добавление работает, но сайт не успевает сделать обработку

      /*  for (int i = 0; i < 2; i++) {
            WebElement plusButton = driver.findElement(By.xpath("//button[@aria-label='Добавить ещё один товар']"));
            plusButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } */


        WebElement orderYes = (new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']"))));     //driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua//checkout/']"));
        orderYes.click();




        WebElement enterSurname = driver.findElement(By.xpath("//input[@formcontrolname='surname']"));
        enterSurname.sendKeys("Гордон");

        WebElement enterName = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
        enterName.sendKeys("Дмитро");

        WebElement enterPhone = driver.findElement(By.xpath("//input[@formcontrolname='phone']"));
        enterPhone.sendKeys("0505218042");

        WebElement deliveryAdress = driver.findElement(By.xpath("//button[@aria-label='Выбрать адрес доставки']"));
        deliveryAdress.click();

        WebElement chooseAdress = driver.findElement(By.xpath("//input[@id='searchPickupDelivery']"));
        chooseAdress.sendKeys("№5, ул. Ярослава Мудрого, 30/32");

        WebElement clickAdress = driver.findElement(By.xpath("//div[@class='autocomplete__item']"));
        clickAdress.click();


        WebElement enterPatronymic = driver.findElement(By.xpath("//input[@id='recipientPatronymic']"));
        enterPatronymic.sendKeys("Бабабоевич");

        driver.quit();
    }

}
