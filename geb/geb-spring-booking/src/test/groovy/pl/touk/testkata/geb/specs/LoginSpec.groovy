package pl.touk.testkata.geb.specs

import geb.spock.GebReportingSpec
import pl.touk.testkata.geb.pages.LoginPage
import pl.touk.testkata.geb.pages.LogoutPage
import pl.touk.testkata.geb.pages.SearchHotelsPage
import pl.touk.testkata.geb.pages.WelcomePage
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {

    public final static String USERNAME = 'scott'
    public final static String PASSWORD = 'rochester'

    def "should go to login page"() {
        given:
            to WelcomePage
        when:
            login.click()
        then:
            at LoginPage
    }

    def "should login as scott"() {
        when:
            user = USERNAME
            password = PASSWORD
            submit.click()
        then:
            at SearchHotelsPage
    }

    def "should logout"() {
        when:
            $('a', text: contains('Logout')).click()
        then:
            at LogoutPage
    }

    def "should continue to search hotels page"() {
        expect:
            continueLink.click(SearchHotelsPage)
    }
}
