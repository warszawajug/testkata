package pl.touk.testkata.geb.pages

import geb.Page

class SearchHotelsPage extends Page {

    static at = { heading.text() == 'Search Hotels'}

    static content = {
        heading { $('h1') }
        searchString { $('#searchString') }
        findHotels { $('button', text: contains('Find Hotels'))}
    }

    void search(String hotelName) {
        searchString = hotelName
        findHotels.click()
    }

}
