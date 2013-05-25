package spockogroovy

import groovy.sql.Sql
import groovy.util.slurpersupport.NodeChild
import groovy.xml.MarkupBuilder
import org.xml.sax.XMLReader
import spock.lang.Specification

class Chapter5GroovyXmlSpecification extends Specification {

    def writer = new StringWriter()
    def xml = new MarkupBuilder(writer)

    def setup() {
        xml.doubleQuotes = true
    }




    def 'creating RSS feed'() {

        given: 'example with list of maps, but any other objects can be used'
        def articles = [
                [title: 'Article 1', brief: 'some text about article 1', url: 'http://url.to.article1'],
                [title: 'Article 2', brief: 'some text about article 2', url: 'http://url.to.article2'],
                [title: 'Article 3', brief: 'some text about article 3', url: 'http://url.to.article3']
        ]

        when:
        xml.rss(version: '2.0') {
            channel {
                title('The RSS Title')
                link('http://url.to.the.website.com')
                description('The Groovy generated feed :)')
                articles.each { article ->
                    xml.item {
                        title(article.title)
                        link(article.url)
                        description(article.brief)
                    }
                }
            }
        }

        then: // hint: check Idea's <Click to see difference> at test result
        writer as String == '''<rss version="2.0">
  <channel>
    <title>The RSS Title</title>
    <link>http://url.to.the.website.com</link>
    <description>The Groovy generated feed :)</description>
    <item>
      <title>Article 1</title>
      <link>http://url.to.article1</link>
      <description>some text about article 1</description>
    </item>
    <item>
      <title>Article 2</title>
      <link>http://url.to.article2</link>
      <description>some text about article 2</description>
    </item>
    <item>
      <title>Article 3</title>
      <link>http://url.to.article3</link>
      <description>some text about article 3</description>
    </item>
  </channel>
</rss>'''
    }




    def 'generate XML from database'() {

        given:
        def sql = Sql.newInstance('jdbc:h2:vehicles', 'sa', null, 'org.h2.Driver')
        def query = '''SELECT vehicle.id, model, brand_id, name AS brand FROM vehicle INNER JOIN brand
                        ON (vehicle.brand_id = brand.id) ORDER BY id'''

        when:
        xml.vehicles {
            sql.eachRow(query) { row ->
                xml.vehicle(id: row.id, model: row.model) {
                    brand(id: row['brand_id'], row.brand)
                }
            }
        }

        then:
        writer as String == '''<vehicles>
  <vehicle id="101" model="Focus">
    <brand id="1">Ford</brand>
  </vehicle>
  <vehicle id="102" model="Mustang">
    <brand id="1">Ford</brand>
  </vehicle>
  <vehicle id="103" model="CLK">
    <brand id="2">Mercedes</brand>
  </vehicle>
  <vehicle id="104" model="Legacy">
    <brand id="3">Subaru</brand>
  </vehicle>
  <vehicle id="105" model="A3">
    <brand id="4">Audi</brand>
  </vehicle>
  <vehicle id="106" model="S5">
    <brand id="4">Audi</brand>
  </vehicle>
  <vehicle id="107" model="RS8">
    <brand id="4">Audi</brand>
  </vehicle>
</vehicles>'''
    }




    def 'process RSS feed into list of maps'() {

        given:
        def xmlFile = new File('src/test/resources/touk-rss-feed.xml')
        def rss = new XmlParser().parse(xmlFile) // http url can be used directly here
        def result = []

        when:
        rss.channel.item.each {
            result << [
                    title: it.title.text(),
                    url: it.link.text(),
                    about: it.description.text()
            ]
        }
        def rssVersion = rss.@version

        then:
        result == [
                [
                        title: 'Inconsistent Dependency Injection to domains with Grails',
                        url: 'http://touk.pl/blog/en/2012/10/18/inconsistent-dependency-injection-to-domains-with-grails/?utm_source=rss&utm_medium=rss&utm_campaign=inconsistent-dependency-injection-to-domains-with-grails',
                        about: 'I\'ve encountered strange behavior with a domain class in my project: services that should be injected were null. I\'ve became suspicious as why is that? Services are injected properly in other domain classes so why this one is different? Constructors ex...'
                ],
                [
                        title: 'Friends with benefits',
                        url: 'http://touk.pl/blog/en/2012/10/15/friends-with-benefits/?utm_source=rss&utm_medium=rss&utm_campaign=friends-with-benefits',
                        about: 'Back when I was at my first university, working on my B.Sc., it was obvious for us, students, to always try to get into any possible, open IT event in the town. We were hungry for knowledge, for experience, anxious looking at the future. \n\nOne of the ...'
                ],
                [
                        title: 'Scrum in Poland – TouK',
                        url: 'http://touk.pl/blog/en/2012/10/09/scrum-in-poland-touk/?utm_source=rss&utm_medium=rss&utm_campaign=scrum-in-poland-touk',
                        about: 'TouK case study regarding Scrum adoption in Polish companies has just been published by our colleagues from Fluidcircle.'
                ]
        ]
        rssVersion == '2.0'

    }




    def 'calculate average value from HTML table'() {

        given:
        File htmlFile = new File('src/test/resources/euro-pln-historical-exchange-rates.html')
        XMLReader parser = new org.ccil.cowan.tagsoup.Parser() // TagSoup SAXParser handles even malformed HTML
        XmlSlurper slurper = new XmlSlurper(parser) // XmlSlurper is like XmlParser but 'lazy-parsing' so less resources hungry
        NodeChild html = slurper.parse(htmlFile)

        when:
        def tableRows = html.body.table[3].tr.td.table[2].tr
        tableRows = tableRows[1..tableRows.size() - 1] // removing table header
        List exchangeRates = tableRows.collect { NodeChild node ->
            node.td[1].text().toFloat()
        }
        float averageExchangeRate = exchangeRates.sum() / exchangeRates.size()


        then:
        exchangeRates.size() == 130
        averageExchangeRate == 4.18601f
    }
}