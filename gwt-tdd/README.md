# Agenda
* Podstawy
* Jukito - http://jukito.arcbees.com/
* gwt-test-utils - https://github.com/gwt-test-utils/gwt-test-utils
* Po³±czenie Jukito i GwtTest - @RunWith(JukitoGwtTestRunner.class)
* Modu³y Testowe
* Request Factory
* Edytory i Driver
 
# Podstawy
* SUT - System Under Test
* DOC - Dependend On  Component
* Fixtura - zbudowanie mikro ¶rodowiska dla SUT- czyli  przygotowanie DOC  
* BDD - Given, When, Then
* nazwy testów
* Practical Unit Testing - Tomek Kaczanowski
 
# Jukito
http://jukito.arcbees.com/
## Mo¿liwo¶ci Jukito
* wstrzykiwanie DOC na pola oraz do metod
* resetowanie DOC oraz SUT przed wykonaniem kolejnej metody testowej  - @TestSingleton
* W³asne modu³y Guice

## Konfiguracja Jukito
* @RunWith(JukitoRunner.class) na klasie testu
* klasa wewnêtrzna z modu³ami Guice:   public static class A extends JukitoModule
 
## Przyk³ady
* TestApplicationFlowManager
* TestFakePlaceManager
* TestOnPathExitHandler
* TestAddressWidgetPresenter
* TestDocumentToCollectWidgetPresenter

## Uwagi
* Scope @TestSingleton jest u¿ywany domy¶lnie dla klas. Interfejsy s± bindowane w normalnym Scope

# gwt-test-utils
https://github.com/gwt-test-utils/gwt-test-utils
## Mo¿liwo¶ci
* brak problemu z GWT.create()
* symulacja przegl±darki (loopend, wype³nienie pola tekstowego, klikanie, ustawianie locale itp)
* generowanie kodu w te¶cie (Editors, i18n)
 
## Konfiguracja
* extends GwtTest
* @GwtModule("com.efigence.efinity.gxt.Efinity-web-gxt") na klasie testu
* gwt-test-utils.properties w src/test/resources z deklaracjami modu³ów *.gwt.xml
* com.efigence.efinity.gxt.Efinity-web-gxt = gwt-module
 
# Po³±czenie Jukito i GwtTest - @RunWith(JukitoGwtTestRunner.class)
## Mo¿liwo¶ci
* Wstrzykiwanie zale¿no¶ci jak w czystym Jukito
* Wszystkie dobrodziejstwa gwt-test-utils

## Konfiguracja
* To co typowo dla gwt-test-utils oraz Jukito
zamiast @RunWith(JukitoRunner.class) stosujemy @RunWith(JukitoGwtTestRunner.class) na klasie testu

## Przyk³ady
* TestAddressDataEditor - testy prostego edytora
* TestCancellationTypeEditor - testy na edytor zbudowany jako grupa radio button'ow
* TestComboBoxEditor - testy na edytor Enum lub String'a zbudowany jako comboBox
* TestTwoAddressOneDriver - test bardziej z³o¿onego edytora
* TestSecuringTheSecureButton - test akceptacyjny dla konfiguracji uprawnieñ w danym wdro¿eniu
 

# Request Factory
* Operowanie na projekcjach modelu JPA
* Brak problemu z Lazy Init
* Automatyczne rewrittery
* Automatyczny binding do Edytorów
* ATP na etapie kompilacji - kontrola kontraktu

# Edytory i Driver
* Abstrakcja i automat do ustawiania modelu i pobierania modelu z formatki
* Graf edytorów odpowiada grafowi domeny
* Stanowy driver wpisuje modele do edytorów i po zakoñczeniu edycji przez user'a aktualizuje modele

# EDRunner 
# Pu³apki

# Usecases a la WebDriver
## Jako U rejestruje swój profil
* Otwieram aplikacjê
* Klikam "rejestruj profil"
* Wype³niam formatkê na ekranie
* Klikam zapisz
* Przegl±dam stronê swojego nowego profilu i oczekujê ¿e dane zosta³y zapisane

## Jako U edytujê swój profil
* Klikam "Edytuj profil"
* Zmieniam adres zamieszkania
* Zapisuje zmiany i oczekujê ¿e mój profil zosta³ zakutalizowany