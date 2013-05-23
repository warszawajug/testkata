package eu.solidcraft.testkata
import eu.solidcraft.testkata.domain.biller.Biller
import org.junit.After
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ["classpath:/spring/ioc.xml"])
abstract class IntegrationTest {
    @Autowired
    protected MongoTemplate mongoTemplate

    @After
    void cleanMongo() {
        mongoTemplate.dropCollection(Biller.class)
    }

}
