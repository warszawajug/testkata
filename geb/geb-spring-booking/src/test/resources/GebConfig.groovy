/**
 * This is the Geb configuration file.
 * See: http://www.gebish.org/manual/current/configuration.html
 */
import org.openqa.selenium.firefox.FirefoxDriver

waiting { timeout = 5 }
driver = { new FirefoxDriver() }
reportsDir = "target/geb-reports"
baseUrl = "http://localhost:8080/booking-mvc/"

// To run the tests with all browsers just run “./gradlew test”