package spockogroovy

import spock.lang.Specification

class Chapter2EasyMocking extends Specification {

    PersonDao personDaoMock

    def 'mock z groovy closure coercion'() {
        given:
        // TODO: cast closure to PersonDao with 'as' operator

        when:
        def person = personDaoMock.findById(5)

        then:
        noExceptionThrown()
        person.id == 5
    }

}
