package pl.touk.testkata.geb.modules

import geb.Module

class HotelResultModule extends Module {

    static content = {
        cell { $("td", it) }
        name { cell(0).text() }
        addressCity { cell(1).text() }
        state { cell(2).text() }
        zip { cell(3).text() }
        action { cell(3) }
        viewHotel { $("a", text: contains('View Hotel')) }
    }
}
