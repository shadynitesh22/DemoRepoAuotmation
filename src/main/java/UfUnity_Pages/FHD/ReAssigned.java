package UfUnity_Pages.FHD;

import BaseClass.TestBase;
import Intake_Setup.IntakeSetup;
import Utility.ReadJsonData;
import helper.Pages.Calendar;
import helper.Pages.DropDown;
import helper.Verification.WaitHelper;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ReAssigned extends TestBase {
    int increment = 1;
    IntakeSetup intakeSetup;

    public ReAssigned(WebDriver driver) {
        ReAssigned.driver=driver;
        PageFactory.initElements(driver,this);
        intakeSetup=new IntakeSetup(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'As Reassigned')]")
    public WebElement As_Reassigned_Tab;

    @FindBy(xpath = "//span[contains(text(),' Start Reassigned Claim ')]")
    WebElement Start_Re_Assigned_Claim;

    @FindBy(xpath = "//input[starts-with(@id,'mat-input')]")
    WebElement Input_Data;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement NextButton;

    public void Go_To_As_Re_Assigned_Tab() throws IOException, ParseException, InterruptedException {
        As_Reassigned_Tab.click();
        new WaitHelper(driver).waitForElement(driver,Start_Re_Assigned_Claim,10);
        Start_Re_Assigned_Claim.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Enter_Date_Birth() throws IOException, ParseException {
        String year=new ReadJsonData().ReadJSONData("Date_of_Birth_Year");
        String month=new ReadJsonData().ReadJSONData("Date_of_Birth_Month");
        String data=new ReadJsonData().ReadJSONData("Day");
        new Calendar(driver).PickDateFromCalender(year,month,data);
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);

    }

    public void Insured_Policy_Number(){
        Input_Data.clear();
        Input_Data.sendKeys("212121");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }
    public void Insured_First_Name() throws InterruptedException {
        Input_Data.sendKeys("Mathew ");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Insured_Middle_Name() throws InterruptedException {
        Input_Data.sendKeys("7878");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }
    public void Last_Initial() throws InterruptedException {
        Input_Data.sendKeys("Hayden");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Insured_Maiden_Name(){
        Input_Data.sendKeys("Mathew");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Social_security_Number(){
        Input_Data.sendKeys("787787878");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Enter_Date_Death() throws IOException, ParseException {
        String year=new ReadJsonData().ReadJSONData("Date_of_Death_Year");
        String month=new ReadJsonData().ReadJSONData("Date_of_Death_Month");
        String data=new ReadJsonData().ReadJSONData("Day");
        new Calendar(driver).PickDateFromCalender(year,month,data);
        NextButton.click();
    }

    public void Handling_Drop_Down() throws InterruptedException {
        new DropDown(driver).BootStrapDropDown1("Natural");

    }

    public void Insured_Street_address() throws IOException, ParseException {
        Input_Data.sendKeys(new ReadJsonData().ReadJSONData("Street_address"));
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Insured_City() throws IOException, ParseException {
        Input_Data.sendKeys(new ReadJsonData().ReadJSONData("City"));
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void State_of_Residence_Drop_Down() throws InterruptedException {
        new DropDown(driver).Get_Drop_Down_Value("State");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Enter_Zip_Code(){
        Input_Data.sendKeys("87878");
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
    }

    public void Medicaid_Drop_Down() throws InterruptedException, IOException, ParseException {
        new DropDown(driver).Get_Drop_Down_Value("Medicaid");
        NextButton.click();

        new WaitHelper(driver).waitForElement(driver,NextButton,10);
        Input_Data.sendKeys("7878");

        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);
        NextButton.click();

        new WaitHelper(driver).waitForElement(driver,NextButton,10);
        NextButton.click();

        Input_Data.sendKeys(new ReadJsonData().ReadJSONData("Street_address"));
        NextButton.click();
        new WaitHelper(driver).waitForElement(driver,NextButton,10);

        for (int i=1;i<=3;i++){
            NextButton.click();
            new WaitHelper(driver).waitForElement(driver,NextButton,10);
        }

    }

    public void Enter_Home_Phone_Number(){
        for (int i=1;i<=2;i++){
            Input_Data.sendKeys("9803007142");
            NextButton.click();
            new WaitHelper(driver).waitForElement(driver,NextButton,10);
        }

    }



}
