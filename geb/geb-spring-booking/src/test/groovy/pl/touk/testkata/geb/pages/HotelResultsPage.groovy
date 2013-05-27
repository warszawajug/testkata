package pl.touk.testkata.geb.pages
import geb.Page
import pl.touk.testkata.geb.modules.HotelResultRow

class HotelResultsPage extends Page {

    static at = { heading.text() == 'Hotel Results'}

    static content = {
        heading { $('h1') }
//        results { moduleList HotelResultRow, $('table')}
        results { moduleList HotelResultRow, $("table tr").tail() } // tailing to skip the header row
    }
}
