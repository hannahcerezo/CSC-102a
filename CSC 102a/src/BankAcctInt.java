import java.util.HashMap;

public interface BankAcctInt {

    public int deposit(int dep_amt, int balance);

    public int withdrawal(int wd_amt, int balance);

    public void checkBalance(HashMap<String, String> userInfo);

    public void transferMoney();

}
