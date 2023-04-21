package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import Utility.ReadJsonData;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ChildProtectionPlan extends TestBase {

    IntakeSetup intakeInitialization;
    int increment  = 1;

    public ChildProtectionPlan(WebDriver driver) {
        ChildProtectionPlan.driver=driver;
        //this.driver=driver;
        PageFactory.initElements(driver,this);
        intakeInitialization=new IntakeSetup(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Child Protection Plan')]")
    WebElement Child_Protection_Plan_tab;

    @FindBy(xpath = "//span[contains(text(),' Child Protection Plan Claim Intake ')]")
    WebElement Child_Protection_Plan_Claim_Intake;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement NextButton;

    @FindBy(xpath = "//span[contains(text(),' Print Confirmation ')]")
    WebElement PrintConfirmation;

    @FindBy(xpath = "//mat-toolbar-row[@class='mat-toolbar-row flex flex-row']/div[2]/button/span[1]")
    WebElement Cross_Icon;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement Policy_search;

    public void Go_to_Child_Protection_Tab() {
        Child_Protection_Plan_tab.click();
        new WaitHelper(driver).waitForElement(driver,Child_Protection_Plan_Claim_Intake,10);
    }

    public void Begin_Participant(String path) throws IOException, ParseException, InterruptedException {
        intakeInitialization.Participant_Flow(path);
    }

    public void Request_Confirmation(){
        new WaitHelper(driver).waitForElement(driver,PrintConfirmation,10);
        PrintConfirmation.click();
        Cross_Icon.click();
        new WaitHelper(driver).waitForElement(driver,Policy_search,10);
    }

}
