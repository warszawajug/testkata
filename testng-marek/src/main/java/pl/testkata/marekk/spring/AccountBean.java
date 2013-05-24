package pl.testkata.marekk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.testkata.marekk.Person;

/**
 * User: marekkapowicki
 */
@Component
public class AccountBean {


    private  String no;
    @Autowired
    private  PersonBean owner;

    private long balance;

    public AccountBean() {}

    public synchronized void deposit(long amount) {
        this.balance +=amount;
    }
    public synchronized void withdraw(long amount) {
        if (amount > balance) {
            throw new IllegalStateException("too less money");
        }
        this.balance -= amount;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public PersonBean getOwner() {
        return owner;
    }

    public void setOwner(PersonBean owner) {
        this.owner = owner;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
