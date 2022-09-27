package findVetes.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/* Find All The Veterinarians And List Them Test Case
 * This An Example On Behavior Drive Development Using Cucumber  */
public class Steps {
	private WebDriver driver;

	@Before()
	public void steup() {
		System.setProperty("webdriver.chrome.driver", "/home/diana/Downloads/chromedriver");
		driver = new ChromeDriver();

	}

	@Given("I am in the home page")
	public void i_am_in_the_home_page() {

		driver.get("https://petclincqpros.herokuapp.com/");

	}

	@When("I press on the Veterinarians button")
	public void i_press_on_the_Veterinarians_button() {
		WebElement veterButton = driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a"));
		veterButton.click();
	}

	@Then("It should list all the Veterinarians")
	public void it_should_list_all_the_Veterinarians() {
		List<WebElement> objVetes = driver.findElements(By.id("vets"));
		for (WebElement obkCurrentLink : objVetes) {
			String stringListVet = obkCurrentLink.getText();
			System.out.println(stringListVet);
		}
	}

	@After()
	public void quiteBrowser() {
		// Close the browser
		driver.close();

	}
}
