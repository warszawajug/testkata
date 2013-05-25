package spockogroovy

import spock.lang.Specification

class Chapter3Interactions extends Specification {

    PersonService personService = new PersonService()
    PersonDao personDaoMock = Mock(PersonDao)

    def setup() {
        personService.dao = personDaoMock
    }

    def 'sprawdzenie interakcji z parametrem'() {
        when:
        personService.allAdults

        then:
        1 * personDaoMock.findAllOlderThan(18)
    }

}
