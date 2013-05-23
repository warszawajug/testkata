package eu.solidcraft.testkata.domain.transaction;

import com.google.common.annotations.VisibleForTesting;
import org.bson.types.ObjectId;

public class TransactionAttempt {
    private ObjectId id;
    private String billerCode;
    private String msisdn;
    private String productCode;
    private TransactionStatus status;
    private Transaction successfulTransaction;

    private TransactionAttempt() {
    }

    public TransactionAttempt(String billerCode, String msisdn, String productCode) {
        this.billerCode = billerCode;
        this.msisdn = msisdn;
        this.productCode = productCode;
        this.status = TransactionStatus.IN_PROGRESS;
    }

    @VisibleForTesting public String getBillerCode() {
        return billerCode;
    }

    @VisibleForTesting public String getMsisdn() {
        return msisdn;
    }

    @VisibleForTesting public String getProductCode() {
        return productCode;
    }

    @VisibleForTesting public TransactionStatus getStatus() {
        return status;
    }

    @VisibleForTesting public Transaction getSuccessfulTransaction() {
        return successfulTransaction;
    }

    public void failure() {
        status = TransactionStatus.FAIL;
    }


    public void success(Transaction successfulTransaction) {
        status = TransactionStatus.SUCCESS;
        this.successfulTransaction = successfulTransaction;
    }
}
