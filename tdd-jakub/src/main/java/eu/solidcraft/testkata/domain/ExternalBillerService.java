package eu.solidcraft.testkata.domain;

public interface ExternalBillerService {
    boolean isPaymentPossible(String billedCode, String msisdn, String productCode);
}
