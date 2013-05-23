package pl.touk.testkata.geb.pages

import geb.Page

class BookingPage extends Page {

    public final static String VISA_CARD_NUMBER = '4024007103311006'

    static at = { legend.text() == 'Book Hotel' }

    static content = {
        legend { $('legend') }
        creaditCard { $('#creditCard')}
        creaditCardName { $('#creditCardName')}
        proceed{ $('#proceed')}
        step2Confirm(cache: false, wait: true){ $('button', text: contains('Confirm'))}
    }

    void fillDefaultForm() {
        creditCard = VISA_CARD_NUMBER
        creditCardName = 'John Doe'
        proceed.click()
        step2Confirm.click()
    }
}
