package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.PolicyDetailsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PolicyIssuanceTest extends BaseTest {

    @Test
    public void policyIssuanceFlow() throws InterruptedException {

        System.out.println("Driver value: " + driver);

        LoginPage login = new LoginPage(driver);

        login.enterPhone("8086448498");
        login.generateOtpClick();
        login.enterOTP("1234");
        login.clickLogin();

        Thread.sleep(3000);

        PolicyDetailsPage PDP = new PolicyDetailsPage(driver);
        PDP.enterRegistrationNo("DL17IC1234");
        PDP.selectCarModel("CRETA");
        PDP.selectVariant("SX 1.6 PETROL");
        PDP.selectDate();
        PDP.selectRTO("GJ39");
        PDP.selectPreviousPolicyType();
        PDP.customerInfo("Utkarsh", "test@gmail.com", "8086448498");
        PDP.quotePage();
        PDP.carDetailsCheck();
        
        
        
    }

}