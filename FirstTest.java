import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class FirstTest {
    private WebDriver driver;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "caminho/para/o/chromedriver.exe"); // Especifique o caminho para o chromedriver
        driver = new ChromeDriver();
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void first() {
        driver.get("https://seubarriga.wcaquino.me/");
        driver.manage().window().setSize(new Dimension(1366, 768));
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contas"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Adicionar"))).click();
        
        driver.findElement(By.id("nome")).click();
        driver.findElement(By.id("nome")).sendKeys("Conta 2");
        driver.findElement(By.cssSelector(".btn")).click();
        
        List<WebElement> elements = driver.findElements(By.cssSelector(".alert"));
        assertTrue("Alerta não encontrado.", elements.size() > 0);
    }
}
