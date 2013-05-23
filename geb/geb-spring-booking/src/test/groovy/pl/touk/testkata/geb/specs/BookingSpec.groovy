package pl.touk.testkata.geb.specs

import geb.spock.GebReportingSpec
import pl.touk.testkata.geb.pages.*
import spock.lang.Stepwise

@Stepwise
class BookingSpec extends GebReportingSpec {

    public static final String HOTEL_NAME = 'Marriott Courtyard'

    def "should login as a user"() {
        when:
            to LoginPage
            loginAsAUser()
        then:
            at SearchHotelsPage
    }

    def "should find one entry"() {
        when:
            search(HOTEL_NAME)
        then:
            at HotelResultsPage
            hotelResultRows.size() == 1
            hotelResultRows[0].name == HOTEL_NAME
    }

    def "should go to hotel page"() {
        given:
            at HotelResultsPage
        when:
            hotelResultRows[0].viewHotel.click()
        then:
            at HotelPage
            heading.text() == HOTEL_NAME
    }

    def "should go to booking page"() {
        when:
            bookHotel.click()
        then:
            at BookingPage
    }

    def "should book a hotel"() {
        when:
            fillDefaultForm()
        then:
            at SearchHotelsPage
    }
}
