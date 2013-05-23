package pl.touk.testkata.geb.pages

import geb.Page

class LoginPage extends Page {

    public final static String SCOTT_USERNAME = 'scott'
    public final static String SCOTT_PASSWORD = 'rochester'

    static url = 'login'

    static at = { legend.text() == 'Login Information'}

    static content = {
        legend { $('legend') }
        user { $('#j_username')}
        password { $('#j_password')}
        submit { $('#submit')}
    }

    void loginAsAUser() {
        user = SCOTT_USERNAME
        password = SCOTT_PASSWORD
        submit.click()
    }
}
