package eu.solidcraft.testkata

import eu.solidcraft.testkata.domain.biller.Biller
import eu.solidcraft.testkata.domain.transaction.TransactionAttempt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(locations = ["classpath:/spring/ioc.xml", "classpath:/spring/webmvc.ioc.xml"])
abstract class IntegrationSpec extends Specification {
    @Autowired protected MongoTemplate mongoTemplate

    def cleanup() {
        mongoTemplate.dropCollection(Biller.class)
        mongoTemplate.dropCollection(TransactionAttempt.class)
    }
}
