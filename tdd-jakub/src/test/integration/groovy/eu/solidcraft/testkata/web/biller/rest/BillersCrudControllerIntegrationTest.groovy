package eu.solidcraft.testkata.web.biller.rest

import eu.solidcraft.testkata.IntegrationTest
import eu.solidcraft.testkata.domain.BillerRepository
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class BillersCrudControllerIntegrationTest extends IntegrationTest {
    @Autowired BillerRepository billerRepository
    BillersCrudController controller
    String billerName = "testBiller"

    @Before
    void createController() {
        controller = new BillersCrudController(billerRepository)
    }

    @Test
    void "should save biller"() {
        //when
        controller.create(billerName)

        //then
        billerRepository.findAll()?.first()?.name == billerName
    }
}
