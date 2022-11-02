package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.US_01RegisterPage;
import pages.US_02LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_02Stepdefinitions {

    US_02LoginPage loginPage=new US_02LoginPage();
    US_01RegisterPage registerPage = new US_01RegisterPage();

    @Given("Kullanici Login URL'e gider")
    public void kullanici_login_url_e_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("LoginURL"));
    }
    @Then("Kullanici Sign in butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
      loginPage.signInButton.click();
    }
    @Then("Sayfaya giris yapildigi dogrulanir")
    public void sayfaya_giris_yapildigi_dogrulanir() {
        Assert.assertTrue(loginPage.signInSuccess.isDisplayed());
    }


    @And("Kullanici Login Email address kutusuna gecerli bir Email yazar")
    public void kullaniciLoginEmailAddressKutusunaGecerliBirEmailYazar() {
        loginPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("EmailAddress"));
    }

    @Then("Kullanici Login Password kutusuna gecerli bir Password yazar")
    public void kullaniciLoginPasswordKutusunaGecerliBirPasswordYazar() {
        loginPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("Password"));
    }

    @Then("Kullanici Login Password kutusuna gecersiz bir Password yazar")
    public void kullaniciLoginPasswordKutusunaGecersizBirPasswordYazar() {
        loginPage.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("InvalidPassword"));
    }

    @Then("Error Incorrect email or password uyari mesaji goruntulenmelidir")
    public void errorIncorrectEmailOrPasswordUyariMesajiGoruntulenmelidir() {
        Assert.assertTrue(registerPage.errorMessage.isDisplayed());
    }

    @And("Kullanici Login Email address kutusuna gecersiz bir email adresi yazar")
    public void kullaniciLoginEmailAddressKutusunaGecersizBirEmailAdresiYazar() {
        loginPage.loginEmailTextBox.sendKeys(ConfigReader.getProperty("InvalidEmailAddress"));
    }

    @And("Kullanici Login Email address kutusuna tiklar")
    public void kullaniciLoginEmailAddressKutusunaTiklar() {
        loginPage.loginEmailTextBox.click();
    }

    @And("Kullanici Login Password kutusuna tiklar")
    public void kullaniciLoginPasswordKutusunaTiklar() {
        loginPage.loginPasswordTextBox.click();
    }

    @Then("Sign in butonu tiklanmamali")
    public void signInButonuTiklanmamali() throws InterruptedException {
        Assert.assertFalse(loginPage.signInButton.isEnabled());
        Thread.sleep(3000);
    }

    @And("Kullanici Forgot Password? sekmesine tiklar")
    public void kullaniciForgotPasswordSekmesineTiklar() {
        loginPage.forgotPasswordLink.click();
    }

    @When("Kullanici Email address kutusuna gecerli bir email adresi yazar")
    public void kullaniciEmailAddressKutusunaGecerliBirEmailAdresiYazar() {
        loginPage.forgotPasswordPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("EmailAddress"));
    }

    @And("Kullanici Send Email butonuna tiklar")
    public void kullaniciSendEmailButonunaTiklar() throws InterruptedException {
        loginPage.sendEmailButton.click();
        Thread.sleep(3000);
    }

    @Then("Success mesajinin goruntulendigi dogrulanir")
    public void successMesajininGoruntulendigiDogrulanir() {
        Assert.assertTrue(loginPage.successMessageForSendEmail.isDisplayed());
    }

    @When("Kullanici Email address kutusuna gecersiz bir email adresi yazar")
    public void kullaniciEmailAddressKutusunaGecersizBirEmailAdresiYazar() {
        loginPage.forgotPasswordPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("InvalidEmailAddress@afterNonCharacter"));
        loginPage.getPasswordResetPage.click();
    }

    @Then("Success mesaji goruntulenmemelidir")
    public void successMesajiGoruntulenmemelidir() {
        Assert.assertFalse(loginPage.successMessageForSendEmail.isDisplayed());
    }

    @When("Kullanici Email address kutusuna tiklar")
    public void kullaniciEmailAddressKutusunaTiklar() {
        loginPage.forgotPasswordPageEmailAddressTextBox.click();
        loginPage.getPasswordResetPage.click();
    }

    @Then("Email is invalid. uyari yazisinin goruntulendigi dogrulanir \\(Get password reset e-mail)")
    public void emailIsInvalidUyariYazisininGoruntulendigiDogrulanirGetPasswordResetEMail() {
        Assert.assertTrue(loginPage.emailIsInvalidMessage.isDisplayed());
    }

    @And("Kullanici Don’t have an account? yazisinin yaninda bulunan Sign up linkini tiklar")
    public void kullaniciDonTHaveAnAccountYazisininYanindaBulunanSignUpLinkiniTiklar() {
        loginPage.dontHaveAnAccountNextSignUpLink.click();
    }

    @Then("Register sayfasinin goruntulendigi dogrulanir")
    public void registerSayfasininGoruntulendigiDogrulanir() {
        Assert.assertTrue(loginPage.createYourFreeAccountPage.isDisplayed());
    }

    @Then("The user closes the page")
    public void theUserClosesThePage() {
        Driver.getDriver().quit();
    }
}
