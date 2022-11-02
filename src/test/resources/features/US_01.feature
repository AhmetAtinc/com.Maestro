Feature: US_01 Register sayfasına ait tüm test caselerinin uygun ve kabul gormus bir formatta olusturulmasi ve test sonuclarinin yazilmasi beklenmektedir.

  Scenario: TC_01 Yeni kayit olusturulabilmelidir.

    Given Kullanici Register URL'e gider
    And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
    Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
    And   Kullanici Email address kutusuna gecerli bir Email yazar
    And   Kullanici Password kutusuna gecerli bir Password yazar
    Then  Kullanici Sign up butonuna tiklar
    Then  Yeni kayit ile giris yapildigi dogrulanir


  Scenario: TC_02 Full Name kutusu bos birakilamaz

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusunu tiklar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  And   Kullanici Password kutusuna gecerli bir Password yazar
  Then  Name surname is required. uyari yazisinin goruntulendigi dogrulanir

  Scenario: TC_03 Full Name kutusuna 3 karakterden az bilgi girilmemelidir

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna 2 karakter bilgi yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  When  Kullanici Password kutusuna gecerli bir Password yazar
  And   Kullanici Sign up butonuna tiklar
  Then  Error User name surname min length 3. uyari yazisi goruldugu dogrulanir

  Scenario: TC_04 Company Name kutusu bos birakilamaz

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna tiklar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  When  Kullanici Password kutusuna gecerli bir Password yazar
  And   Company name is required. uyari yazisinin goruntulendigi dogrulanir

  Scenario: TC_05 Email address adresi kutusu bos birakilamaz

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusunu tiklar
  When  Kullanici Password kutusuna gecerli bir Password yazar
  And   Email is required. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_06 Daha önceden alinmis bir email address ile kayit yapilmamalidir

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna daha onceden alinmis bir Email yazar
  When  Kullanici Password kutusuna gecerli bir Password yazar
  And   Kullanici Sign up butonuna tiklar
  Then  Error Email already exists. yazisinin goruntulendigi dogrulanir


  Scenario: TC_07 Password  kutusu bos birakilamaz

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  When  Kullanici Password kutusuna tiklar
  Then  Password is required. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_08 Herhangi bir bilgi kutusu bos birakilirsa sign up butonu tiklanmamalidir.

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna tiklar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  When  Kullanici Password kutusuna gecerli bir Password yazar
  Then  Sign up butonu tiklanmamali


  Scenario: TC_09 Password kutusuna en az 6 en fazla 15 karakter yazilabilmelidir.

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna gecerli bir Email yazar
  When  Kullanici Password kutusuna 5 karakterli gecersiz sifre yazar
  And   Password should be min. 6, max. 15 characters. uyari yazisinin goruntulendigi dogrulanir
  And   Kullanici Password kutusuna 16 karakterli gecersiz sifre yazamamalidir
  Then  16 karakterli sifre yazilamadigi dogrulanir


  Scenario: TC_10 Email address "@" icermelidir, "@" sembolunden once ve sonra bir karakter icermiyorsa "Email is invalid." uyari yazisi goruntulenmelidir.

  Given Kullanici Register URL'e gider
  And   Kullanici Full Name kutusuna gecerli bir Full Name yazar
  Then  Kullanici Company Name kutusuna gecerli bir Company Name yazar
  And   Kullanici Email address kutusuna icerisinde @ bulunmayan adres yazar
  When  Email is invalid. uyari yazisinin goruntulendigi dogrulanir
  And   Kullanici Email address kutusuna icerisinde @ bulununan sonrasinda karakter bulunmayan adres yazar
  Then  Email is invalid. uyari yazisinin goruntulendigi dogrulanir


  Scenario: TC_11 Register sayfasindan oturum acma sayfasina gecilebilmelidir.

  Given Kullanici Register URL'e gider
  When  Kullanici Return to Sign in butonuna tiklar
  Then  Oturum acma sayfasinin goruntulendigi dogrulanir























