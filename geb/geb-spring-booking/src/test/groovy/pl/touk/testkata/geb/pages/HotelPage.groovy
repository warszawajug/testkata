package pl.touk.testkata.geb.pages

import geb.Page

class HotelPage extends Page {

    static at = { bookHotel }

    static content = {
        heading { $('h1') }
        bookHotel { $('button', text: contains('Book Hotel'))}
    }
}
