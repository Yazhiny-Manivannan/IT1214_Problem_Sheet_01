class BankAccount {
	private int accountNumber;
	private String accountHolder;
	private double balance;
	
	BankAccount(int accountNumber, String accountHolder, double balance){
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}
	
	public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

	public void setBalance(double balance) {
        this.balance = balance;
    }
	
    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException{
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int count;

    Bank() {
        accounts = new BankAccount[5];  
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
        } else {
            System.out.println("Bank account limit reached.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                found = true;
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("\nWithdrawn " + amount + " from account " + accountNumber);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Account number " + accountNumber + " not found.");
        }
    }

    public void displayAllAccounts() {
        System.out.println("\nAll Bank Accounts:");
        for (int i = 0; i < count; i++) {
            BankAccount acc = accounts[i];
            System.out.println("Account No: " + acc.getAccountNumber() + ", Holder: " + acc.getAccountHolder() + ", Balance: " + acc.getBalance());
        }
    }
}


class MainBank {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        // Add accounts
        myBank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        myBank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        // Try withdrawals
        myBank.withdrawFromAccount(1001, 6000.0);  // should cause an exception
        myBank.withdrawFromAccount(1002, 1000.0);  // successful

        // Display all accounts
        myBank.displayAllAccounts();
    }
}
