package eu.solidcraft.testkata.factories
import eu.solidcraft.testkata.domain.biller.Biller
import eu.solidcraft.testkata.domain.biller.BillerRepository
import eu.solidcraft.testkata.domain.biller.Product

import static org.springframework.util.Assert.notNull

class BillerFactory {
    static final String CODE = 'code'
    static final String NAME = 'Joe Zpolski'
    static final String PRODUCT_CODE = 'productCode'
    static final BigDecimal PRODUCT_PRICE = BigDecimal.ONE

    static Biller createAndSaveBillerWithProduct(BillerRepository billerRepository) {
        notNull(billerRepository)
        List<Product> products = [new Product(PRODUCT_CODE, PRODUCT_PRICE)]
        Biller biller = new Biller(CODE, NAME, products)
        return billerRepository.save(biller)
    }
}
