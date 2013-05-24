package spockogroovy

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

    def twoPlusTwoMakesFour() {
        expect:
        assert 2 + 2 == 4
    }
}
