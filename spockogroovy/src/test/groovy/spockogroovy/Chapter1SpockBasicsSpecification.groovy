package spockogroovy

import spock.lang.Shared
import spock.lang.Specification

/*
Although Spock uses a different terminology, many of its concepts and features are inspired from JUnit.

    Spock                   JUnit
    -----                   -----
    Specification           Test class
    setup()                 @Before
    cleanup()               @After
    setupSpec()             @BeforeClass
    cleanupSpec()           @AfterClass
    Feature                 Test
    Parametrized feature    Theory
    Condition               Assertion
    Exception condition     @Test(expected=...)
    @FailsWith              @Test(expected=...)
    Interaction             Mock expectation (EasyMock, JMock, ...)
*/

class Chapter1SpockBasicsSpecification extends Specification {

    @Shared List aList = []

    def setup() {
        // TODO: clear or reinitialize list here
    }

    def 'dodać 2 + 2 równa się 4'() {
        expect:
        2 + 2 == 4
    }

    def 'pusta lista jest pusta'() {
        expect:
        aList.empty
    }

    def 'gdy dodamy coś do listy, to już nie jest pusta'() {
        when:
        aList << 'something'

        then:
        aList.size() == 1
    }

    def 'i ponownie lista pusta'() {
        expect:
        aList.empty
    }
}
