package pl.touk.testkata.geb.specs

import geb.spock.GebReportingSpec
import pl.touk.testkata.geb.pages.HotelResultsPage
import pl.touk.testkata.geb.pages.LoginPage
import pl.touk.testkata.geb.pages.SearchHotelPage
import pl.touk.testkata.geb.pages.WelcomePage
import spock.lang.Stepwise

@Stepwise
class BookingSpec extends GebReportingSpec {

    def "should go from welcome page to login page"() {
        when:
            to WelcomePage // oraz sprawdza WelcomePage
            // this.page = new WelcomePage

            login.click()
            // brak login w LoginSpec
        // LoginSpec.methodMissing
        // czy this.page ma 'login'?
        // this.page.login
        then:
           at LoginPage
    }

    def "should login as a default user"() {
        // this.page = LoginPage
        when:
            loginUser('scott', 'rochester')
        then:
            at SearchHotelPage
    }

    def "should search for a hotel"() {
        when:
            search('Marriott Courtyard')
        then:
            at HotelResultsPage
    }

    def "should contain one row"() {
        expect:
            results.size() == 1
    }

    def "should view hotel"() {
        expect:
            results[0].viewHotel.click()
    }

}
