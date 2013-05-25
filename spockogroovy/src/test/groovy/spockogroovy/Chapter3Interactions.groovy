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

    def 'sprawdzenie braku interakcji'() {
        given:
        Person person = new Person('Matt', 27)

        when:
        personService.save(person)

        then:
        0 * personDaoMock.update(_)
        1 * personDaoMock.create('Matt', 27)
    }

    def 'sprawdzenie interakcji i zamockowanie jednocześnie'() {
        given:
        Person person = new Person('Jane', 21)
        person.id = 415

        when:
        personService.save(person)

        then:
        1 * personDaoMock.findById(415) // TODO: mock return value with right shift operator
    }

}
