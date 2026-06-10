public class AccountTransfer{
    public static void main(String[] args){
        
      SavingsAccount sa =  new SavingsAccount();
      sa.withdraw(200);
      
      CurrentAccount ca = new CurrentAccount();
      ca.withdraw(200);
      
      /*
      FixedDepositAccount fda = new FixedDepositAccount();
      fda.withdraw(200);
      
      catches at runtime itself
      */
 
    }
}


abstract class Account {
}


interface Withdrawable {
    void withdraw(double amount);
}

class SavingsAccount
        extends Account
        implements Withdrawable {

    public void withdraw(double amount) {
        System.out.println("Withdraw Success");
    }
}

class CurrentAccount
        extends Account
        implements Withdrawable {

    public void withdraw(double amount) {
        System.out.println("Withdraw Success");
    }
}

class FixedDepositAccount
        extends Account {
}
