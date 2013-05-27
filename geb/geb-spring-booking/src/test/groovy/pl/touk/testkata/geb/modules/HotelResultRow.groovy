package pl.touk.testkata.geb.modules

import geb.Module

class HotelResultRow extends Module {

    static content = {
        cell { $('td', it) }
        name { cell(0).text() }
        address { cell(1).text() }
        city { cell(2).text() }
        zip { cell(3).text() }
        action { cell(4) }
//        viewHotel { cell(4).find('a')}
        viewHotel { action.find('a')}
    }
}
