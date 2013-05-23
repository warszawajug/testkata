package eu.solidcraft.testkata.web.payment.rest;

import eu.solidcraft.testkata.domain.biller.ExternalBillerService;
import eu.solidcraft.testkata.domain.transaction.Transaction;
import eu.solidcraft.testkata.domain.transaction.TransactionAttempt;
import eu.solidcraft.testkata.domain.transaction.TransactionAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Controller
public class BillPaymentController {
    private ExternalBillerService externalBillerService;
    private TransactionAttemptRepository transactionAttemptRepository;

    @Autowired
    public BillPaymentController(ExternalBillerService externalBillerService, TransactionAttemptRepository transactionAttemptRepository) {
        this.externalBillerService = externalBillerService;
        this.transactionAttemptRepository = transactionAttemptRepository;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces="application/json")
    public Map pay(@RequestParam("billedCode") String billedCode, @RequestParam("msisdn") String msisdn, @RequestParam("productCode") String productCode) {
        TransactionAttempt transactionAttempt = new TransactionAttempt(billedCode, msisdn, productCode);
        transactionAttemptRepository.save(transactionAttempt);

        HashMap response = newHashMap();
        if(externalBillerService.isPaymentPossible(billedCode, msisdn, productCode)) {
            Transaction transaction = new Transaction();
            transactionAttempt.success(transaction);
            response.put("status", "ok");
        } else {
            transactionAttempt.failure();
            response.put("status", "failure");
        }

        transactionAttemptRepository.save(transactionAttempt);
        return response;
    }
}
