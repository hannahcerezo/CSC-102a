import java.util.HashMap;

class savingsAcct implements BankAcctInt{

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

    @Override
    public int withdrawal(int wd_amt, int balance) {

        int new_balance = balance - wd_amt;
        System.out.println("Withdrawal successful. New balance: $" + new_balance);

        return new_balance;
    }

    @Override
    public void checkBalance(HashMap<String, String> userInfo) {

        String get_savings_balance = userInfo.get("Savings Account Balance");
        int savings_balance = Integer.parseInt(get_savings_balance);
        System.out.println("Savings Account Balance: $" + savings_balance);

    }

    @Override
    public void transferMoney() {
        throw new UnsupportedOperationException("Unsupported operation");
    }

}
