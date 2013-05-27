package pl.touk.testkata.geb.pages

import geb.Page

class LoginPage extends Page {

    static at = { legend.text() == 'Login Information'}

    static content = {
        legend { $('legend') }
        user { $('#j_username') }
        password(wait: true) { $('#j_password') }
        submit { $('#submit')}
    }

    void loginUser(String username, String passwordText) {
        user = username
        password = passwordText
        submit.click()
    }
}
