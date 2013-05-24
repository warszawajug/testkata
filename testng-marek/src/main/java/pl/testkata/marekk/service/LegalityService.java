package pl.testkata.marekk.service;

import pl.testkata.marekk.Account;

/**
 * must response very quickly
 */
public class LegalityService {

    public boolean isAccountLegal(Account account) {
        //TODO empty body
//        slowMethod();
        return true;
    }

    private void slowMethod()  {
        try {
            Thread.sleep(1007);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
