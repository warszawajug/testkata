Test Kata Geb
=============

This is a blueprint for Test Kata Geb excercise.

Installation and run
--------------------

* Make sure you have one of recent Firefox versions installed

* First console:

        cd spring-webflow-samples/booking-mvc
        mvn tomcat:run

* Second console:

        cd geb-spring-booking
        ./gradlew test

* Open up `geb-manual-0.9/all.html` in your favourite browser

* You're ready!

References
---------

I strongly recommend to read and use Geb's manual: The Book of Geb: [http://www.gebish.org/manual/current/all.html](http://www.gebish.org/manual/current/all.html).
Offline version of this book is attached to this project in `geb-manual-0.9` directory.

We use Spring Webflow Example as a sample application to test. It's original repository is placed here: [https://github.com/SpringSource/spring-webflow-samples](https://github.com/SpringSource/spring-webflow-samples).
However, a copy of this repository is attatched to this project for offline access.

Geb application is originally based on Luke Daley's example application: [https://github.com/geb/geb-example-gradle](https://github.com/geb/geb-example-gradle).
If you want to start from scratch look up in forks for versions updated to latest dependencies.
hub.com/SpringSource/spring-webflow-samples)

Credits and kudos
-----------------

This kata is prepared by [Tomasz Kalkosiński](https://github.com/SpOOnman). Geb's and Spring's repositories are included here only for offline excersise purposes.

