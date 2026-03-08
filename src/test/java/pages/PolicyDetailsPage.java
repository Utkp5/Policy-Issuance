package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PolicyDetailsPage {

    WebDriver driver;
    WebDriverWait wait;
    
    public PolicyDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    By registrationNo = By.xpath("//*[@id='registration_no']");
    By getQuote = By.xpath("//*[@id='get_quote']");
    By Manufacturer = By.xpath("//div[@id='cc']//div[contains(text(),'HYUNDAI')]");
    
    
    
    public void enterRegistrationNo(String num) 
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationNo)).sendKeys(num);
        wait.until(ExpectedConditions.elementToBeClickable(getQuote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(Manufacturer)).click();
    }

    public void selectCarModel(String model)
    {
        By modelLocator = By.xpath("//div[text()='"+model+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(modelLocator)).click();
    }
    
    public void selectVariant(String variant)
    {
        By variantLocator = By.xpath("//div[normalize-space()='"+variant+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(variantLocator)).click();
    }

    
    public void selectDate()
    {
        Select month = new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//select[@class='react-datepicker__month-select']"))));

        month.selectByVisibleText("February");

        Select year = new Select(wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//select[@class='react-datepicker__year-select']"))));

        year.selectByVisibleText("2025");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='17']"))).click();
    }
    
  
    public void selectRTO(String rto) throws InterruptedException
    {
        driver.findElement(By.name("variant")).sendKeys("GJ");
        Thread.sleep(1000);
        By rtoLocator = By.xpath("//div[normalize-space()='"+rto+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(rtoLocator)).click();
    }
    
    public void selectPreviousPolicyType()
    {
        By noPreviousPolicy = By.xpath("//*[contains(text(),\"I don't have previous policy\")]");
        By nextBtn = By.xpath("//*[contains(text(),'Next')]");
        By chooseBtn = By.xpath("(//*[text()='Choose'])[1]");

        wait.until(ExpectedConditions.elementToBeClickable(noPreviousPolicy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(chooseBtn)).click();
    }
    
    public void customerInfo(String name, String email, String phNo)
    {
        By nameField = By.id("name");
        By emailField = By.name("email");
        By mobileField = By.name("mobile");
        By submitBtn = By.xpath("//*[text()='Submit']");

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField)).sendKeys(phNo);
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
    
    public void quotePage()
    {
    	By price = By.xpath("(//div[contains(@class,'font-bold') and contains(text(),'₹')])[2]");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(price));
    	
		String premium = driver.findElement(price).getText();

    	
    	if (premium == null) {
			
    		System.out.println("No price Found!");
		}
    	else 
    	{
    		System.out.println("Buy Now for : " + premium);
    		
    	}
    	
    	    	
    }
    
       
    public void carDetailsCheck()
    {

        // Model Name
        WebElement modelNameonQuotePage = driver.findElement(By.xpath("//*[contains(text(),'CRETA')]"));
        String modelName = modelNameonQuotePage.getText();
        Assert.assertTrue(modelName.contains("CRETA"));

        // Variant
        WebElement variantNameonQuotePage = driver.findElement(By.xpath("//*[contains(text(),'SX 1.6 PETROL')]"));
        String variantName = variantNameonQuotePage.getText();
        Assert.assertTrue(variantName.contains("SX 1.6 PETROL"));

        // RTO
        WebElement rto = driver.findElement(By.xpath("//*[contains(text(),'GJ39')]"));
        Assert.assertEquals(rto.getText(), "GJ39");

        // Ownership
        WebElement ownership = driver.findElement(By.xpath("//*[contains(text(),'Individual')]"));
        Assert.assertEquals(ownership.getText(), "Individual");

        // Registration Date
//        WebElement regDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'2025-03-17')]")));
//        System.out.println(regDate.getText());
//        Assert.assertEquals(regDate.getText(), "2025-03-17");

        // Policy Type
        WebElement policyType = driver.findElement(By.xpath("//*[contains(text(),'PACKAGE')]"));
        Assert.assertEquals(policyType.getText(), "PACKAGE");

    }
    
   
    
    
    
    
}