
# Please do this before the workshop

## 0. Stay tuned!

For now it's only empty project configured without exercises source.
As we can not rely on the internet connection during the workshop just clone and proceed with following instructions to build the project and download necessary dependencies.

The best would be to update from repo at Saturday morning before the workshop begins to be sure your exercises source are final version.
If you can't do this at the morning, don't worry. I'll serve GIT repo during the workshop via a wifi hot-stop.
However this won't help you with downloading dependencies so better don't skip following steps now :)

## 1. Clone this [GIT](http://git-scm.com/download) repo

Click the clone button above and execute the command shown there in shell

## 2. Build the project

In the project root dir ('spockogroovy') run following script from command line:

- Mac/Linux

        ./gradlew build

- Windows

        gradlew.bat

Some dependencies should be downloaded and you should see something like this:

    :compileJava
    :compileGroovy
    :processResources UP-TO-DATE
    :classes
    :jar
    :assemble
    :compileTestJava UP-TO-DATE
    :compileTestGroovy
    :processTestResources UP-TO-DATE
    :testClasses
    :test
    :check
    :build
    
    BUILD SUCCESSFUL
    
    Total time: 7.615 secs

Don't worry about 'warnings'. Though make sure there was 'BUILD SUCCESSFUL' output in the console :)

## 3. Generate Intellij IDEA project

In project root dir do:

    $ ./gradlew idea

You can do this even if you won't use IDEA, it will download dependency sources.

## 4. Install Intellij IDEA (optional but recommended)

This will generate IDE project files.

Install [IntelliJ IDEA](http://www.jetbrains.com/idea/download/) (community edition will be enough).

Run it.

File > Open project... Navigate to repo dir and open the project file (.ipr)

If IDE pops up with Unregistered Git root detected, click Configure then Add root and OK. You should have git command available from PATH if you want to enable GIT integration.

## 5. Run tests under IDE(A) with nice reporting

> Warning: This step will fail if there's no project SDK defined yet. To fix it, click File > Project Structure... adn select a Java 1.7 SDK (creating it if necessary). To create a Java SDK: click New and point to JAVA 1.7 JDK installation path (JDK, not JRE). Leave the default SDK name '1.7' as build.gradle referes to that.

Unfold at project tree to src/test and right-click on groovy folder. Select Run 'All Tests'. All tests will be run :) One is false negative as 'Failed to start' (yellow light). It's because of Spock's @Unroll annotation. Don't worry it's fine.

Passed tests are hidden by default. To see them uncheck Hide passed icon, which is the 2nd icon in tests menu bar with a funnel on it (pl.: 'lejek').

## 6. Eclipse users

Though IntelliJ IDEA is preferred, you can try do the similar as described above at points 4. and 5. The plugin is configured, just run:

    $ ./gradlew eclipse

Open the generated project and try to run tests with IDE.
I haven't tested this so don't expect any support with Eclipse, sorry :)