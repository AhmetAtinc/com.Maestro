package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_02LoginPage {

   public US_02LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//button[text()='Sign in']")
    public WebElement signInButton;

   @FindBy (xpath = "//h3[text()='Dashboard']")
    public WebElement signInSuccess;

   @FindBy (xpath = "//input[@placeholder='Email']")
    public  WebElement loginEmailTextBox;

   @FindBy (xpath = "//input[@placeholder='Password']")
    public WebElement loginPasswordTextBox;

   @FindBy (xpath = "//a[text()='Forgot Password?']")
    public WebElement forgotPasswordLink;

   @FindBy (xpath = "//input[@formcontrolname='email']")
    public WebElement forgotPasswordPageEmailAddressTextBox;

   @FindBy (xpath = "//button[text()='Send Email']")
    public WebElement sendEmailButton;

   @FindBy (id = "toast-container")
    public WebElement successMessageForSendEmail;

   @FindBy (xpath = "//h3[text()='Get password reset e-mail']")
    public WebElement getPasswordResetPage;

   @FindBy (xpath = "//div[text()='Email is invalid.']")
    public WebElement emailIsInvalidMessage;

   @FindBy (xpath = "//a[text()='Sign up']")
    public WebElement dontHaveAnAccountNextSignUpLink;

   @FindBy (xpath = "//h3[text()='Create your free account']")
    public WebElement createYourFreeAccountPage;

   @FindBy (xpath = "(//div[@class='profile-circle profile-circle-md'])[1]")
    public WebElement userIcon;

   @FindBy (xpath = "//i-feather[@name='log-out']")
    public WebElement logoutButton;

}
