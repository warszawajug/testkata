## Test Kata 2013 - Mockito

Projekt wykorzystywany w czasie sesji o Mockito na [Test Kata 2013](http://test.kata.org.pl/). Zalecane jest zbudowanie
go przed przyjściem na katę, aby dodatkowo nie obciążać łącza.

Projekt jest budowany z wykorzystaniem narzędzia [Gradle](http://www.gradle.org/), jednak dzięki zastosowaniu wrappera
nie jest konieczna jego wcześniejsza instalacja.

Proste zbudowanie i wykonanie testów:

    ./gradlew check

(na platformie Windows zamiast gradlew należy użyć gradlew.bat)

Import do IntelliJ Idea (zalecany):

    ./gradlew idea

i potem otworzenie pliku test-kata-mockito.ipr przez File->Open

Import do Eclipse (bez wsparcia prowadzącego):

    ./gradlew eclipse

Autor: [Marcin Zajączkowski](http://blog.solidsoft.info/). Kod jest dostępny na
[licencji Apache w wersji 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
