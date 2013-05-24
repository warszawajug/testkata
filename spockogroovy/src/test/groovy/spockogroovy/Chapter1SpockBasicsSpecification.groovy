package spockogroovy

import spock.lang.Ignore
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

    def 'dodać 2 + 2 równa się 4'() {
        expect:
        2 + 2 == 4
    }

    @Ignore('declare an empty List and remove the annotation. Try using "setup" or "given" block')
    def 'pusta lista jest pusta'() {

        expect:
        aList.empty
    }
}
