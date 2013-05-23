package eu.solidcraft.testkata.infrastructure;

import eu.solidcraft.testkata.domain.biller.ExternalBillerService;

public class ExternalBillerServiceMock implements ExternalBillerService {
    public final static String CORRECT_MSISDN = "1324657987";
    public final static String WRONG_MSISDN = "6546465465";


    @Override
    public boolean isPaymentPossible(String billedCode, String msisdn, String productCode) {
        return CORRECT_MSISDN.equals(msisdn);
    }
}
