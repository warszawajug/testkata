package spockogroovy

import spock.lang.Specification

class Chapter2EasyMocking extends Specification {

    PersonDao personDaoMock

    def 'mock z groovy closure coercion'() {
        given:
        personDaoMock = {
            def person = new Person()
            person.id = 5 // id is private and has no setter!
            return person
        } as PersonDao

        when:
        def person = personDaoMock.findById(5)

        then:
        noExceptionThrown()
        person.id == 5
    }

}
