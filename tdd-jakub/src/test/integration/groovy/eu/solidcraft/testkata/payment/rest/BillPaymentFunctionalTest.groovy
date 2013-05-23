package eu.solidcraft.testkata.payment.rest

import eu.solidcraft.testkata.MvcIntegrationTest
import eu.solidcraft.testkata.domain.BillerRepository
import eu.solidcraft.testkata.domain.ExternalBillerService
import eu.solidcraft.testkata.factories.BillerFactory
import eu.solidcraft.testkata.infrastructure.ExternalBillerServiceMock
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class BillPaymentFunctionalTest extends MvcIntegrationTest {
    String JSON_MEDIA_TYPE = "application/json;charset=UTF-8"
    @Autowired BillerRepository billerRepository
    @Autowired ExternalBillerService externalBillerService

    @Before
    void setBillerFactory() {
        BillerFactory.createAndSaveBillerWithProduct(billerRepository)
    }

    @Test
    void "should return successful json to customer on payment success"() {
        //expect
        mockMvc.perform(post('/pay').
                param('billedCode', BillerFactory.CODE).
                param('msisdn', ExternalBillerServiceMock.CORRECT_MSISDN).
                param('productCode', BillerFactory.PRODUCT_CODE).
                accept(MediaType.parseMediaType(JSON_MEDIA_TYPE))).
                andExpect(status().isOk()).
                andExpect(content().contentType(JSON_MEDIA_TYPE)).
                andExpect(content().string('{"status":"ok"}'))
    }

    @Test
    void "should return failure json to customer on payment failure"() {
        //expect
        mockMvc.perform(post('/pay').
                param('billedCode', BillerFactory.CODE).
                param('msisdn', ExternalBillerServiceMock.WRONG_MSISDN).
                param('productCode', BillerFactory.PRODUCT_CODE).
                accept(MediaType.parseMediaType(JSON_MEDIA_TYPE))).
                andExpect(status().isOk()).
                andExpect(content().contentType(JSON_MEDIA_TYPE)).
                andExpect(content().string('{"status":"failure"}'))
    }
}
