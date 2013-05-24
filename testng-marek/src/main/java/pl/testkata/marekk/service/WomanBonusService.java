package pl.testkata.marekk.service;

import bsh.StringUtil;
import org.apache.commons.lang.StringUtils;
import pl.testkata.marekk.Account;
import pl.testkata.marekk.Person;

/**
 * used to add amount
 * to women account
 */
public class WomanBonusService {
    public static final long BONUS_AMOUNT = 10;
    public void process(Account account) {
        if (account == null) {
            return;
        }

        if (isWomen(account.getOwner())) {
            account.deposit(BONUS_AMOUNT);
        }
    }
    private boolean isWomen(Person person) {
        if (person == null || StringUtils.isBlank(person.getFirstName())) {
            return false;
        }
        return StringUtils.endsWith(person.getFirstName(), "a");
    }
}
