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
        // TODO: call personService for adults to satisfy interaction check
        personService

        then:
        1 * personDaoMock.findAllOlderThan(18)
    }

}
