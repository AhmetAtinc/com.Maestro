@login
Feature: US_02 Login sayfasına ait tüm test caselerinin uygun ve kabul görmüş bir formatta oluşturulması ve test sonuçlarının yazılması beklenmektedir.

  Scenario: TC_01 Kullanici gecerli bir email address ve gecerli bir password ile giris yapabilmelidir.

  Given  Kullanici Login URL'e gider
  And    Kullanici Login Email address kutusuna gecerli bir Email yazar
  Then   Kullanici Login Password kutusuna gecerli bir Password yazar
  And    Kullanici Sign in butonuna tiklar
  Then   Sayfaya giris yapildigi dogrulanir


  Scenario: TC_02 Kullanici gecerli bir email address ve gecersiz bir password ile giris yapamamalidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Email address kutusuna gecerli bir Email yazar
  Then  Kullanici Login Password kutusuna gecersiz bir Password yazar
  And   Kullanici Sign in butonuna tiklar
  Then  Error Incorrect email or password uyari mesaji goruntulenmelidir

  Scenario: TC_03 Kullanici gecersiz bir email address ve gecerli bir password ile giris yapamamalidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Email address kutusuna gecersiz bir email adresi yazar
  Then  Kullanici Login Password kutusuna gecerli bir Password yazar
  And   Kullanici Sign in butonuna tiklar
  Then  Error Incorrect email or password uyari mesaji goruntulenmelidir

  Scenario: TC_04 Kullanici gecersiz bir email address ve gecersiz bir password ile giris yapamamalidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Email address kutusuna gecersiz bir email adresi yazar
  Then  Kullanici Login Password kutusuna gecersiz bir Password yazar
  And   Kullanici Sign in butonuna tiklar
  Then  Error Incorrect email or password uyari mesaji goruntulenmelidir


  Scenario: TC_05 Email address kutusu bos birakilirsa "Email is required." yazisi goruntulenmelidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Email address kutusuna tiklar
  When  Kullanici Login Password kutusuna gecerli bir Password yazar
  Then  Email is required. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_06 Password kutusu bos birakilirsa "Password is required." yazisi goruntulenmelidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Password kutusuna tiklar
  When  Kullanici Login Email address kutusuna gecersiz bir email adresi yazar
  Then  Password is required. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_07 Herhangi bir bilgi kutusu bos birakilirsa sign in butonu tiklanmamalidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Login Email address kutusuna tiklar
  When  Kullanici Login Password kutusuna gecerli bir Password yazar
  Then  Sign in butonu tiklanmamali


  Scenario: TC_08 Forgot Password? sekmesinden gecerli bir email adresine mail gonderilebilmelidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Forgot Password? sekmesine tiklar
  When  Kullanici Email address kutusuna gecerli bir email adresi yazar
  And   Kullanici Send Email butonuna tiklar
  Then  Success mesajinin goruntulendigi dogrulanir

  Scenario: TC_09 Forgot Password? sekmesinden gecersiz bir email adresi ile sifre sifirlama maili  gönderilmemelidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Forgot Password? sekmesine tiklar
  When  Kullanici Email address kutusuna gecersiz bir email adresi yazar
  And   Kullanici Send Email butonuna tiklar
  Then  Success mesaji goruntulenmemelidir


  Scenario: TC_10 Forgot Password? sekmesinden email adres kutusu bos birakilmamalidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Forgot Password? sekmesine tiklar
  When  Kullanici Email address kutusuna tiklar
  Then  Email is required. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_11 Forgot Password? sekmesinden email adres kutusa eksik adres girilmemelidir.

  Given Kullanici Login URL'e gider
  And   Kullanici Forgot Password? sekmesine tiklar
  When Kullanici Email address kutusuna gecersiz bir email adresi yazar
  Then Email is invalid. uyari yazisinin goruntulendigi dogrulanir (Get password reset e-mail)

  Scenario: TC_12 Login sayfasindan register sayfasına gecilebilmelidir.

  Given  Kullanici Login URL'e gider
  And  Kullanici Don’t have an account? yazisinin yaninda bulunan Sign up linkini tiklar
  Then Register sayfasinin goruntulendigi dogrulanir
