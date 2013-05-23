# Agenda
* Podstawy
* Jukito - http://jukito.arcbees.com/
* gwt-test-utils - https://github.com/gwt-test-utils/gwt-test-utils
* Połączenie Jukito i GwtTest - @RunWith(JukitoGwtTestRunner.class)
* Moduły Testowe
* Request Factory
* Edytory i Driver
 
# Podstawy
* SUT - System Under Test
* DOC - Dependend On  Component
* Fixtura - zbudowanie mikro środowiska dla SUT- czyli  przygotowanie DOC  
* BDD - Given, When, Then
* nazwy testów
* Practical Unit Testing - Tomek Kaczanowski
 
# Jukito
http://jukito.arcbees.com/
## Możliwości Jukito
* wstrzykiwanie DOC na pola oraz do metod
* resetowanie DOC oraz SUT przed wykonaniem kolejnej metody testowej  - @TestSingleton
* Własne moduły Guice

## Konfiguracja Jukito
* @RunWith(JukitoRunner.class) na klasie testu
* klasa wewnętrzna z modułami Guice:   public static class A extends JukitoModule
 
## Przykłady
* TestApplicationFlowManager
* TestFakePlaceManager
* TestOnPathExitHandler
* TestAddressWidgetPresenter
* TestDocumentToCollectWidgetPresenter

## Uwagi
* Scope @TestSingleton jest używany domyślnie dla klas. Interfejsy są bindowane w normalnym Scope

# gwt-test-utils
https://github.com/gwt-test-utils/gwt-test-utils
## Możliwości
* brak problemu z GWT.create()
* symulacja przeglądarki (loopend, wypełnienie pola tekstowego, klikanie, ustawianie locale itp)
* generowanie kodu w teście (Editors, i18n)
 
## Konfiguracja
* extends GwtTest
* @GwtModule("com.efigence.efinity.gxt.Efinity-web-gxt") na klasie testu
* gwt-test-utils.properties w src/test/resources z deklaracjami modułów *.gwt.xml
* com.efigence.efinity.gxt.Efinity-web-gxt = gwt-module
 
# Połączenie Jukito i GwtTest - @RunWith(JukitoGwtTestRunner.class)
## Możliwości
* Wstrzykiwanie zależności jak w czystym Jukito
* Wszystkie dobrodziejstwa gwt-test-utils

## Konfiguracja
* To co typowo dla gwt-test-utils oraz Jukito
zamiast @RunWith(JukitoRunner.class) stosujemy @RunWith(JukitoGwtTestRunner.class) na klasie testu

## Przykłady
* TestAddressDataEditor - testy prostego edytora
* TestCancellationTypeEditor - testy na edytor zbudowany jako grupa radio button'ow
* TestComboBoxEditor - testy na edytor Enum lub String'a zbudowany jako comboBox
* TestTwoAddressOneDriver - test bardziej złożonego edytora
* TestSecuringTheSecureButton - test akceptacyjny dla konfiguracji uprawnień w danym wdrożeniu
 

# Request Factory
* Operowanie na projekcjach modelu JPA
* Brak problemu z Lazy Init
* Automatyczne rewrittery
* Automatyczny binding do Edytorów
* ATP na etapie kompilacji - kontrola kontraktu

# Edytory i Driver
* Abstrakcja i automat do ustawiania modelu i pobierania modelu z formatki
* Graf edytorów odpowiada grafowi domeny
* Stanowy driver wpisuje modele do edytorów i po zakończeniu edycji przez user'a aktualizuje modele

# EDRunner 
# Pułapki

# Usecases a la WebDriver
## Jako U rejestruje swój profil
* Otwieram aplikację
* Klikam "rejestruj profil"
* Wypełniam formatkę na ekranie
* Klikam zapisz
* Przeglądam stronę swojego nowego profilu i oczekuję że dane zostały zapisane

## Jako U edytuję swój profil
* Klikam "Edytuj profil"
* Zmieniam adres zamieszkania
* Zapisuje zmiany i oczekuję że mój profil został zakutalizowany

 
