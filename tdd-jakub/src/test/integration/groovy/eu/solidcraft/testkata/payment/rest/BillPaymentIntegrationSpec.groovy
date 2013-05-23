package eu.solidcraft.testkata.payment.rest
import eu.solidcraft.testkata.IntegrationSpec
import eu.solidcraft.testkata.domain.biller.BillerRepository
import eu.solidcraft.testkata.domain.transaction.Transaction
import eu.solidcraft.testkata.domain.transaction.TransactionAttempt
import eu.solidcraft.testkata.domain.transaction.TransactionAttemptRepository
import eu.solidcraft.testkata.domain.transaction.TransactionStatus
import eu.solidcraft.testkata.factories.BillerFactory
import eu.solidcraft.testkata.infrastructure.ExternalBillerServiceMock
import eu.solidcraft.testkata.web.payment.rest.BillPaymentController
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Unroll

class BillPaymentIntegrationSpec extends IntegrationSpec {

    @Autowired BillPaymentController billPaymentController
    @Autowired BillerRepository billerRepository
    @Autowired ExternalBillerServiceMock externalBillerService
    @Autowired TransactionAttemptRepository transactionAttemptRepository

    def setup() {
        BillerFactory.createAndSaveBillerWithProduct(billerRepository)
    }

    def "should save successful transaction when money is transfered"() {
        when:
            billPaymentController.pay(BillerFactory.CODE, ExternalBillerServiceMock.CORRECT_MSISDN, BillerFactory.PRODUCT_CODE)
        then:
            TransactionAttempt savedTransactionAttempt = getTransactionAttempt()
            savedTransactionAttempt.successfulTransaction instanceof Transaction
    }

    @Unroll
    def "should save transaction attempt with status #status on #name transaction"() {
        when:
           billPaymentController.pay(BillerFactory.CODE, msisdn, BillerFactory.PRODUCT_CODE)
        then:
            TransactionAttempt savedTransactionAttempt = getTransactionAttempt()
            hasPostedProperties(savedTransactionAttempt)
            savedTransactionAttempt.status == status;
        where:
            msisdn                                   | status                    | name
            ExternalBillerServiceMock.WRONG_MSISDN   | TransactionStatus.FAIL    | 'failed'
            ExternalBillerServiceMock.CORRECT_MSISDN | TransactionStatus.SUCCESS | 'succesfull'
    }

    private TransactionAttempt getTransactionAttempt() {
        return transactionAttemptRepository.findAll()?.first()
    }

    private void hasPostedProperties(TransactionAttempt savedTransactionAttempt) {
        savedTransactionAttempt.billerCode == BillerFactory.CODE
        savedTransactionAttempt.msisdn == ExternalBillerServiceMock.WRONG_MSISDN
        savedTransactionAttempt.productCode == BillerFactory.PRODUCT_CODE
    }

    def "should add fees to product price"() {

    }


    def "should order money transfer from core bank system"() {

    }


    def "should send confirmation to biller when transaction is successful"() {

    }
}
