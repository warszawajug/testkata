package eu.solidcraft.testkata.payment.rest
import eu.solidcraft.testkata.domain.BillerRepository
import eu.solidcraft.testkata.factories.BillerFactory
import eu.solidcraft.testkata.infrastructure.ExternalBillerServiceMock
import eu.solidcraft.testkata.IntegrationSpec
import eu.solidcraft.testkata.web.payment.rest.BillPaymentController
import org.springframework.beans.factory.annotation.Autowired

class BillPaymentIntegrationSpec extends IntegrationSpec {

    @Autowired BillPaymentController billPaymentController
    @Autowired BillerRepository billerRepository
    @Autowired ExternalBillerServiceMock externalBillerService

    def setup() {
        BillerFactory.createAndSaveBillerWithProduct(billerRepository)
    }

    def "should add fees to product price"() {

    }


    def "should order money transfer from core bank system"() {

    }


    def "should save successful transaction when money is transfered"() {

    }


    def "should send confirmation to biller when transaction is successful"() {

    }


    def "should save transaction attempt on failed transaction"() {

    }

}
