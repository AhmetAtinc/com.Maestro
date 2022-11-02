package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_01RegisterPage {
    public US_01RegisterPage() {PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy (xpath = "//input[@placeholder='Name Surname']")
    public WebElement fullNameTextBox;

    @FindBy (xpath = "//input[@placeholder='Company Name']")
    public WebElement companyNameTextBox;

    @FindBy (xpath = "//input[@placeholder='Work email']")
    public WebElement registerEmailAddressTextBox;

    @FindBy (xpath = "//input[@placeholder='Strong password']")
    public WebElement registerPasswordTextBox;

    @FindBy (xpath = "//button[text()='Sign up']")
    public WebElement signUpButton;

    @FindBy (xpath = "//h4[text()='Project Information']")
    public WebElement projectInformationPage;

    @FindBy (xpath = "//div[text()='Name surname is required.']")
    public WebElement nameSurnameIsRequiredText;

    @FindBy (id = "toast-container")
    public WebElement errorMessage;

    @FindBy (xpath = "//div[text()='Company name is required.']")
    public WebElement companyNameIsRequiredText;

    @FindBy (xpath = "//div[text()='Email is required.']")
    public WebElement emailIsRequiredText;

    @FindBy (xpath = "//div[text()='Password is required. ']")
    public WebElement passwordIsRequiredText;

    @FindBy (xpath = "//div[text()='Password should be min. 6, max. 15 characters.']")
    public WebElement min6max15charactersMessage;

    @FindBy (xpath = "//input[@maxlength='15']")
    public WebElement maxLength;

    @FindBy (xpath = "//div[text()=' Email is invalid.']")
    public WebElement emailIsInvalidText;

    @FindBy (xpath = "//a[text()='Sign in']")
    public WebElement returnToSignInButton;

    @FindBy (xpath = "//h3[text()='Log in to your account']")
    public WebElement loginPageText;


}
