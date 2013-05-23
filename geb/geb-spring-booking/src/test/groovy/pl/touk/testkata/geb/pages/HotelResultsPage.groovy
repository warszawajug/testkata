package pl.touk.testkata.geb.pages

import geb.Page
import pl.touk.testkata.geb.modules.HotelResultModule

class HotelResultsPage extends Page {

    static at = { heading.text() == 'Hotel Results'}

    static content = {
        heading { $('h1')}
        hotelResultRows { moduleList HotelResultModule, $("table tr").tail() } // tailing to skip the header row
    }
}
