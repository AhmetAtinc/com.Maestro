package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pages.US_01RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_01Stepdefinitions {

    US_01RegisterPage registerPage = new US_01RegisterPage();

    @Given("Kullanici Register URL'e gider")
    public void kullaniciURLEGider() {
        Driver.getDriver().get(ConfigReader.getProperty("RegisterURL"));
    }

    @And("Kullanici Full Name kutusuna gecerli bir Full Name yazar")
    public void kullaniciFullNameKutusunaGecerliBirFullNameYazar() {
        registerPage.fullNameTextBox.sendKeys(ConfigReader.getProperty("FullName"));
    }

    @Then("Kullanici Company Name kutusuna gecerli bir Company Name yazar")
    public void kullaniciCompanyNameKutusunaGecerliBirCompanyNameYazar() {
        registerPage.companyNameTextBox.sendKeys(ConfigReader.getProperty("CompanyName"));
    }

    @And("Kullanici Email address kutusuna gecerli bir Email yazar")
    public void kullaniciEmailAddressKutusunaGecerliBirEmailYazar() {
        registerPage.registerEmailAddressTextBox.sendKeys(ConfigReader.getProperty("EmailAddress"));
    }

    @And("Kullanici Password kutusuna gecerli bir Password yazar")
    public void kullaniciPasswordKutusunaGecerliBirPasswordYazar() {
        registerPage.registerPasswordTextBox.sendKeys(ConfigReader.getProperty("Password"));
    }

    @Then("Kullanici Sign up butonuna tiklar")
    public void kullaniciSignUpButonunaTiklar() throws InterruptedException {
        registerPage.signUpButton.click();
        Thread.sleep(2000);
    }

    @Then("Yeni kayit ile giris yapildigi dogrulanir")
    public void yeniKayitIleGirisYapildigiDogrulanir() {
        Assert.assertTrue(registerPage.projectInformationPage.isDisplayed());
    }


    @And("Kullanici Full Name kutusunu tiklar")
    public void kullaniciFullNameKutusunuTiklar() {
        registerPage.fullNameTextBox.click();
    }

    @Then("Name surname is required. uyari yazisinin goruntulendigi dogrulanir")
    public void nameSurnameIsRequiredUyariYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.nameSurnameIsRequiredText.isDisplayed());
    }

    @And("Kullanici Full Name kutusuna 2 karakter bilgi yazar")
    public void kullaniciFullNameKutusunaKarakterBilgiYazar() {
        registerPage.fullNameTextBox.sendKeys(ConfigReader.getProperty("InvalidFullNameTwoCharacter"));
    }

    @Then("Error User name surname min length 3. uyari yazisi goruldugu dogrulanir")
    public void errorUserNameSurnameMinLengthUyariYazisiGorulduguDogrulanir() {
        Assert.assertTrue(registerPage.errorMessage.isDisplayed());
    }


    @Then("Kullanici Company Name kutusuna tiklar")
    public void kullaniciCompanyNameKutusunaTiklar() {
        registerPage.companyNameTextBox.click();
    }

    @And("Company name is required. uyari yazisinin goruntulendigi dogrulanir")
    public void companyNameIsRequiredUyariYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.companyNameIsRequiredText.isDisplayed());
    }

    @And("Kullanici Email address kutusunu tiklar")
    public void kullaniciEmailAddressKutusunuTiklar() {
        registerPage.registerEmailAddressTextBox.click();
    }


    @And("Email is required. uyari yazisinin goruntulendigi dogrulanir")
    public void emailIsRequiredUyariYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.emailIsRequiredText.isDisplayed());
    }


    @And("Kullanici Email address kutusuna daha onceden alinmis bir Email yazar")
    public void kullaniciEmailAddressKutusunaDahaOncedenAlinmisBirEmailYazar() {
        registerPage.registerEmailAddressTextBox.sendKeys(ConfigReader.getProperty("EmailAddress"));
    }


    @Then("Error Email already exists. yazisinin goruntulendigi dogrulanir")
    public void errorEmailAlreadyExistsYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.errorMessage.isDisplayed());
    }

    @When("Kullanici Password kutusuna tiklar")
    public void kullaniciPasswordKutusunaTiklar() {
        registerPage.registerPasswordTextBox.click();
    }

    @Then("Password is required. uyari yazisinin goruntulendigi dogrulanir")
    public void passwordIsRequiredUyariYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.passwordIsRequiredText.isDisplayed());
    }


    @Then("Sign up butonu tiklanmamali")
    public void signUpButonuTiklanmamali() throws InterruptedException {
        Assert.assertFalse(registerPage.signUpButton.isEnabled());
        Thread.sleep(3000);
    }

    @When("Kullanici Password kutusuna 5 karakterli gecersiz sifre yazar")
    public void kullaniciPasswordKutusunaKarakterliGecersizSifreYazar() {
        registerPage.registerPasswordTextBox.sendKeys(ConfigReader.getProperty("InvalidPasswordFiveCharacter"));
    }

    @And("Password should be min. 6, max. 15 characters. uyari yazisinin goruntulendigi dogrulanir")
    public void passwordShouldBeMinMaxCharactersUyariYazisininGoruntulendigiDogrulanir() {
        registerPage.fullNameTextBox.click();
        Assert.assertTrue(registerPage.min6max15charactersMessage.isDisplayed());
    }

    @And("Kullanici Password kutusuna 16 karakterli gecersiz sifre yazamamalidir")
    public void kullaniciPasswordKutusunaKarakterliGecersizSifreYazamamalidir() {
        registerPage.registerPasswordTextBox.sendKeys(ConfigReader.getProperty("InvalidPasswordSixteenCharacter")+ Keys.ENTER);

    }

    @Then("16 karakterli sifre yazilamadigi dogrulanir")
    public void karakterliSifreYazilamadigiDogrulanir() throws InterruptedException {

            System.out.println(registerPage.maxLength.getAttribute("value").length());
            Assert.assertTrue(registerPage.maxLength.getAttribute("value").length()<=15);
        Thread.sleep(3000);
    }

    @And("Kullanici Email address kutusuna icerisinde @ bulunmayan adres yazar")
    public void kullaniciEmailAddressKutusunaIcerisindeBulunmayanAdresYazar() {
        registerPage.registerEmailAddressTextBox.sendKeys(ConfigReader.getProperty("InvalidEmailAddress@non"));
    }


    @When("Email is invalid. uyari yazisinin goruntulendigi dogrulanir")
    public void emailIsInvalidUyariYazisininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.emailIsInvalidText.isDisplayed());
    }

    @And("Kullanici Email address kutusuna icerisinde @ bulununan sonrasinda karakter bulunmayan adres yazar")
    public void kullaniciEmailAddressKutusunaIcerisindeBulununanSonrasindaKarakterBulunmayanAdresYazar() {
        registerPage.registerEmailAddressTextBox.sendKeys(ConfigReader.getProperty("InvalidEmailAddress@afterNonCharacter"));
    }


    @When("Kullanici Return to Sign in butonuna tiklar")
    public void kullaniciReturnToSignInButonunaTiklar() {
        registerPage.returnToSignInButton.click();
    }

    @Then("Oturum acma sayfasinin goruntulendigi dogrulanir")
    public void oturumAcmaSayfasininGoruntulendigiDogrulanir() {
        Assert.assertTrue(registerPage.loginPageText.isDisplayed());
    }
}
