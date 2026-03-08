package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class LoginPage {

	WebDriver driver;
    WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}


	
	By phoneField = By.xpath("//input[@id='floating_outlined']");
	By generateOtp = By.xpath("//*[contains(text(),'Generate OTP')]");
	By otpBoxes = By.xpath("//div[@class='flex gap-4']//input");
	By loginButton = By.xpath("(//*[contains(text(),'Verify OTP')])[2]");

	public void enterPhone(String phone) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
		driver.findElement(phoneField).sendKeys(phone);
	}

	public void generateOtpClick() throws InterruptedException {
		driver.findElement(generateOtp).click();

	}

	public void enterOTP(String otp) throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(otpBoxes));
		
		List<WebElement> boxes = driver.findElements(otpBoxes);

		for (int i = 0; i < boxes.size(); i++) {
			boxes.get(i).sendKeys(String.valueOf(otp.charAt(i)));
		}
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}