package pl.testkata.marekk;

/**
 * class represents bank account
 * class with bug
 */
public class Account {
    private final String no;
    private final Person owner;
    private long balance;
	public Account(String no, Person owner, Long initAmount) {
		this.no = no;
        this.owner = owner;
		this.balance = initAmount;
	}
	public void deposit(long amount) {
        validateAmount(amount);
		this.balance +=amount;
	}
	public void withdraw(long amount) {
		validateAmount(amount);
        if (amount > balance) {
			throw new IllegalStateException("too less money");
		}
		this.balance -= amount;
	}

    public long getBalance() {
		return balance;
	}

    public Person getOwner() {
        return owner;
    }

    private void validateAmount(long amount) {
        if (amount < 0) {
            throw new IllegalStateException("amount must be positive number");
        }
    }
}
