package eu.solidcraft.testkata.domain.biller;

public interface ExternalBillerService {
    boolean isPaymentPossible(String billedCode, String msisdn, String productCode);
}
