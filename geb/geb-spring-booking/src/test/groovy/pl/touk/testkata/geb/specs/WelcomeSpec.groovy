package pl.touk.testkata.geb.specs

import geb.spock.GebReportingSpec
import pl.touk.testkata.geb.pages.WelcomePage

class WelcomeSpec extends GebReportingSpec {

    def "should enter welcome page"() {
        when:
            to WelcomePage
        then:
        	at WelcomePage
    }
}
