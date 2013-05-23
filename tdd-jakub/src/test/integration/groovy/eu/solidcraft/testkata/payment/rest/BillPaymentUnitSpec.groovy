package eu.solidcraft.testkata.payment.rest
import eu.solidcraft.testkata.domain.ExternalBillerService
import eu.solidcraft.testkata.factories.BillerFactory
import eu.solidcraft.testkata.web.payment.rest.BillPaymentController
import spock.lang.Specification

class BillPaymentUnitSpec extends Specification {
    BillPaymentController billPaymentController
    String msisdn = "some msisdn"

    def "should check if payment is possible on external biller system"() {
        given:
            ExternalBillerService externalBillerService = Mock(ExternalBillerService)
            billPaymentController = new BillPaymentController(externalBillerService)

        when:
            billPaymentController.pay(BillerFactory.CODE, msisdn, BillerFactory.PRODUCT_CODE)

        then:
            1 * externalBillerService.isPaymentPossible(BillerFactory.CODE, msisdn, BillerFactory.PRODUCT_CODE)
    }

}
