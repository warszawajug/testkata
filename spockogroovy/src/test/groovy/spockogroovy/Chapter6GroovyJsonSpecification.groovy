package spockogroovy

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.sql.Sql
import spock.lang.Ignore
import spock.lang.Specification

// ref: http://groovy.codehaus.org/gapi/groovy/json/JsonBuilder.html
class Chapter6GroovyJsonSpecification extends Specification {

    JsonBuilder builder = new JsonBuilder()




    @Ignore("exercise: adjust 'when' block")
    def 'create simple JSON'() {

        given:
        Person personInstance = new Person('Anna', 24)
        Map addressMap = [city: 'Warsaw', country: 'Poland', zip: 12345]

        when:
        builder.person {
            name personInstance.name // skipped parenthesis, but it's a method call with single parameter
            age personInstance.age
        }

        then:
        builder.toString() == '{"person":{"name":"Anna","age":24,"address":{"city":"Warsaw","country":"Poland","zip":12345}}}'

    }




    @Ignore("exercise: adjust right side of the statement at 'when' block")
    def 'Generate JSON from list of objects'() {

        given:
        List personList = [new Person('Ana', 24), new Person('George', 41), new Person('Hugh', 32)]

        when:
        builder.content = [:]

        then:
        builder.toPrettyString() == '''{
    "people": [
        {
            "id": 0,
            "age": 24,
            "name": "Ana"
        },
        {
            "id": 0,
            "age": 41,
            "name": "George"
        },
        {
            "id": 0,
            "age": 32,
            "name": "Hugh"
        }
    ]
}'''
    }




    @Ignore("exercise: adjust right side of the statement at 'when' block")
    def 'generate JSON from database'() {

        given:
        def sql = Sql.newInstance('jdbc:h2:vehicles', 'sa', null, 'org.h2.Driver')
        def query = 'SELECT id AS "id", name as "name" FROM brand ORDER BY id'

        when:
        builder.content

        then:
        builder.toPrettyString() == '''{
    "brands": [
        {
            "id": 1,
            "name": "Ford"
        },
        {
            "id": 2,
            "name": "Mercedes"
        },
        {
            "id": 3,
            "name": "Subaru"
        },
        {
            "id": 4,
            "name": "Audi"
        },
        {
            "id": 5,
            "name": "BMW"
        }
    ]
}'''
    }




    @Ignore("exercise: add some code to the 'when' block")
    def 'generate JSON from database with column value as JSON key'() {

        given:
        def sql = Sql.newInstance('jdbc:h2:vehicles', 'sa', null, 'org.h2.Driver')
        def brandsQuery = 'SELECT id, name FROM brand ORDER BY id'
        def vehiclesQuery = 'SELECT id as "id", model as "model" FROM vehicle WHERE brand_id = ? ORDER BY id'

        when:
        builder.vehicles {
            sql.eachRow(brandsQuery) { brand ->
                // hint: obj."$variable"() can be used to dynamically call a method
            }
        }

        then:
        builder.toPrettyString() == '''{
    "vehicles": {
        "Ford": [
            {
                "id": 101,
                "model": "Focus"
            },
            {
                "id": 102,
                "model": "Mustang"
            }
        ],
        "Mercedes": [
            {
                "id": 103,
                "model": "CLK"
            }
        ],
        "Subaru": [
            {
                "id": 104,
                "model": "Legacy"
            }
        ],
        "Audi": [
            {
                "id": 105,
                "model": "A3"
            },
            {
                "id": 106,
                "model": "S5"
            },
            {
                "id": 107,
                "model": "RS8"
            }
        ]
    }
}'''
    }




    @Ignore("exercise: adjust 'when' block")
    def 'convert JSON to maps and lists'() {

        given:
        JsonSlurper slurper = new JsonSlurper()
        String jsonString = '''{
    "animals": [
        {
            "species": "horse",
            "race": "arabian",
            "age": 2
        },
        {
            "species": "cat",
            "race": "persian",
            "age": 4
        },
        {
            "species": "dog",
            "race": "husky",
            "age": 1
        }
    ]
}'''

        when:
        def json = slurper.parseText(jsonString)
        def animals // hint: json object is a Map already

        then:
        animals == [
                [species: 'horse', race: 'arabian', age: 2],
                [species: 'cat', race: 'persian', age: 4],
                [species: 'dog', race: 'husky', age: 1],
        ]
    }




    @Ignore("exercise: fill personList with objects from JSON at 'when' block")
    def 'convert JSON to objects'() {

        given:
        JsonSlurper slurper = new JsonSlurper()
        String jsonString = '''{
    "people": [
        {
            "age": 24,
            "name": "Ana"
        },
        {
            "age": 41,
            "name": "George"
        },
        {
            "age": 32,
            "name": "Hugh"
        }
    ]
}'''

        when:
        def json = slurper.parseText(jsonString)
        def personList = []
        // hint: named parameters can reduce necessary code amount

        then:
        personList == [new Person('Ana', 24), new Person('George', 41), new Person('Hugh', 32)] // Person class has customized equals() method
    }
}
