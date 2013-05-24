package spockogroovy

import spock.lang.Ignore
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
        aList.clear()
        println 'setup() runs before every feature method'
    }

    def cleanup() { println 'cleanup() runs after every feature method' }

    def setupSpec() { println 'setupSpec() runs only once before the first feature method' }

    def cleanupSpec() { println 'cleanupSpec() run only once after the last feature method' }

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

    def 'a na mapie sobie działamy tak'() {
        given: 'mając zadeklarowaną mapę'
        Map aMap

        and: 'oraz drugą mapę z trzema wartościami'
        Map otherMap = [brand: 'Audi', model: 'S5', engine: '4.2L V8']

        expect: 'spodziewamy się, że zadeklarowana mapa będzie nullem'
        aMap == null

        and: 'natomiast mapa z wartościami będzie miała rozmiar równy trzy'
        otherMap.size() == 3

        when: 'kiedy zainicjalizujemy pierwszą mapę'
        aMap = [:]

        then: 'będzie ona pusta'
        aMap.isEmpty()

        when: 'a gdy wstawimy wszystkie wartości z drugiej mapy, do pierwszej'
        aMap.putAll(otherMap)

        then: 'to ta pierwsza mapa również będzie rozmiaru trzy'
        aMap.size() == 3

        and: 'oraz będzie mieć taką samą zawartość jak druga mapa'
        aMap == otherMap

        cleanup: 'zaś na koniec sobie wyczyścimy obie mapy'
        aMap.clear()
        otherMap.clear()
    }

    @Ignore('no specific solution for this exercise')
    def 'zacne asercje i komunikaty, milordzie'() {
        given:
        def anObject = new Object()
        boolean aBoolean = false
        int aNumber = 5
        String aString = 'siała ciotka mak, nie wiedziała jak'
        String multilineString = """
<eshl0x> napisałem w piątek lesty do api
<eshlox> wszystkie przyszły
<eshlox> dz1ś odpalam i okowa nie działa
<wooboodoo> piątek był + nie chciały Ci weekendu psuć"""
        List aList = [1, 2, 123, 462, 6, 3]
        Map aMap = [one: 'o', two: 'ooo', eight: 'oooooooo']

        expect:
        anObject
        aBoolean
        aNumber == 10
        aString == 'siała baba mak, nie wiedziała jak'
        multilineString == """
<eshlox> napisałem w piątek testy do api
<eshlox> wszystkie przeszły
<eshlox> dziś odpalam i połowa nie działa
<wooboodoo> piątek był - nie chciały Ci weekendu psuć"""
        aList == [1, 2, 132, 462, 6, 3]
        aMap == [one: 'o', two: 'oo', eight: 'oooooooo']
    }
}
