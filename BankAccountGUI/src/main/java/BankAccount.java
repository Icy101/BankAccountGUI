import java.lang.Math;
import java.time.LocalDateTime;
import java.lang.Math;



public class BankAccount{
    //Creating Instance Variables
    String accountNumber;
    double balance;
    double withdrawalFee;
    double annualInterestRate;
    double balanceABS;

    //  for all instance variables
    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public double getWithdrawalFee(){
        return withdrawalFee;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    //mutators for annualInterestRate and withdrawalFee
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public void setWithdrawalFee(double withdrawalFee){
        this.withdrawalFee = withdrawalFee;
    }

    // constructor 1
    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    //constructor 2
    public BankAccount(String accountNumber, double newBalance){
        this.accountNumber = accountNumber;
        this.balance = newBalance;
    }

    // constructor 3 including accountNumber, balance, withdrawalFee, and annualInterestRate
    public BankAccount(String accountNumber, double balance, double withdrawalFee,    double annualInterestRate){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.withdrawalFee = withdrawalFee;
        this.annualInterestRate = annualInterestRate;
    }
    // public method to deposit money into the account
    void deposit(double amount){
        balance +=  amount;
    }
    // public method to withdraw money from the account
    void withdraw(double amount){
        balance -= amount;
        balance -= withdrawalFee;
    }
    // if the balance is less than 0, returns true
    boolean isOverDrawn(){
        if (balance < 0){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){

        if (!isOverDrawn()){
            return String.format("$%.2f", balance);
        }

        else {
            double balanceABS = Math.abs(balance);
            return String.format("($%.2f)", balanceABS);
        }
    }
}




