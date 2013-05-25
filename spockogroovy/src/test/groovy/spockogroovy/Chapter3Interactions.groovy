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
        1 * personDaoMock.findById(415) >> person
    }

    def 'szpiegowanie na prawdziwym obiekcie'() {
        given:
        Person person = Spy(Person)

        when:
        person.name = 'Dżordż'

        then:
        1 * person.setName(_)
    }

    def 'co najmniej trzy dowolne interakcje na mocku/szpiegu'() {
        given:
        Person person = Spy(Person)

        when:
        person.getId()
        person.setName('Radosław')
        person.setAge(38)

        then:
        (3.._) * person._(*_) // at least three calls with any parameters
    }

    def 'maks trzy wywołania dowolnego gettera na mocku/szpiegu'() {
        given:
        Person person = Spy(Person)

        when:
        person.id
        person.name
        person.age
        person.age = 15

        then:
        (_..3) * person._(*_) // TODO: modify method call constraint - use regular expression
    }

}
