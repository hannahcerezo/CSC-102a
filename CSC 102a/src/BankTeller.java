/*
Hannah Cerezo
CSC 102 Lab 7
11/17/21
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class BankTeller{

    public static HashMap<String, String> readFile() throws FileNotFoundException {
        // Read information from file that contains the users information. The users
        // information has to be in the exact order:
        // Username\n, password\n, Checking Account:\n, Balance of checking\n, Savings
        // Acount:\n, Balance of savings.
        // Put information into a hashmap and return the hashmap.
        HashMap<String, String> clientA = new HashMap<>();
        File myFile = new File("test.txt");
        Scanner myReader = new Scanner(myFile);
        String data = myReader.nextLine();
        clientA.put("Username", data);
        data = myReader.nextLine();
        clientA.put("Password", data);
        data = myReader.nextLine();
        clientA.put("Checking Account", data);
        data = myReader.nextLine();
        clientA.put("Checking Account Balance", data); // Checking account balance
        data = myReader.nextLine();
        clientA.put("Savings Account", data);
        data = myReader.nextLine();
        clientA.put("Savings Account Balance", data); // savings account balance
        myReader.close();

        return clientA;
    }

    public static void writeFile(String username, String pw, String checking_balance,
                                 String savings_balance){
        // Write the client information to a file
        try {
            FileWriter myWriter = new FileWriter("test.txt");
            myWriter.write(username+"\n"); // username
            myWriter.write(pw+"\n"); // password
            myWriter.write("Checking Account: \n"); // Checking Account
            myWriter.write(checking_balance+"\n"); // Checking Account balance
            myWriter.write("Savings Account: \n"); // Savings Account
            myWriter.write(savings_balance+"\n"); // Savings account balance
            myWriter.close();
        }catch(IOException e){
            System.out.println("Error. Cannot find file.");
            e.printStackTrace();
        }
        System.out.println("Writing to file");
    }

    public static boolean validateUser(HashMap<String,String> user_info,
                                       String user_input, String pw_input){
        String user = user_info.get("Username");
        String pw = user_info.get("Password");
        if (Objects.equals(user, user_input) && Objects.equals(pw, pw_input)){
            return true;
        }
        return false;
    }

    public static int currentAccountBalance(HashMap<String,String> user_info, String account_type){
        int int_balance = 0;
        String balance;
        if(account_type.equals("checking")){
            balance = user_info.get("Checking Account Balance");
            int_balance = Integer.parseInt(balance);
        }else if(account_type.equals("savings")){
            balance = user_info.get("Savings Account Balance");
            int_balance = Integer.parseInt(balance);
        }
        return int_balance;
    }

    // parse int. string to int
    public static void updateAccountBalance(HashMap<String, String> user_info,
                                            int new_balance, String account_type){
        String string_new_balance;
        if(account_type.equals("checking")) {
            string_new_balance = String.valueOf(new_balance);
            user_info.put("Checking Account Balance", string_new_balance);
        }else if(account_type.equals("savings")){
            string_new_balance = String.valueOf(new_balance);
            user_info.put("Savings Account Balance", string_new_balance);
        }
    }

    public static void updateAccountInfo(HashMap<String, String> user_info,
                                         String new_user_name, String new_pw){
        if(new_user_name != null){
            user_info.put("Username", new_user_name);
        }
        if(new_pw != null){
            user_info.put("Password", new_pw);
        }
    }

    // Driver function
    public static void main(String [] args) throws FileNotFoundException {

        HashMap<String, String> client_info = new HashMap<>();

        // read in a file. don't display contents. client_info is a hashMap
        client_info = readFile();

        // Scanner to take in user inputs
        Scanner kb = new Scanner(System.in);
        boolean logIn = true;

        // Enter username and password. Loop until they enter the correct information
        while (logIn) {
            System.out.println("Enter your username: ");
            String enterUserName = kb.next();
            kb.nextLine();

            System.out.println("Enter your password");
            String enterPW = kb.next();
            kb.nextLine();

            boolean signIn = validateUser(client_info, enterUserName, enterPW);

            if (signIn) {
                System.out.println("Log in successful");
                logIn = false;
            } else {
                System.out.println("User name or password is incorrect. Please try again");
            }
        }

        // create new instance of checking and savings accounts
        checkingAcct userCheckingAccount = new checkingAcct();
        savingsAcct userSavingsAccount = new savingsAcct();

        // These will be used multiple times as the user withdraws and deposits. create
        // outside to only create it once.
        int checking_balance;
        int savings_balance;

        // make variables for username, pw, checking balance, savings. These will be
        // updated as the user goes through the menu options. Then When they are all
        // done, their final data will be written to the file to be used another time
        String str_checking_balance = client_info.get("Checking Account Balance");
        String str_savings_balance = client_info.get("Savings Account Balance");
        String updated_username = client_info.get("Username");
        String updated_password = client_info.get("Password");

        boolean run_program = true;

        while(run_program) {
            // switch/case menu
            System.out.println("Select an option from the menu");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Update account information");
            System.out.println("5. Quit");
            String option = kb.next();
            kb.nextLine();

            String do_again;

            switch (option) {

                case ("1"): // Deposit

                    boolean make_deposit = true;

                    while (make_deposit) {
                        // Select which account to make a deposit
                        System.out.println("Which account would you like to deposit? 1. " + "Checking 2. Savings");
                        String deposit_account = kb.next();
                        kb.nextLine();
                        int deposit_amount;

                        if (deposit_account.equals("1")) {
                            // deposit into checking account.
                            System.out.println("How much would you like to deposit?");
                            deposit_amount = kb.nextInt();
                            kb.nextLine();
                            // get the current balance, this is an int
                            checking_balance =
                                    currentAccountBalance(client_info, "checking");

                            // This returns an int, the new balance after deposit
                            int deposit_checking_balance = userCheckingAccount.deposit(deposit_amount,
                                    checking_balance);

                            // need to update hashmap checking account balance. if the
                            // user is still logged in and updates this account
                            // further, it will go off whatever they just did.
                            updateAccountBalance(client_info, deposit_checking_balance,
                                    "checking");

                            // typeCast the new balance to a string so we can update the
                            // hashMap. will be used when the user logs out
                            str_checking_balance = String.valueOf(deposit_checking_balance);
                        } else if (deposit_account.equals("2")) {
                            // deposit into savings. Do the same thing from above but
                            // with savings
                            System.out.println("How much would you like to deposit?");
                            deposit_amount = kb.nextInt();
                            kb.nextLine();
                            savings_balance = currentAccountBalance(client_info, "savings");
                            int deposit_savings_balance = userSavingsAccount.deposit(deposit_amount,
                                    savings_balance);
                            updateAccountBalance(client_info, deposit_savings_balance,
                                    "savings");
                            str_savings_balance = String.valueOf(deposit_savings_balance);
                        } else {
                            System.out.println("You did not enter a valid option");
                        }

                        // Make another deposit? If they enter Y, then it will go
                        // back to the beginning asking which acct they want to
                        // deposit into
                        System.out.println(
                                "Would you like to make another deposit? Y or N");
                        do_again = kb.next();
                        kb.nextLine();

                        if (do_again.equals("N")) {
                            make_deposit = false;
                        }
                    }// end while

                    break;
                case ("2"): // Withdraw

                    // Select which account to withdraw
                    boolean make_withdraw = true;

                    while (make_withdraw) {
                        System.out.println("Which account would you like to withdraw from? 1. Checking 2. Savings");
                        String withdraw_account = kb.nextLine();
                        int withdraw_amount;
                        boolean withdraw_from_account;

                        if (withdraw_account.equals("1")) {
                            // Withdraw from the Checking account. Get how much they
                            // want to withdraw and check the balance.
                            withdraw_from_account = true;
                            while (withdraw_from_account) {
                                System.out.println(
                                        "How much would you like to withdraw?");
                                withdraw_amount = kb.nextInt();
                                checking_balance =
                                        currentAccountBalance(client_info, "checking");
                                int withdraw_checking_balance = 0;

                                // If what they want to withdraw is less than their
                                // current balance in the account, then do the
                                // withdrawal. If what they want to withdraw is more
                                // than their balance, let them know they have
                                // insufficient funds to withdraw and ask again
                                if (withdraw_amount < checking_balance) {
                                    withdraw_checking_balance =
                                            userCheckingAccount.withdrawal(withdraw_amount,
                                                    checking_balance);
                                    // update the hashmap balance to use for later
                                    updateAccountBalance(client_info,
                                            withdraw_checking_balance, "checking");
                                    // typecast the new balance to a string so that we
                                    // can update the hashmap/file at the end
                                    str_checking_balance = String.valueOf(withdraw_checking_balance);
                                    withdraw_from_account = false;
                                } else {
                                    System.out.println(
                                            "You do not have sufficient funds. \nAvailable balance: $" + checking_balance);
                                }
                            }
                        } else if (withdraw_account.equals("2")) {

                            // withdraw from savings, same process as the checking acct
                            withdraw_from_account = true;

                            while (withdraw_from_account) {
                                System.out.println("How much would you like to withdraw?");
                                withdraw_amount = kb.nextInt();
                                savings_balance =
                                        currentAccountBalance(client_info, "savings");
                                int withdraw_savings_balance = 0;

                                if (withdraw_amount < savings_balance) {
                                    withdraw_savings_balance = userSavingsAccount.withdrawal(withdraw_amount,
                                            savings_balance);
                                    updateAccountBalance(client_info,
                                            withdraw_savings_balance, "savings");
                                    str_savings_balance = String.valueOf(withdraw_savings_balance);
                                    withdraw_from_account = false;
                                } else {
                                    System.out.println(
                                            "You do not have sufficient funds. \nAvailable balance: $" + savings_balance);
                                    // ask again
                                }
                            }
                        } else {
                            // Didn't enter 1 or 2
                            System.out.println("You did not enter a valid option");
                        }

                        // Make another withdraw?
                        System.out.println(
                                "Would you like to make another withdrawal? Y or N");
                        do_again = kb.next();
                        kb.nextLine();

                        if (do_again.equals("N")) {
                            make_withdraw = false;
                        }
                    }

                    break;
                case ("3"): // Check account balance

                    System.out.println(
                            "Which account would you like to check the balance? " + "1." + " Checking 2. Savings");
                    // Probably put this in a loop
                    String balance_account = kb.next();
                    kb.nextLine();

                    if (balance_account.equals("1")) {
                        // check balance of checking
                        userCheckingAccount.checkBalance(client_info);
                    } else if (balance_account.equals("2")) {
                        // check balance of checking
                        userSavingsAccount.checkBalance(client_info);
                    } else {
                        System.out.println("You did not enter a valid option");
                    }

                    break;
                case ("4"): // Update user information

                    // create a function for this
                    // allow the user to update their username or password. match it to
                    // a flag. if it matches the flag, update the information
                    System.out.println(
                            "What information would you like to update? 1. " + "Username 2. Password");
                    String info_update = kb.next();
                    kb.nextLine();
                    boolean flag;

                    if (info_update.equals("1")) {
                        System.out.println("Enter your new username: ");
                        String new_username = kb.next();
                        kb.nextLine(); // clears buffer
                        flag = new_username.matches("\\w+");
                        // must be all letters, no special chars

                        if (!flag) {
                            System.out.println("Invalid entry");
                        } else {
                            updateAccountInfo(client_info, new_username, null);
                            updated_username = new_username;
                            System.out.println("Username has been updated");
                        }

                    } else if (info_update.equals("2")) {
                        // User wants to update the password. Get user input, save it
                        // to a String and then update it in the hashMap as long as it
                        // is at least 10 characters
                        String new_password = null;
                        boolean pw_update = true;

                        while(pw_update) {
                            System.out.println("Enter your new password that is at " +
                                    "least 10 characters long: ");
                            new_password = kb.nextLine();
                            // Flag will be true if the password is at least 10 chars
                            flag = new_password.matches(".{10}");

                            if(!flag) {
                                // If the password doesn't match, remind the user it hs
                                // to be at least 10  chars. if it does match, break
                                // out of the loop and update the information
                                System.out.println(
                                        "Your password must be at least 10 characters long");
                            }else{
                                pw_update = false;
                            }
                        }

                        updateAccountInfo(client_info, null, new_password);
                        updated_password = new_password;
                        System.out.println("Your password has been updated.");
                    }

                    break;
                case ("5"):
                    // The user wants to quit the menu, so break out of the loop.
                    run_program = false;
                    break;
            }
            // Update the information that was updated.
            writeFile(updated_username, updated_password, str_checking_balance,
                    str_savings_balance);
        }
    }
} // end bankTeller