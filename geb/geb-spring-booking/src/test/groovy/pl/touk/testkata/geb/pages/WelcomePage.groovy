package pl.touk.testkata.geb.pages

import geb.Page

class WelcomePage extends Page {

    static at = { heading.text() == 'Welcome to Spring Travel'}

    static content = {
        heading { $('h1') }
    }
}
