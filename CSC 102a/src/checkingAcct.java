import java.util.HashMap;

public class checkingAcct implements BankAcctInt{
    // implement bankAct interface

    // deposit $ into acct. deposit limit $5000
    @Override
    public int deposit(int dep_amt, int balance) {
        int new_balance;
        if(dep_amt <= 5000) {
            new_balance = dep_amt + balance;
            System.out.println("Deposit successful. New balance: $" + new_balance);
            return new_balance;
        }else{
            System.out.println("Deposit amount must be less than or equal to $5,000.");
        }
        return balance;
    }

    // withdraw $ from acct. no overdrafts
    @Override
    public int withdrawal(int wd_amt, int balance) {

        // if the withdrawal amount is less than the balance, we won't have overdraft

        int new_balance = balance - wd_amt;
        System.out.println("Withdrawal successful. New balance: $" + new_balance);

        return new_balance;
    }

    // check balance
    @Override
    public void checkBalance(HashMap<String, String> userInfo) {

        String get_checking_balance = userInfo.get("Checking Account Balance");
        int checking_balance = Integer.parseInt(get_checking_balance);
        System.out.println("Checking Account Balance: $" + checking_balance);

    }

    // Make this into money transfer maybe?? - update in the interface as well.
    @Override
    public void transferMoney() {
        throw new UnsupportedOperationException("Unsupported Operation");
    }
}