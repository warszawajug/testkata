package eu.solidcraft.testkata.web.biller.rest

import eu.solidcraft.testkata.domain.Biller
import eu.solidcraft.testkata.domain.BillerRepository
import eu.solidcraft.testkata.MvcIntegrationTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class BillersCrudControllerMvcTest extends MvcIntegrationTest {
    @Autowired BillerRepository billerRepository
    String billerName = "testBiller"
    String billerCode = "testBillerCode"

    @Test
    void "should return billers"() {
        //given
        billerExist()

        //expect
        mockMvc.perform(get('/billers').accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json;charset=UTF-8")).
                andExpect(jsonPath('$.billerList[0].name').value(billerName))
    }

    @Test
    void "should save biller"() {
        //given
        billerExist()

        //expect
        mockMvc.perform(post('/billers').param('name', billerName).accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json;charset=UTF-8")).
                andExpect(jsonPath('$.biller.name').value(billerName))
    }

    private void billerExist() {
        billerRepository.save(new Biller(billerCode, billerName, []))
    }
}
