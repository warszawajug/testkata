Żeby przygotować się w pełni do zajęć, należy:
1. mieć JDK 7
2. postawić sobie MongoDB z bazą testkatadev i z userem testkata:testkata
3. odpalić aplikację by siągnęła zależności

Stawianie MongoDB
-----------------------------

Dla Ubuntu/Debiana Mongo można postawić tak:

    sudo apt-key adv --keyserver keyserver.ubuntu.com --recv 7F0CEB10
    echo 'deb http://downloads-distro.mongodb.org/repo/ubuntu-upstart dist 10gen' | sudo tee /etc/apt/sources.list.d/10gen.list
    sudo apt-get update
    sudo apt-get install mongodb-10gen

Dla Fedory 18

    sudo yum install mongodb-server

Teraz startujemy bazę:

Ubuntu:

    sudo service mongodb start

Fedora

    sudo service mongod start

Teraz edytujemy /etc/mongodb.conf i odkomentowujemy

    auth = true

Teraz, łączymy się z Mongo i zakładamy bazę i usera:

    # mongo
    > use testkatadev
    > db.addUser('testkata', 'testkata')


Odpalanie aplikacji
-----------------------------

Zakładając że masz Windows/Linux/Unix, wejdź do katalogu z shella i uruchom odpowiednio

    ./gradlew jettyRun

lub

    ./gradlew.bat jettyRun

No i trzeba chwilę poczekać, na ściągnięcie całego Internetu

Use case który implementujemy
-----------------------------

* customer wysyła dane do płatności (id billera, msisdn customera, id produktu)
* system sprawdza, w zewnętrznym systemie billera, czy płatność jest możliwa dla danego msisdn'a
* system dolicza opłaty
* system przekazuje polecenie przelewu do core'owego systemu bankowego
* system zapisuje płatność
* system powiadamia zewnętrzny system billera, o udanej płatności
* system zwraca customerowi potwierdzenie udanej płatności

W przypadku niepowodzenia, system musi zapisać próbę płatności.
