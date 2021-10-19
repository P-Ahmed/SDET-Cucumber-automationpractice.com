import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    public WebDriver driver;
    WebDriverWait wait;
    @Given("^User visits e-commerce website$")
    public void user_visits_e_commerce_website() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @When("^User enters valid username \"([^\"]*)\" and valid password \"([^\"]*)\"$")
    public void user_enters_valid_credentials(String username, String password) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        Login login = new Login(driver);
        login.doLogin(username,password);
    }

    @Then("^User can logged in successfully$")
    public void user_can_logged_in_successfully() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        String text = driver.findElement(By.xpath("//span[contains(text(),'Test User')]")).getText();
        Assert.assertTrue(text.contains("Test User"));
    }

    @After
    public void close_browser(){
        driver.quit();
    }


}
