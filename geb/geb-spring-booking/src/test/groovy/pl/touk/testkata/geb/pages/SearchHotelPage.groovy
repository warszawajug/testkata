package pl.touk.testkata.geb.pages

import geb.Page

class SearchHotelPage extends Page {

    // to SearchHotelPage
    static url = 'hotel/search'

    static at = { heading.text() == 'Search Hotels'}

    public static Closure content = {}


    static content = {
        heading { $('h1') }
        searchField { $('#searchString')}
        findHotels { $('button', text: contains('Find Hotels'))}
    }

    void search(String hotelName) {
        searchField = hotelName
        findHotels.click()
    }
}

