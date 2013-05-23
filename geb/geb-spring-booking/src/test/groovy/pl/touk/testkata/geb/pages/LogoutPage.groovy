package pl.touk.testkata.geb.pages

import geb.Page

class LogoutPage extends Page {

    static at = { heading.text() == 'Logout' }

    static content = {
        heading { $('h1') }
        continueLink { $('a', text: contains('Continue')) }
    }
}
