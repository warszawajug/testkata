package spockogroovy

import groovy.sql.Sql
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

/**
 * DB structure and default values are defined in test/resources/*.sql.
 * To (re)create database run gradle h2start
 * To run web DB console run gradle jettyRun
 */
class Chapter4GroovySqlSpecification extends Specification {

    @Shared Sql sql = Sql.newInstance('jdbc:h2:vehicles', 'sa', null, 'org.h2.Driver')

    def setupSpec() {
        sql.connection.autoCommit = false
    }

    def cleanup() {
        sql.rollback()
    }




    @Ignore("exercise: adjust Closure body at 'when' block")
    def 'select multiple rows'() {

        given:
        def brandNames = []
        String query = 'SELECT id, name FROM brand ORDER BY name'

        when:
        sql.eachRow(query) {

        }

        then:
        brandNames == ['Audi', 'BMW', 'Ford', 'Mercedes', 'Subaru']
    }




    @Ignore('exercise: adapt SQL query with WHERE clause')
    def 'select one row with GString (SQL injection safe!)'() {

        given:
        def query = "SELECT id, name FROM brand " // hint: $ variable may be helpful

        when:
        def row = sql.firstRow(query)

        then:
        row?.id == brandId
        query instanceof GString

        where:
        brandId | brandName
        1       | 'Ford'
        2       | 'Mercedes'
        null    | /Ford' AND 1=(SELECT COUNT(*) FROM users); --/ // hint: 'SQLException: Table "USERS" not found' will be thrown if SQL injection has succeed :(
    }




    @Ignore('exercise: adapt SQL query')
    def 'select a single value'() {

        given:
        String query = 'SELECT COUNT (id) FROM vehicle' // hint: use SQL 'AS' keyword

        when:
        def row = sql.firstRow(query)

        then:
        row.amount == 7
    }




    @Ignore("exercise: adapt executeInsert() method call at 'when' block")
    def 'insert a row with parameters list'() {

        given:
        int rowCount = countRowsOfTable('vehicle')
        String query = 'INSERT INTO vehicle(model, released, brand_id) VALUES(?, ?, ?)' // hint: question mark is parameter placeholder
        Date released = new Date()
        int brandId = findBrandIdByName('Subaru')
        String model = 'Impreza'

        when:
        sql.executeInsert(query)

        then:
        countRowsOfTable('vehicle') == rowCount + 1
    }




    @Ignore('exercise: adapt SQL query with VALUES clause')
    def 'insert a row with named parameters'() {

        given:
        int rowCount = countRowsOfTable('vehicle')
        def query = 'INSERT INTO vehicle(model, released, brand_id) VALUES(:model, :released, :brandId)' // hint: there is notation like :paramName
        def params = [
                brandId: findBrandIdByName('Ford'),
                model: 'Puma',
                released: new Date()
        ]

        when:
        sql.executeInsert(query, params)

        then:
        countRowsOfTable('vehicle') == rowCount + 1

    }




    @Ignore("exercise: call proper method on sql object at 'when' block")
    def 'delete a single row'() {

        given:
            int rowCount = countRowsOfTable('brand')
            int vehicleId = 5
            String query = 'DELETE FROM brand WHERE id = ?'

        when:
        sql

        then:
            countRowsOfTable('brand') == rowCount - 1
    }



    // helper methods
    private int countRowsOfTable(String tableName) {
        def row = sql.firstRow('SELECT COUNT(ID) FROM ' + tableName)
        row[0]
    }

    private int findBrandIdByName(String name) {
        def row = sql.firstRow("SELECT ID FROM BRAND WHERE NAME = $name")
        row.id
    }
}
