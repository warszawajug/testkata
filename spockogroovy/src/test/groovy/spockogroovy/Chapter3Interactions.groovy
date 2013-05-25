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


    def 'sprawdzenie interakcji z dowolnym parametrem'() {
        when:
        personService.get(5)
        personService.get(10)
        personService.get(15)

        then:
        3 * personDaoMock.findById(_)
    }

}
