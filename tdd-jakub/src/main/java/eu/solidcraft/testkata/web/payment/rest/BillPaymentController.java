package eu.solidcraft.testkata.web.payment.rest;

import eu.solidcraft.testkata.domain.ExternalBillerService;
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
    ExternalBillerService externalBillerService;

    @Autowired
    public BillPaymentController(ExternalBillerService externalBillerService) {
        this.externalBillerService = externalBillerService;
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces="application/json")
    public Map pay(@RequestParam("billedCode") String billedCode, @RequestParam("msisdn") String msisdn, @RequestParam("productCode") String productCode) {
        HashMap response = newHashMap();
        if(externalBillerService.isPaymentPossible(billedCode, msisdn, productCode)) {
            response.put("status", "ok");
        } else {
            response.put("status", "failure");
        }
        return response;
    }
}
